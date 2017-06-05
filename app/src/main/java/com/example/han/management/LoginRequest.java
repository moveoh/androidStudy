package com.example.han.management;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by HAN on 2017-06-05.
 */

//StringRequest를 상속받아 사용
public class LoginRequest extends StringRequest {

    //Register php주소 연결
    final static private String URL = "http://http://192.168.0.4/Login.php";

    private Map<String, String> parameters;

    public LoginRequest(String userId, String userPassword, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);
        parameters=new HashMap<>();
        parameters.put("userId", userId);
        parameters.put("userPassword", userPassword);
    }

    @Override
    public Map<String, String> getParams(){
        return parameters;
    }
}
