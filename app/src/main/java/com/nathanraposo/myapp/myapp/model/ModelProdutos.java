package com.nathanraposo.myapp.myapp.model;

import android.content.Context;

import com.nathanraposo.myapp.myapp.BDHelper.ProdutosBd;
import com.nathanraposo.myapp.myapp.tasks.Main;

/**
 * Created by nathan on 29/11/17.
 */

public class ModelProdutos implements Main.Model {

    private Main.Presenter presenter;

    public ModelProdutos(Main.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void carregarListaProdutos() {
        ProdutosBd bdHelper = new ProdutosBd((Context) presenter.getView());
        presenter.updateListaProdutos(bdHelper.getListar());
        bdHelper.close();
    }
}