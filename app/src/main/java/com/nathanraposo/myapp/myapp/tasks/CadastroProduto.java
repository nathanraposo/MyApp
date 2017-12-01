package com.nathanraposo.myapp.myapp.tasks;

import com.nathanraposo.myapp.myapp.BDHelper.ProdutosBd;
import com.nathanraposo.myapp.myapp.model.Produtos;

/**
 * Created by nathan on 30/11/17.
 */

public interface CadastroProduto {

    interface Model{
        void salvarProduto(ProdutosBd bdHelper, Produtos produtos);
        void alterarProduto(ProdutosBd bdHelper,Produtos produtos);
    }

    interface View{
        void carregaTelaMain();
    }

    interface Presenter{
        void salvarProduto();
        void alterarProduto();
    }
}
