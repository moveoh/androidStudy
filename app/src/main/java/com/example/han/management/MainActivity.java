package com.example.han.management;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //xml에 있는 모든 버튼을 컨트롤할 수 있도록 할당 해준다.
        TextView idText = (EditText)findViewById(R.id.idText);
        TextView passwordText = (EditText)findViewById(R.id.passwordText);
        TextView welcomeMessage = (TextView)findViewById(R.id.welcomeMessage);

        Intent intent = getIntent();
        String userId = intent.getStringExtra("userId");
        String userPassword= intent.getStringExtra("userPassword");
        String message ="환영합니다, " + userId + "님!";

        idText.setText(userId);
        passwordText.setText(userPassword);
        welcomeMessage.setText(message);
    }
}
