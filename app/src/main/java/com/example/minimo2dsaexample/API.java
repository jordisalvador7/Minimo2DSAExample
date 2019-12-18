package com.example.minimo2dsaexample;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface API {

    @GET("pag-ini/{pag-ini}/pag-fi/{pag-fi}")
    Call<Museums> museumsInfo(@Path("pag-ini") int pagini,@Path("pag-fi") int pagfi);

}
