package br.com.caelum.notasfiscais.dao;

import br.com.caelum.notasfiscais.modelo.Produto;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

public class ProdutoDao implements Serializable {

    @Inject
    EntityManager manager;

    public void adiciona(Produto produto) {

        manager.persist(produto);

    }

    public void remove(Produto produto) {

        manager.remove(manager.merge(produto));

    }

    public void atualiza(Produto produto) {

        manager.merge(produto);

    }

    public List<Produto> listaTodos() {

        CriteriaQuery<Produto> query = manager.getCriteriaBuilder()
                .createQuery(Produto.class);
        query.select(query.from(Produto.class));
        List<Produto> lista = manager.createQuery(query).getResultList();

        return lista;
    }

    public Produto buscaPorId(Long id) {

        Produto produto = manager.find(Produto.class, id);

        return produto;
    }

}
