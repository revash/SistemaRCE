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
@Table(name = "unidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Unidad.findAll", query = "SELECT u FROM Unidad u"),
    @NamedQuery(name = "Unidad.findByUnidadCodigo", query = "SELECT u FROM Unidad u WHERE u.unidadCodigo = :unidadCodigo"),
    @NamedQuery(name = "Unidad.findByUnidadDesc", query = "SELECT u FROM Unidad u WHERE u.unidadDesc = :unidadDesc")})
public class Unidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "unidad_codigo")
    private Integer unidadCodigo;
    @Size(max = 100)
    @Column(name = "unidad_desc")
    private String unidadDesc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unidadCodigo")
    private List<Especialidad> especialidadList;

    public Unidad() {
    }

    public Unidad(Integer unidadCodigo) {
        this.unidadCodigo = unidadCodigo;
    }

    public Integer getUnidadCodigo() {
        return unidadCodigo;
    }

    public void setUnidadCodigo(Integer unidadCodigo) {
        this.unidadCodigo = unidadCodigo;
    }

    public String getUnidadDesc() {
        return unidadDesc;
    }

    public void setUnidadDesc(String unidadDesc) {
        this.unidadDesc = unidadDesc;
    }

    @XmlTransient
    public List<Especialidad> getEspecialidadList() {
        return especialidadList;
    }

    public void setEspecialidadList(List<Especialidad> especialidadList) {
        this.especialidadList = especialidadList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (unidadCodigo != null ? unidadCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Unidad)) {
            return false;
        }
        Unidad other = (Unidad) object;
        if ((this.unidadCodigo == null && other.unidadCodigo != null) || (this.unidadCodigo != null && !this.unidadCodigo.equals(other.unidadCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.sistemarce.entity.Unidad[ unidadCodigo=" + unidadCodigo + " ]";
    }
    
}
