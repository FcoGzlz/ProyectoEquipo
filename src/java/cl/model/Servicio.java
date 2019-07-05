/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.model;

import cl.entities.Usuario;
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
    }

    @Override
    public Usuario login(String rut, String clave) {
        try {
            em.createNamedQuery("Usuario.login", Usuario.class)
                    .setParameter("rut", rut)
                    .setParameter("clave", clave)
                    .getResultList();
        } catch (Exception e) {
        }
        return null;
    }

    
}
