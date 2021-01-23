package org.beginningee6.book.chapter04.ex01;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2021-01-16T10:46:10.620+0900")
@StaticMetamodel(Book01.class)
public class Book01_ {
	public static volatile SingularAttribute<Book01, Long> id;
	public static volatile SingularAttribute<Book01, String> title;
	public static volatile SingularAttribute<Book01, Float> price;
	public static volatile SingularAttribute<Book01, String> description;
	public static volatile SingularAttribute<Book01, String> isbn;
	public static volatile SingularAttribute<Book01, Integer> nbOfPage;
	public static volatile SingularAttribute<Book01, Boolean> illustrations;
}
