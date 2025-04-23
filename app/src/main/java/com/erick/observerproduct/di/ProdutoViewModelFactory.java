package com.erick.observerproduct.di;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.erick.observerproduct.data.repositories.ProdutoRepositoryInterface;
import com.erick.observerproduct.ui.ProdutoViewModel;

public class ProdutoViewModelFactory implements ViewModelProvider.Factory {
    private final ProdutoRepositoryInterface produtoRepository;

    public ProdutoViewModelFactory(ProdutoRepositoryInterface produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(ProdutoViewModel.class)) {
            return (T) new ProdutoViewModel(produtoRepository);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
