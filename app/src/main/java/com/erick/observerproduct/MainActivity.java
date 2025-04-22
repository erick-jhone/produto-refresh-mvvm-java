package com.erick.observerproduct;

import android.os.Bundle;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.activity.ComponentActivity;
import androidx.lifecycle.ViewModelProvider;

import com.erick.observerproduct.databinding.ActivityMainBinding;
import com.erick.observerproduct.presenter.ProdutoViewModel;

public class MainActivity extends ComponentActivity {

    private ProdutoViewModel produtoViewModel;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        produtoViewModel = new ViewModelProvider(this).get(ProdutoViewModel.class);

        produtoViewModel.getProdutoLiveData().observe(this, produto -> {
            if(produto == null){
                binding.textoProduto.setText("Produto não carregado");
                binding.productCode.setText("Código: 0000");
                binding.productPrice.setText("Preço: R$ 0,00");
                return;
            }

            binding.textoProduto.setText(produto.getNome());
            binding.productCode.setText("Código: " + produto.getId());
            binding.productPrice.setText("Preço: R$ " + produto.getValor());
        });
    }
}
