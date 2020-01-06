package com.example.app_deepanshu.api;

import com.example.app_deepanshu.Key_Verify;
import com.example.app_deepanshu.StudentLoginResponse;
import com.example.app_deepanshu.models.DefaultResponse;
import com.example.app_deepanshu.stu_login;

import java.util.List;

import javax.security.auth.Subject;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

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
    //Teacher Verify
    @GET("/account/{key}/school")
    Call<Key_Verify> verifyTeacher(
            @Path("key") String key
    );

    @FormUrlEncoded
    @POST("/account/teacher/create")
    Call<DefaultResponse> createTeacher(
            @Field("aadhar") String aadhar,
            @Field("password") String password,
            @Field("email") String email,
            @Field("first_name") String first_name,
            @Field("mobile_number") String mobile_number,
            @Field("address") String address,
            @Field("state") String state,
            @Field("school_id") Integer school_id
    );
    @FormUrlEncoded
    @POST("/account/rest-auth/login/")
    Call<stu_login> teacherLogin(
            @Field("username") String username,
            @Field("password") String password
    );
//    @Headers("Authorization:token c71fd3475423a9d0d3000cc537809009abe99810")
//    @GET("/")
//    Call<List<Subject>> getSubjects();
//    @Headers("Authorization:token c71fd3475423a9d0d3000cc537809009abe99810")
//    @GET("topic")
//    Call<List<Topic>> getTopics(@Query("search") int id);
//    @Headers("Authorization:token c71fd3475423a9d0d3000cc537809009abe99810")
//    @GET("question")
//    Call<List<Question>> getQuestions(@Query("search") int id);
//    @Headers("Authorization:token c71fd3475423a9d0d3000cc537809009abe99810")
//    @GET("choice")
//    Call<List<Choice>> getChoices(@Query("search") int id);
//    @Headers("Authorization:token c71fd3475423a9d0d3000cc537809009abe99810")
//    @GET("edu")
//    Call<List<Notes>> getNotes(@Query("search") int id);
//    @Headers("Authorization:token c71fd3475423a9d0d3000cc537809009abe99810")
//    @POST("SubjectCreate")
//    Call<Subject> postSubject(@Body Subject subject);
//    @Headers("Authorization:token c71fd3475423a9d0d3000cc537809009abe99810")
//    @POST("module/ModuleCreate")
//    Call<Module> postModule(@Body Module module);
//    @Headers("Authorization:token c71fd3475423a9d0d3000cc537809009abe99810")
//    @POST("topic/TopicCreate")
//    Call<Topic> postTopic(@Body Topic topic);
//    @Headers("Authorization:token c71fd3475423a9d0d3000cc537809009abe99810")
//    @POST("question/QuestionCreate")
//    Call<Question> postQuestion(@Body Question question);
//    @Headers("Authorization:token c71fd3475423a9d0d3000cc537809009abe99810")
//    @POST("choice/ChoiceCreate")
//    Call<Choice> postChoice(@Body Choice choice);
//    @Headers("Authorization:token c71fd3475423a9d0d3000cc537809009abe99810")
//    @Multipart
//    @POST("edu/NoteCreate")
//    Call<Notes> uploadNotes(@Part MultipartBody.Part file,
//                            @Part("module") Integer module);
}
