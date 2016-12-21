package br.com.caelum.notasfiscais.mb;

import br.com.caelum.notasfiscais.dao.NotaFiscalDao;
import br.com.caelum.notasfiscais.dao.ProdutoDao;
import br.com.caelum.notasfiscais.modelo.Item;
import br.com.caelum.notasfiscais.modelo.NotaFiscal;
import br.com.caelum.notasfiscais.modelo.Produto;
import br.com.caelum.notasfiscais.tx.Transactional;
import java.io.Serializable;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ConversationScoped
public class NotaFiscalBean implements Serializable {

    private Item item = new Item();
    private NotaFiscal notaFiscal = new NotaFiscal();
    private Long idProduto;

    @Inject
    private NotaFiscalDao notaFiscalDao;

    @Inject
    ProdutoDao produtoDao;

    @Inject
    private Conversation conversation;

    @Transactional
    public String gravar() {
        this.notaFiscalDao.adiciona(notaFiscal);
        conversation.end();
        return "notafiscal?faces-redirect=true";
    }

    public String avancar() {
        if (conversation.isTransient()) {
            conversation.begin();
        }

        return "item?faces-redirect=true";
    }

    public void guardaItem() {
        Produto produto = produtoDao.buscaPorId(idProduto);

        item.setProduto(produto);
        item.setValorUnitario(produto.getPreco());

        notaFiscal.getItens().add(item);
        item.setNotaFiscal(notaFiscal);

        item = new Item();
        idProduto = null;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public NotaFiscal getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(NotaFiscal notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

}
