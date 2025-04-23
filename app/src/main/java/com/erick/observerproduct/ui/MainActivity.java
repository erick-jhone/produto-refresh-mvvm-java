package com.erick.observerproduct.ui;

import android.os.Bundle;

import androidx.activity.ComponentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.erick.observerproduct.data.model.Produto;
import com.erick.observerproduct.data.repositories.ProdutoRepository;
import com.erick.observerproduct.data.repositories.ProdutoRepositoryInterface;
import com.erick.observerproduct.databinding.ActivityMainBinding;
import com.erick.observerproduct.di.ProdutoViewModelFactory;

public class MainActivity extends ComponentActivity {

    private ActivityMainBinding binding;
    private ProdutoViewModel produtoViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        instanceViewModel();
        produtoViewModel.getProdutoLiveData().observe(this, produto -> {
            if(produto == null){
                inputDefaultValues();
                return;
            }
            onChangedValue(produto);
        });
    }

    private void instanceViewModel() {
        ProdutoRepositoryInterface produtoRepository = new ProdutoRepository();
        ProdutoViewModelFactory factory = new ProdutoViewModelFactory(produtoRepository);
        produtoViewModel = new ViewModelProvider(this, factory).get(ProdutoViewModel.class);
    }

    private void onChangedValue(Produto produto) {
        binding.textoProduto.setText(produto.getNome());
        binding.productCode.setText("Código: " + produto.getId());
        binding.productPrice.setText("Preço: R$ " + produto.getValor());
    }

    private void inputDefaultValues() {
        binding.textoProduto.setText("Produto não carregado");
        binding.productCode.setText("Código: 0000");
        binding.productPrice.setText("Preço: R$ 0,00");
    }
}
