package com.erick.observerproduct.data.model;

public interface ResultAPI {
    void onSucesso(Produto produto);
    void onErro(Exception e);
}
