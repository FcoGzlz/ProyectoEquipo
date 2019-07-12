/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.model;

import cl.entities.Equipo;
import cl.entities.Jugador;
import cl.entities.Liga;
import cl.entities.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 19933746-7
 */
@Local
public interface ServicioLocal {
    public void persist(Object o);
    public void merge(Object o);
    Usuario login(String rut, String clave, int estado);
    Usuario findUsuario(String rut);
    List<Equipo> getEquipos();
    List<Liga>getLigas();
    List<Jugador> getJugadores();
    
}
