package br.com.caelum.notasfiscais.modelo;

import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(NotaFiscal.class)
public abstract class NotaFiscal_ {

	public static volatile ListAttribute<NotaFiscal, Item> itens;
	public static volatile SingularAttribute<NotaFiscal, Calendar> data;
	public static volatile SingularAttribute<NotaFiscal, Long> id;
	public static volatile SingularAttribute<NotaFiscal, String> cnpj;

}

