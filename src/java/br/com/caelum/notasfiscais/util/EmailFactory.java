package br.com.caelum.notasfiscais.util;

import javax.enterprise.inject.Produces;



public class EmailFactory {

    @Produces @EmailComercial
    private  String emailComercial= "comercia@comercial.com.br";

    @Produces @EmailFinanceiro
    private String emailFinanceiro = "financeiro@finaceiro.com.br";

   
}
