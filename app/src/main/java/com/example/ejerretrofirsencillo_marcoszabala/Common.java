package com.example.ejerretrofirsencillo_marcoszabala;

public class Common {

    private static final String BASE_URL = "http://ip.jsontest.com/";

    public static IpService getIpService(){
        return RetrofitClient.getClient( BASE_URL ).create( IpService.class );
    }
}
