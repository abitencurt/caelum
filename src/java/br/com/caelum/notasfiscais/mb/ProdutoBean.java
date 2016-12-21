package br.com.caelum.notasfiscais.mb;

import br.com.caelum.notasfiscais.dao.ProdutoDao;
import br.com.caelum.notasfiscais.modelo.Produto;
import br.com.caelum.notasfiscais.tx.Transactional;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

@Model
public class ProdutoBean implements Serializable {

    private Produto produto = new Produto();
    private List<Produto> produtos;

    @Inject
    ProdutoDao dao;

    @Transactional
    public void grava() {

        if (produto.getId() == null) {
            dao.adiciona(produto);

        } else {
            dao.atualiza(produto);
        }
        this.produto = new Produto();
        this.produtos = dao.listaTodos();
    }

    @Transactional
    public void remove(Produto produto) {

        dao.remove(produto);
        this.produtos = dao.listaTodos();
    }

    public Produto getProduto() {
        return this.produto;
    }

    public List<Produto> getProdutos() {
        if (produtos == null) {
            System.out.println("Carregando produtos....");
            produtos = dao.listaTodos();
        }

        return produtos;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

}
