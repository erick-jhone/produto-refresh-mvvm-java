package com.erick.observerproduct.presenter;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.erick.observerproduct.data.model.Produto;
import com.erick.observerproduct.data.model.ProdutoRepository;
import com.erick.observerproduct.data.model.ResultAPI;

import java.util.Timer;
import java.util.TimerTask;

public class ProdutoViewModel extends ViewModel {

    private final MutableLiveData<Produto> produtoLiveData = new MutableLiveData<>();
    private final ProdutoRepository repository = new ProdutoRepository();
    private final Timer timer = new Timer();

    public ProdutoViewModel() {

        iniciarConsultaPeriodica();
    }

    public LiveData<Produto> getProdutoLiveData() {
        return produtoLiveData;
    }

    private void iniciarConsultaPeriodica() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    repository.getProduto(new ResultAPI() {
                        @Override
                        public void onSucesso(Produto produto) {
                            produtoLiveData.postValue(produto);
                        }

                        @Override
                        public void onErro(Exception e) {
                            e.printStackTrace();
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 0, 60000);
    }


    @Override
    protected void onCleared() {
        super.onCleared();
        timer.cancel();
    }
}
