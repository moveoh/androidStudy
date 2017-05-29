package com.example.han.management;

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
        EditText idText = (EditText)findViewById(R.id.idText);
        EditText passwordText = (EditText)findViewById(R.id.passwordText);
        TextView welcomeMessage = (TextView)findViewById(R.id.welcomeMessage);
    }
}
