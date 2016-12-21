package br.com.caelum.notasfiscais.dao;

import br.com.caelum.notasfiscais.modelo.Usuario;
import java.io.Serializable;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class UsuarioDao implements Serializable {

    @Inject
    private EntityManager em;

    public boolean existe(Usuario usuario) {

        em.getTransaction().begin();

        Query query = em.createQuery("from Usuario u where u.login = "
                + ":pLogin and u.senha = :pSenha");
        query.setParameter("pLogin", usuario.getLogin());
        query.setParameter("pSenha", usuario.getSenha());
        boolean encontrado = !query.getResultList().isEmpty();
        em.getTransaction().commit();
        em.clear();

        return encontrado;
    }

}
