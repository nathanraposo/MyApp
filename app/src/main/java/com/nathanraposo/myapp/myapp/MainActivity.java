package com.nathanraposo.myapp.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.listview_Produtos)
    ListView listviewProdutos;
    @BindView(R.id.button_cadastrar)
    Button buttonCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        buttonCadastrar.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if(view.getId() == (R.id.button_cadastrar)){
            Intent intent = new Intent(this,CadastroProdutoActivity.class);
            startActivity(intent);

        }
    }
}
