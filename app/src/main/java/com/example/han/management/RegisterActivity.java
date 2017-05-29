package com.example.han.management;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {
    //회원가입과 관련된 액티비티
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        EditText idText = (EditText)findViewById(R.id.idText);
        EditText passwordText = (EditText)findViewById(R.id.passwordText);
        EditText nameText = (EditText)findViewById(R.id.nameText);
        EditText ageText = (EditText)findViewById(R.id.ageText);

        Button registerButton = (Button) findViewById(R.id.registerButton);

    }
}
