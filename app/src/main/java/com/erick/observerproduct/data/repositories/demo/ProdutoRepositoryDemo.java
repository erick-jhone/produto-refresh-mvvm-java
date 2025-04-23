package com.erick.observerproduct.data.repositories.demo;

import com.erick.observerproduct.data.model.Produto;
import com.erick.observerproduct.data.model.ResultAPI;
import com.erick.observerproduct.data.repositories.ProdutoRepositoryInterface;

import java.util.Random;

public class ProdutoRepositoryDemo implements ProdutoRepositoryInterface {

    @Override
    public void getProduto(ResultAPI callback) {
        Produto produto = new Produto(1, "Bebida Preta", 19.89);
        callback.onSucesso(produto);
    }
}
