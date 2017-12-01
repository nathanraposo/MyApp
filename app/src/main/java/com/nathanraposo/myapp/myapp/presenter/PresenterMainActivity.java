package com.nathanraposo.myapp.myapp.presenter;

import android.widget.AdapterView;

import com.nathanraposo.myapp.myapp.model.ModelProdutos;
import com.nathanraposo.myapp.myapp.model.Produtos;
import com.nathanraposo.myapp.myapp.tasks.Main;

import java.util.ArrayList;

/**
 * Created by nathan on 29/11/17.
 */

public class PresenterMainActivity implements Main.Presenter {

    private Main.Model model;
    private Main.View view;

    private ArrayList<Produtos> produtosList = new ArrayList<>();

    public PresenterMainActivity(Main.View view) {
        model = new ModelProdutos(this);
        this.view = view;
    }

    @Override
    public Main.View getView() {
        return view;
    }

    @Override
    public void updateListaProdutos(ArrayList<Produtos> produtosArrayList) {
        produtosList.clear();
        produtosList.addAll(produtosArrayList);
        view.setItems(produtosArrayList);
    }

    @Override
    public void onItemClicked(int position, AdapterView<?> adapterView) {
        if (view != null) {
            view.abreTelaCadastro(position, adapterView);
        }
    }

    @Override
    public void setItems() {
        model.carregarListaProdutos();
    }
}