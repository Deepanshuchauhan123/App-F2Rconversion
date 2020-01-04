package com.example.app_deepanshu.api;

import com.example.app_deepanshu.StudentLoginResponse;
import com.example.app_deepanshu.models.DefaultResponse;
import com.example.app_deepanshu.stu_login;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface Api {

    @FormUrlEncoded

    // Student Register

    @POST("/account/student/create")
    Call<DefaultResponse> createUser(
            @Field("aadhar") String aadhar,
            @Field("password") String password,
            @Field("email") String email,
            @Field("first_name") String first_name,
            @Field("father_name") String father_name,
            @Field("father_aadhar") String father_aadhar,
            @Field("mobile_number") String mobile_number,
            @Field("address") String address,
            @Field("state") String state
    );
    // Student Login
    @FormUrlEncoded
    @POST("/account/rest-auth/login/")
    Call<stu_login> userLogin(
            @Field("username") String username,
            @Field("password") String password
    );

    //Parents Register
    @FormUrlEncoded
    @POST("/account/parent/create")
    Call<DefaultResponse> createParent(
            @Field("aadhar") String aadhar,
            @Field("password") String password,
            @Field("email") String email,
            @Field("first_name") String first_name,
            @Field("mobile_number") String mobile_number,
            @Field("address") String address,
            @Field("state") String state
    );

    //parents login
    @FormUrlEncoded
    @POST("/account/rest-auth/login/")
    Call<stu_login> parentLogin(
            @Field("username") String username,
            @Field("password") String password
    );

//School Register
    @FormUrlEncoded
    @POST("/account/school/create")
    Call<DefaultResponse> createSchool(
            @Field("key") String key,
            @Field("password") String password,
            @Field("email") String email,
            @Field("first_name") String first_name,
            @Field("mobile_number") String mobile_number,
            @Field("address") String address,
            @Field("state") String state,
            @Field("board") String board
    );
    //School Login

    @FormUrlEncoded
    @POST("/account/rest-auth/login/")
    Call<stu_login> schoolLogin(
            @Field("username") String username,
            @Field("password") String password
    );
}
