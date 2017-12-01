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
import com.nathanraposo.myapp.myapp.presenter.PresenterCadastroProduto;
import com.nathanraposo.myapp.myapp.tasks.CadastroProduto;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CadastroProdutoActivity extends AppCompatActivity implements CadastroProduto.View {

    @BindView(R.id.editText_NomeProduto)
    EditText editTextNomeProduto;
    @BindView(R.id.editText_DescricaoProduto)
    EditText editTextDescricaoProduto;
    @BindView(R.id.editText_QuantidadeProduto)
    EditText editTextQuantidadeProduto;
    @BindView(R.id.button_Salvar)
    Button buttonSalvar;

    //=-=-=-=-=-=-=-=-VARIAVEIS=---=-=-=-=-=-=-=-=-\\
    private Produtos editarProdutos, produtoModel;

    private CadastroProduto.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_produto);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        editarProdutos = (Produtos) intent.getSerializableExtra("produto_escolhido");

        produtoModel = new Produtos();
        presenter = new PresenterCadastroProduto(this, produtoModel);

        if (editarProdutos != null) {
            buttonSalvar.setText("ALTERAR");
            editTextNomeProduto.setText(editarProdutos.getNome());
            editTextDescricaoProduto.setText(editarProdutos.getDescricao());
            editTextQuantidadeProduto.setText(String.valueOf(editarProdutos.getQuantidade()));
            produtoModel.setId(editarProdutos.getId());
        } else {
            buttonSalvar.setText("SALVAR");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @OnClick(R.id.button_Salvar)
    public void salvar() {
        produtoModel.setNome(editTextNomeProduto.getText().toString());
        produtoModel.setDescricao(editTextDescricaoProduto.getText().toString());
        produtoModel.setQuantidade(Integer.parseInt(editTextQuantidadeProduto.getText().toString()));

        if (buttonSalvar.getText().toString().equals("SALVAR")) {
            presenter.salvarProduto();
            carregaTelaMain();
        } else {
            presenter.alterarProduto();
            carregaTelaMain();
        }
    }

    @Override
    public void carregaTelaMain() {
        startActivity(new Intent(this, MainActivity.class));
        Toast.makeText(CadastroProdutoActivity.this, "Item salvo com sucesso!", Toast.LENGTH_SHORT).show();
    }
}