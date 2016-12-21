package br.com.caelum.notasfiscais.mb;

import br.com.caelum.notasfiscais.modelo.Usuario;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class UsuarioLogadoBean implements Serializable {

    private Usuario usuario;

    public void logar(Usuario usuario) {
        this.usuario = usuario;
    }

    public void deslogar() {
        this.usuario = null;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public boolean isLogado() {
        return usuario != null;
    }

}
