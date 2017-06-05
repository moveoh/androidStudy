package com.example.han.management;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by HAN on 2017-06-05.
 */

//StringRequest를 상속받아 사용
public class RegisterRequest extends StringRequest {

    //Register php주소 연결
    final static private String URL = "http://http://192.168.0.4/Register.php";

    private Map<String, String> parameters;

    public RegisterRequest(String userId, String userPassword, String userName, int userAge, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);
        parameters=new HashMap<>();
        parameters.put("userId", userId);
        parameters.put("userPassword", userPassword);
        parameters.put("userName", userName);
        //나이는 int형이기에 문자열을 붙여서 문자열로 형변환한다
        parameters.put("userAge", userAge+"");
    }

    @Override
    public Map<String, String> getParams(){
        return parameters;
    }
}
