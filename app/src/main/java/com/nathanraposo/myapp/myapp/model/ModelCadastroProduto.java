package com.nathanraposo.myapp.myapp.model;

import com.nathanraposo.myapp.myapp.BDHelper.ProdutosBd;
import com.nathanraposo.myapp.myapp.tasks.CadastroProduto;

/**
 * Created by nathan on 30/11/17.
 */

public class ModelCadastroProduto implements CadastroProduto.Model {

    private CadastroProduto.Presenter presenter;

    public ModelCadastroProduto(CadastroProduto.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void salvarProduto(ProdutosBd bdHelper, Produtos produtos) {
        bdHelper.salvar(produtos);
        bdHelper.close();
    }

    @Override
    public void alterarProduto(ProdutosBd bdHelper, Produtos produtos) {
        bdHelper.alterar(produtos);
        bdHelper.close();
    }
}
