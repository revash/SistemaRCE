/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.sistemarce.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AndresEduardo
 */
@Entity
@Table(name = "especialidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Especialidad.findAll", query = "SELECT e FROM Especialidad e"),
    @NamedQuery(name = "Especialidad.findByEspecialidadCodigo", query = "SELECT e FROM Especialidad e WHERE e.especialidadCodigo = :especialidadCodigo"),
    @NamedQuery(name = "Especialidad.findByEspecialidadDesc", query = "SELECT e FROM Especialidad e WHERE e.especialidadDesc = :especialidadDesc")})
public class Especialidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "especialidad_codigo")
    private Integer especialidadCodigo;
    @Size(max = 100)
    @Column(name = "especialidad_desc")
    private String especialidadDesc;
    @JoinColumn(name = "unidad_codigo", referencedColumnName = "unidad_codigo")
    @ManyToOne(optional = false)
    private Unidad unidadCodigo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "especialidadCodigo")
    private List<Profesional> profesionalList;

    public Especialidad() {
    }

    public Especialidad(Integer especialidadCodigo) {
        this.especialidadCodigo = especialidadCodigo;
    }

    public Integer getEspecialidadCodigo() {
        return especialidadCodigo;
    }

    public void setEspecialidadCodigo(Integer especialidadCodigo) {
        this.especialidadCodigo = especialidadCodigo;
    }

    public String getEspecialidadDesc() {
        return especialidadDesc;
    }

    public void setEspecialidadDesc(String especialidadDesc) {
        this.especialidadDesc = especialidadDesc;
    }

    public Unidad getUnidadCodigo() {
        return unidadCodigo;
    }

    public void setUnidadCodigo(Unidad unidadCodigo) {
        this.unidadCodigo = unidadCodigo;
    }

    @XmlTransient
    public List<Profesional> getProfesionalList() {
        return profesionalList;
    }

    public void setProfesionalList(List<Profesional> profesionalList) {
        this.profesionalList = profesionalList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (especialidadCodigo != null ? especialidadCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Especialidad)) {
            return false;
        }
        Especialidad other = (Especialidad) object;
        if ((this.especialidadCodigo == null && other.especialidadCodigo != null) || (this.especialidadCodigo != null && !this.especialidadCodigo.equals(other.especialidadCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.sistemarce.entity.Especialidad[ especialidadCodigo=" + especialidadCodigo + " ]";
    }
    
}
