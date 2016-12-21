package br.com.caelum.notasfiscais.listener;

import br.com.caelum.notasfiscais.modelo.Usuario;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

public class LoginListener {

    @Inject
    @Any
    private Instance<String> todosEmails;

    public void onLogin(@Observes Usuario usuario) {

        for (String email : todosEmails) {
            System.out.println("Notifica. " + email);
        }
    }
}
