package com.erick.observerproduct.data.api;

import com.erick.observerproduct.data.model.Produto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProdutoCallAPI {
    @GET("produtos")
    Call<List<Produto>> getProdutos();
}




