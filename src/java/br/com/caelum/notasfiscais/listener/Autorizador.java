package br.com.caelum.notasfiscais.listener;

import br.com.caelum.notasfiscais.mb.UsuarioLogadoBean;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.inject.Inject;

public class Autorizador implements PhaseListener {

    @Inject
    private UsuarioLogadoBean usuarioLogado;

    @Override
    public void afterPhase(PhaseEvent event) {
        FacesContext context = event.getFacesContext();

        if ("/login.xhtml".equals(context.getViewRoot().getViewId())) {
            return;
        }

        if ("/index.xhtml".equals(context.getViewRoot().getViewId())) {
            return;
        }

        if (!usuarioLogado.isLogado()) {
            NavigationHandler handler = context.getApplication().getNavigationHandler();
            handler.handleNavigation(context, null, "login?faces-redirect=true");
            context.renderResponse();
        }
    }

    @Override
    public void beforePhase(PhaseEvent event) {

    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }

}
