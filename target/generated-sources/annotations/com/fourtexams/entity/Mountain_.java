package com.fourtexams.entity;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Mountain.class)
public abstract class Mountain_ extends com.fourtexams.entity.Parent_ {

	public static volatile SingularAttribute<Mountain, String> name;
	public static volatile SingularAttribute<Mountain, Integer> height;

	public static final String NAME = "name";
	public static final String HEIGHT = "height";

}

