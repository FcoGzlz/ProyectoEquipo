package cl.entities;

import cl.entities.Equipo;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-08T23:29:11")
@StaticMetamodel(Liga.class)
public class Liga_ { 

    public static volatile ListAttribute<Liga, Equipo> equipoList;
    public static volatile SingularAttribute<Liga, Integer> id;
    public static volatile SingularAttribute<Liga, String> nombre;

}