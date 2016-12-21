package br.com.caelum.notasfiscais.mb;

import br.com.caelum.notasfiscais.dao.UsuarioDao;
import br.com.caelum.notasfiscais.modelo.Usuario;
import br.com.caelum.notasfiscais.util.EmailFinanceiro;
import java.io.Serializable;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Model;
import javax.inject.Inject;


@Model
public class LoginBean implements Serializable {

    private Usuario usuario = new Usuario();

    @Inject
    private UsuarioDao dao;

    @Inject
    private UsuarioLogadoBean usuarioLogado;

    @Inject
    private Event<Usuario> eventoLogin;
    
    @Inject @EmailFinanceiro
    private String email;

    public String efetuaLogin() {

        boolean loginValidado = dao.existe(usuario);
        if (loginValidado) {
            eventoLogin.fire(usuario);
            usuarioLogado.logar(usuario);
            return "notafiscal?faces-redirect=true";
        } else {
            usuarioLogado.deslogar();
            return "login";
        }
    }

    public String sair() {
        usuarioLogado.deslogar();
        return "login?faces-redirect=true";
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
