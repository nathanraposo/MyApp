package com.nathanraposo.myapp.myapp.tasks;

import android.widget.AdapterView;

import com.nathanraposo.myapp.myapp.model.Produtos;

import java.util.ArrayList;

/**
 * Created by nathan on 29/11/17.
 */

public interface Main {

    interface Model {
        void carregarListaProdutos();
    }

    interface View {
        void setItems(ArrayList<Produtos> produtosList);

        void carregaTelaCadastroProduto();

        void abreTelaCadastro(int position, AdapterView<?> adapterView);
    }

    interface Presenter {
        void setItems();

        Main.View getView();

        void updateListaProdutos(ArrayList<Produtos> produtosList);

        void onItemClicked(int position, AdapterView<?> adapterView);
    }
}
