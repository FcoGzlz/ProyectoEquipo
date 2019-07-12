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
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class Servicio implements ServicioLocal {

    @PersistenceContext(unitName = "ProyectoEquipoPU")
    private EntityManager em;

    @Override
    public void persist(Object o) {
        em.persist(o);
    }

    @Override
    public void merge(Object o) {
        em.merge(o);
        em.flush();
    }

    @Override
    public Usuario login(String rut, String clave, int estado) {
        try {
            return em.createNamedQuery("Usuario.login", Usuario.class)
                    .setParameter("rut", rut)
                    .setParameter("clave", clave)
                    .setParameter("esadministrador", estado)
                    .getSingleResult();
        } catch (Exception e) {

        }
        return null;
    }

    @Override
    public Usuario findUsuario(String rut) {
        try {
            return em.createNamedQuery("Usuario.findByRut", Usuario.class)
                    .setParameter("rut", rut)
                    .getSingleResult();
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public List<Equipo> getEquipos() {
        return em.createNamedQuery("Equipo.findAll").getResultList();
    }

    @Override
    public List<Liga> getLigas() {
        return em.createNamedQuery("Liga.findAll").getResultList();
        //return em.createQuery("SELECT l FROM Liga l").getResultList();
    }

    @Override
    public List<Jugador> getJugadores() {
        return em.createNamedQuery("Jugador.findAll", Jugador.class).getResultList();
    }


}
