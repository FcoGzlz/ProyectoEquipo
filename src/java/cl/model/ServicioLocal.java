/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.model;

import cl.entities.Usuario;
import javax.ejb.Local;

/**
 *
 * @author 19933746-7
 */
@Local
public interface ServicioLocal {
    public void persist(Object o);
    public void merge(Object o);
    Usuario login(String rut, String clave);
    
}
