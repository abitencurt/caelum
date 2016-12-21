package br.com.caelum.notasfiscais.modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Item.class)
public abstract class Item_ {

	public static volatile SingularAttribute<Item, Produto> produto;
	public static volatile SingularAttribute<Item, Long> id;
	public static volatile SingularAttribute<Item, NotaFiscal> notaFiscal;
	public static volatile SingularAttribute<Item, Integer> quantidade;
	public static volatile SingularAttribute<Item, Double> valorUnitario;

}

