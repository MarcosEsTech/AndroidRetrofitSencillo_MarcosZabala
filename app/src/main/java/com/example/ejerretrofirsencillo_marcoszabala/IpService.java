package com.example.ejerretrofirsencillo_marcoszabala;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IpService {

    @GET("/")
    Call<Ip> getIp();
}
