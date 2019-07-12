package cl.entities;

import cl.entities.Equipo;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-11T22:00:52")
@StaticMetamodel(Jugador.class)
public class Jugador_ { 

    public static volatile SingularAttribute<Jugador, String> posicion;
    public static volatile SingularAttribute<Jugador, Integer> estado;
    public static volatile SingularAttribute<Jugador, String> pathphoto;
    public static volatile SingularAttribute<Jugador, Integer> valor;
    public static volatile SingularAttribute<Jugador, Integer> id;
    public static volatile SingularAttribute<Jugador, String> nombre;
    public static volatile SingularAttribute<Jugador, Equipo> equipoFK;

}