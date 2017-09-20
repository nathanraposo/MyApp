package com.nathanraposo.myapp.myapp.BDHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.nathanraposo.myapp.myapp.model.Produtos;

import java.util.ArrayList;

/**
 * Created by nathan on 20/09/17.
 */

public class ProdutosBd extends SQLiteOpenHelper {

    private static final String DATABASE = "bdprodutos";
    public static final int VERSION = 1;

    //metodo construtor do sqlite
    public ProdutosBd(Context context) {
        super(context, DATABASE, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase bd) {
        String produto = "CREATE TABLE " +
                "produtos(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "nome TEXT NOT NULL," +
                "descricao TEXT NOT NULL," +
                "quantidade INTEGER NOT NULL);";
        bd.execSQL(produto);
    }

    @Override
    public void onUpgrade(SQLiteDatabase bd, int i, int i1) {
        String produto = "DROP TABLE IF EXISTS produtos";
        bd.execSQL(produto);
    }

    public void salvar(Produtos produtosModel) {
        ContentValues values = new ContentValues();

        //buscando valores e colocando dentro da string values
        values.put("nome", produtosModel.getNome());
        values.put("descricao", produtosModel.getDescricao());
        values.put("quantidade", produtosModel.getQuantidade());

        //chamando o metodo e inserindo os dados na tabela passando os valores
        getWritableDatabase().insert("produtos", null, values);
    }

    public void alterar(Produtos produtosModel) {
        ContentValues values = new ContentValues();

        //buscando valores e colocando dentro da string values
        values.put("nome", produtosModel.getNome());
        values.put("descricao", produtosModel.getDescricao());
        values.put("quantidade", produtosModel.getQuantidade());

        String [] args = {produtosModel.getId().toString()};
        //chamando o metodo e inserindo os dados na tabela passando os valores
        getWritableDatabase().update("produtos",values, "id=?",args);
    }

    public void deletar(Produtos produtosModel){
        String [] args = {produtosModel.getId().toString()};
        //chamando o metodo e inserindo os dados na tabela passando os valores
        getWritableDatabase().delete("produtos","id=?",args);
    }

    //metodo listar retornar uma lista de todos os produtos salvos no banco
    public ArrayList<Produtos> getListar() {

        //colunas do metodo para consulta
        String[] colunas = {"id", "nome", "descricao", "quantidade"};
        Cursor cursor = getWritableDatabase().query("produtos", colunas, null, null, null, null, null, null);
        ArrayList<Produtos> produtosModel = new ArrayList<Produtos>();

        while (cursor.moveToNext()) {
            //buscando e setando os dados do produto no objeto
            Produtos produto = new Produtos();
            produto.setId(cursor.getLong(0));
            produto.setNome(cursor.getString(1));
            produto.setDescricao(cursor.getString(2));
            produto.setQuantidade(cursor.getInt(3));
            //add o produto no array para dar o retorno
            produtosModel.add(produto);
            System.out.println("Nome :"+cursor.getString(1));
            System.out.println("desce :"+cursor.getString(2));
            System.out.println("qtd :"+cursor.getString(3));
        }

        return produtosModel;
    }


}
