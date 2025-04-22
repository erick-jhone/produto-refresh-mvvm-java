package com.erick.observerproduct.data.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProdutoCallAPI {
    @GET("produtos")
    Call<List<Produto>> getProdutos();
}




