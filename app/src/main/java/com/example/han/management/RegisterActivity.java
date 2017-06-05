package com.example.han.management;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

//RegisterRequest 작성 후 매니패스트 작성 후 일로 넘어온다.
public class RegisterActivity extends AppCompatActivity {
    //회원가입과 관련된 액티비티
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //외부메서드의 변수를 사용해야할 경우 final을 붙여서 더이상 변수값을 변하지 않게 만들어줘야한다.
        final EditText idText = (EditText)findViewById(R.id.idText);
        final EditText passwordText = (EditText)findViewById(R.id.passwordText);
        final EditText nameText = (EditText)findViewById(R.id.nameText);
        final EditText ageText = (EditText)findViewById(R.id.ageText);

        Button registerButton = (Button)findViewById(R.id.registerButton2);


        registerButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Log.d("test","클릭진입");
                String userId=idText.getText().toString();
                String userPassword = passwordText.getText().toString();
                String userName = nameText.getText().toString();
                //문자열을 숫자로 바꿔주는 형태. 아까 =""으로 문자형으로 바꿨으니 다시 정수형으로..
                int userAge = Integer.parseInt(ageText.getText().toString());
                Log.d("test",userId);
                Log.d("test",userPassword);
                Log.d("test",userName);

                Response.Listener<String> responseListener = new Response.Listener<String>(){

                    @Override
                    public void onResponse(String response){
                        try
                        {
                            //success라는 결과가왔을때 success에 결과를 넣는다.
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            //가입성공  2.reponse받었을떄 정상적인결과면 회원등록에 성공 하고 인탠트를 생성해준다.
                            if(success){
                                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                builder.setMessage("회원 등록에 성공했습니다.")
                                        .setPositiveButton("확인",null)
                                        .create()
                                        .show();
                                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                RegisterActivity.this.startActivity(intent);
                            }
                            //가입실패
                            else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                builder.setMessage("회원 등록에 실패했습니다.")
                                        .setNegativeButton("다시 시도",null)
                                        .create()
                                        .show();
                            }
                        }
                        catch(JSONException e)
                        {
                            e.printStackTrace();
                        }
                    }

                };
                RegisterRequest registerRequest = new RegisterRequest(userId,userPassword,userName,userAge,responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                //1.버튼클릭시 registerRequest가 실행이 되어서 위의 onResponse를 받게되고
                queue.add(registerRequest);
            }
        });
    }
}
