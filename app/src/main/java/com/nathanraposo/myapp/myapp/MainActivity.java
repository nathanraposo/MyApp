package com.nathanraposo.myapp.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.nathanraposo.myapp.myapp.BDHelper.ProdutosBd;
import com.nathanraposo.myapp.myapp.model.Produtos;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.listview_Produtos)
    ListView listviewProdutos;
    @BindView(R.id.button_cadastrar)
    Button buttonCadastrar;

    ProdutosBd bdHelper;
    Produtos produtoModel;

    ArrayList<Produtos> listview;
    ArrayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        buttonCadastrar.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregarLista();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == (R.id.button_cadastrar)) {
            Intent intent = new Intent(this, CadastroProdutoActivity.class);
            startActivity(intent);
        }
    }

    public void carregarLista() {
        bdHelper = new ProdutosBd(this);
        listview = bdHelper.getListar();
        bdHelper.close();

        if (listview != null) {
            adapter = new ArrayAdapter<Produtos>(this, android.R.layout.simple_list_item_1);
            listviewProdutos.setAdapter(adapter);
        }
    }
}
