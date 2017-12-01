package com.nathanraposo.myapp.myapp.presenter;

import android.content.Context;

import com.nathanraposo.myapp.myapp.BDHelper.ProdutosBd;
import com.nathanraposo.myapp.myapp.model.ModelCadastroProduto;
import com.nathanraposo.myapp.myapp.model.Produtos;
import com.nathanraposo.myapp.myapp.tasks.CadastroProduto;

/**
 * Created by nathan on 30/11/17.
 */

public class PresenterCadastroProduto implements CadastroProduto.Presenter {

    private CadastroProduto.Model model;
    private CadastroProduto.View view;

    private final Produtos produtoModel;
    private ProdutosBd bdHelper;

    public PresenterCadastroProduto(CadastroProduto.View view, Produtos produtoModel) {
        model = new ModelCadastroProduto(this);
        this.produtoModel = produtoModel;
        this.view = view;
        bdHelper = new ProdutosBd((Context) view);
    }

    @Override
    public void salvarProduto() {
        model.salvarProduto(bdHelper,produtoModel);
    }

    @Override
    public void alterarProduto() {
        model.alterarProduto(bdHelper,produtoModel);
    }
}
