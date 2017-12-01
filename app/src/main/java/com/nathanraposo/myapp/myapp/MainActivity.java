package com.nathanraposo.myapp.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.nathanraposo.myapp.myapp.model.Produtos;
import com.nathanraposo.myapp.myapp.presenter.PresenterMainActivity;
import com.nathanraposo.myapp.myapp.tasks.Main;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity implements Main.View, AdapterView.OnItemClickListener {

    @BindView(R.id.listview_Produtos)
    ListView listviewProdutos;
    @BindView(R.id.button_cadastrar)
    Button buttonCadastrar;

    private Main.Presenter presenterMainActivity;

    //=-===-=-=-=-=-=VARIAVEIS=-=--=-==\\

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        presenterMainActivity = new PresenterMainActivity(this);

        listviewProdutos.setOnItemClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenterMainActivity.setItems();
    }

    @OnClick(R.id.button_cadastrar)
    void cadastrarProduto() {
        carregaTelaCadastroProduto();
    }

    @Override
    public void carregaTelaCadastroProduto() {
        startActivity(new Intent(this, CadastroProdutoActivity.class));
    }

    @Override
    public  void setItems(ArrayList<Produtos> produtosList) {
        listviewProdutos.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, produtosList));
    }

    @Override
    public void abreTelaCadastro(int position, AdapterView<?> adapterView) {
        Produtos produtoEscolhido = (Produtos) adapterView.getItemAtPosition(position);
        Intent intent = new Intent(this, CadastroProdutoActivity.class);
        intent.putExtra("produto_escolhido", produtoEscolhido);
        startActivity(intent);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        presenterMainActivity.onItemClicked(position, adapterView);
    }
}
