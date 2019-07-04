/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 19933746-7
 */
@Entity
@Table(name = "jugador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jugador.findAll", query = "SELECT j FROM Jugador j"),
    @NamedQuery(name = "Jugador.findById", query = "SELECT j FROM Jugador j WHERE j.id = :id"),
    @NamedQuery(name = "Jugador.findByNombre", query = "SELECT j FROM Jugador j WHERE j.nombre = :nombre"),
    @NamedQuery(name = "Jugador.findByPosicion", query = "SELECT j FROM Jugador j WHERE j.posicion = :posicion"),
    @NamedQuery(name = "Jugador.findByValor", query = "SELECT j FROM Jugador j WHERE j.valor = :valor"),
    @NamedQuery(name = "Jugador.findByEstado", query = "SELECT j FROM Jugador j WHERE j.estado = :estado"),
    @NamedQuery(name = "Jugador.findByPathphoto", query = "SELECT j FROM Jugador j WHERE j.pathphoto = :pathphoto")})
public class Jugador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 50)
    @Column(name = "posicion")
    private String posicion;
    @Column(name = "valor")
    private Integer valor;
    @Column(name = "estado")
    private Integer estado;
    @Size(max = 20)
    @Column(name = "pathphoto")
    private String pathphoto;
    @JoinColumn(name = "equipoFK", referencedColumnName = "id")
    @ManyToOne
    private Equipo equipoFK;

    public Jugador() {
    }

    public Jugador(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public String getPathphoto() {
        return pathphoto;
    }

    public void setPathphoto(String pathphoto) {
        this.pathphoto = pathphoto;
    }

    public Equipo getEquipoFK() {
        return equipoFK;
    }

    public void setEquipoFK(Equipo equipoFK) {
        this.equipoFK = equipoFK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jugador)) {
            return false;
        }
        Jugador other = (Jugador) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.entities.Jugador[ id=" + id + " ]";
    }
    
}
