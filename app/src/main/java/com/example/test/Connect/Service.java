package com.example.test.Connect;
import com.example.test.Model.User;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Service {
//    @FormUrlEncoded
    @GET("api/products")
//    Call<User> userlogin(@Field("name") String username,
//                               @Field("pass") String password);
    Call<List<User>> userlogin(@Query("name") String username,
                         @Query("pass") String password);
}
