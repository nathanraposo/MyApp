package com.nathanraposo.myapp.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.nathanraposo.myapp.myapp.BDHelper.ProdutosBd;
import com.nathanraposo.myapp.myapp.model.Produtos;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CadastroProdutoActivity extends AppCompatActivity {

    @BindView(R.id.editText_NomeProduto)
    EditText editTextNomeProduto;
    @BindView(R.id.editText_DescricaoProduto)
    EditText editTextDescricaoProduto;
    @BindView(R.id.editText_QuantidadeProduto)
    EditText editTextQuantidadeProduto;
    @BindView(R.id.button_Salvar)
    Button buttonSalvar;

    Produtos editarProdutos, produtoModel;

    ProdutosBd bdHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_produto);
        ButterKnife.bind(this);
        Intent intent  = getIntent();
        editarProdutos = (Produtos) intent.getSerializableExtra("produto-escolhido");
        bdHelper = new ProdutosBd(this);


        if(editarProdutos != null){
            buttonSalvar.setText("ALTERAR");
        }else{
            buttonSalvar.setText("SALVAR");
        }

        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDadosProduto();
                if(buttonSalvar.getText().toString().equals("SALVAR")){
                    bdHelper.salvar(produtoModel);
                    bdHelper.close();
                    Toast.makeText(CadastroProdutoActivity.this, "Item salvo com sucesso!", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    public void setDadosProduto(){
        System.out.println("nome produto"+editTextNomeProduto.getText().toString());
        produtoModel.setNome(editTextNomeProduto.getText().toString());
        produtoModel.setDescricao(editTextDescricaoProduto.getText().toString());
        produtoModel.setQuantidade(Integer.parseInt(editTextQuantidadeProduto.getText().toString()));
    }
}