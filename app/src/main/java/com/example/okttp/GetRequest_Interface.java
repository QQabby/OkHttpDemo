package com.example.okttp;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetRequest_Interface {

    @GET("ajax.php?a=fy&f=en&t=zh&w=hello%20world")
    Call<Translation> getCall();

    //用动态代理动态将该接口的注解 “翻译” 成一个http 请求，最后再执行http请求
    //接口中的每个方法的参数都需要使用注解标注，否则会报错
}
