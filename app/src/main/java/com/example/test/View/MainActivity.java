package com.example.test.View;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.test.Connect.API;
import com.example.test.Connect.RetrofitClient;
import com.example.test.Model.User;
import com.example.test.Presenter.IPresenterLogicDangNhap;
import com.example.test.R;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PrimitiveIterator;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity implements ViewDangNhap {
    private EditText edt_name;
    private EditText edt_password;
    private Button btn_an;
    private  boolean status;
    String name01, pass01;
    User user;


    IPresenterLogicDangNhap iPresenterLogicDangNhap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_name = findViewById(R.id.edt_name);
        edt_password = findViewById(R.id.edt_password);
        btn_an = findViewById(R.id.btn_an);
        iPresenterLogicDangNhap = new IPresenterLogicDangNhap(this);

        btn_an.setOnClickListener(new View.OnClickListener() {  ////Button click event
            @Override
            public void onClick(View v) {
                logintest();
//                if(validate(edt_name) && validate(edt_password)) {
//                    login(edt_name.getText().toString(), edt_password.getText().toString());
//                }


//                LoginCheck(edt_name.getText().toString(),edt_password.getText().toString());
            }
        });

    }
    

    public  void logintest(){
        name01 = edt_name.getText().toString();
        pass01 = edt_password.getText().toString();
        if(name01.length() > 0 && pass01.length() > 0){
            Call<List<User>> call =RetrofitClient.getClient().userlogin(name01, pass01);
            call.enqueue(new Callback<List<User>>() {
                @Override
                public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                    ArrayList<User>  arrayList = (ArrayList<User>)response.body();
                    if(arrayList.size() >= 0 ){
                        Log.d("BBBBB", arrayList.get(0).getName() + " + " + arrayList.get(0).getPassword());
                        iPresenterLogicDangNhap.DangNhapThanhCong();
                    }
                }

                @Override
                public void onFailure(Call<List<User>> call, Throwable t) {
                    Toast.makeText(getApplicationContext(),"NONONONO", Toast.LENGTH_SHORT).show();
                }
            });

        }

    }

//
//    public void login(String name, String pass) {
//
//        Call<User> call  = RetrofitClient.getClient().userlogin(name, pass);
//        call.enqueue(new Callback<User>() {
//            @Override
//            public void onResponse(Call<User> call, Response<User> response) {
//
//
//                if (response.isSuccessful()) {
//                    try {
//
//                        User result = response.body();
//                        Log.d("amc", name + " + " + user.getName());
//                        if(result.getName() == user.getName() && result.getPassword() == user.getPassword()){
//                            iPresenterLogicDangNhap.DangNhapThanhCong(result);
//                        }else {
//                            iPresenterLogicDangNhap.ThatBai();
//
//                        }
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<User> call, Throwable t) {
//                Toast.makeText(getApplicationContext(), "" + t, Toast.LENGTH_SHORT).show();
//
//            }
//        });
//
//
//    }


    private boolean validate(EditText editText) {
        // check the lenght of the enter data in EditText and give error if its empty
        if (editText.getText().toString().trim().length() > 0) {
            return true; // returns true if field is not empty
        }
        editText.setError("Please Fill This");
        editText.requestFocus();
        return false;
    }

//    public void LoginCheck(final String username, final String password) {
//
//        Call<ResponseBody> call = RetrofitClient.getClient().userlogin(username, password);
//        call.enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//
//                if (response.isSuccessful()) {
//
//                    try {
//
//                        String result = response.body().string();
//
//                        JSONObject obj = new JSONObject(result);
//
//                        String getstatus = obj.getString("status");
//
//                        if (getstatus.equals("false")) {
//                            String error = obj.getString("error");
//                            Toast.makeText(getApplicationContext(), "" + error, Toast.LENGTH_LONG).show();
//                        } else if (getstatus.equals("true")) {
//
//                            Toast.makeText(MainActivity.this, "ok", Toast.LENGTH_SHORT).show();;
//                        }
//
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                } else {
//
//                    Toast.makeText(getApplicationContext(), "fail", Toast.LENGTH_SHORT).show();
//                }
//            }
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//                Toast.makeText(getApplicationContext(), "" + t, Toast.LENGTH_SHORT).show();
//
//
//            }
//        });
//
//    }

    @Override
    public void dangnhapthanhcong() {
        Toast.makeText(getApplicationContext(), "Đăng nhập thành công", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void dangnhapthatbai() {
        Toast.makeText(getApplicationContext(), "Đăng nhập thất bại", Toast.LENGTH_LONG).show();

    }
}