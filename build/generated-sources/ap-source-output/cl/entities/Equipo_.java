package cl.entities;

import cl.entities.Jugador;
import cl.entities.Liga;
import cl.entities.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-11T22:54:54")
@StaticMetamodel(Equipo.class)
public class Equipo_ { 

    public static volatile SingularAttribute<Equipo, String> formacion;
    public static volatile ListAttribute<Equipo, Jugador> jugadorList;
    public static volatile SingularAttribute<Equipo, Integer> presupuesto;
    public static volatile SingularAttribute<Equipo, String> escudo;
    public static volatile SingularAttribute<Equipo, Usuario> usuario;
    public static volatile SingularAttribute<Equipo, Integer> id;
    public static volatile SingularAttribute<Equipo, String> nombre;
    public static volatile SingularAttribute<Equipo, Liga> ligaFK;

}