package com.erick.observerproduct.data.setup;

import com.erick.observerproduct.data.model.ProdutoCallAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final String BASE_URL = "https://my-json-server.typicode.com/erick-jhone/json-produto/";
    private static Retrofit retrofit;

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static ProdutoCallAPI getProdutoAPI() {
        return getRetrofitInstance().create(ProdutoCallAPI.class);
    }
}
