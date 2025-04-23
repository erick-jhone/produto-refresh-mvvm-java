package com.erick.observerproduct.data.repositories;

import com.erick.observerproduct.data.api.ProdutoCallAPI;
import com.erick.observerproduct.data.model.Produto;
import com.erick.observerproduct.data.model.ResultAPI;
import com.erick.observerproduct.data.setup.RetrofitClient;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import retrofit2.Response;

public class ProdutoRepository implements ProdutoRepositoryInterface {

    private final ProdutoCallAPI produtoAPI = RetrofitClient.getProdutoAPI();
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();


    @Override
    public void getProduto(ResultAPI callback) {
        executorService.execute(() -> {
            try {
                Response<List<Produto>> response = produtoAPI.getProdutos().execute();
                if (response.isSuccessful() && response.body() != null) {
                    callback.onSucesso(response.body().get(0));
                } else {
                    callback.onErro(new Exception("Resposta não foi bem-sucedida ou corpo nulo"));
                }
            } catch (Exception e) {
                callback.onErro(e);
            }
        });
    }
}
