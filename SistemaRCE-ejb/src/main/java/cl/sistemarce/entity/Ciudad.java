/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.sistemarce.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "ciudad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ciudad.findAll", query = "SELECT c FROM Ciudad c"),
    @NamedQuery(name = "Ciudad.findByCiudadCodigo", query = "SELECT c FROM Ciudad c WHERE c.ciudadCodigo = :ciudadCodigo"),
    @NamedQuery(name = "Ciudad.findByCiudadNombre", query = "SELECT c FROM Ciudad c WHERE c.ciudadNombre = :ciudadNombre")})
public class Ciudad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ciudad_codigo")
    private Integer ciudadCodigo;
    @Size(max = 100)
    @Column(name = "ciudad_nombre")
    private String ciudadNombre;
    @OneToMany(mappedBy = "ciudadCodigo")
    private List<Comuna> comunaList;
    @JoinColumn(name = "region_codigo", referencedColumnName = "region_codigo")
    @ManyToOne
    private Region regionCodigo;

    public Ciudad() {
    }

    public Ciudad(Integer ciudadCodigo) {
        this.ciudadCodigo = ciudadCodigo;
    }

    public Integer getCiudadCodigo() {
        return ciudadCodigo;
    }

    public void setCiudadCodigo(Integer ciudadCodigo) {
        this.ciudadCodigo = ciudadCodigo;
    }

    public String getCiudadNombre() {
        return ciudadNombre;
    }

    public void setCiudadNombre(String ciudadNombre) {
        this.ciudadNombre = ciudadNombre;
    }

    @XmlTransient
    public List<Comuna> getComunaList() {
        return comunaList;
    }

    public void setComunaList(List<Comuna> comunaList) {
        this.comunaList = comunaList;
    }

    public Region getRegionCodigo() {
        return regionCodigo;
    }

    public void setRegionCodigo(Region regionCodigo) {
        this.regionCodigo = regionCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ciudadCodigo != null ? ciudadCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ciudad)) {
            return false;
        }
        Ciudad other = (Ciudad) object;
        if ((this.ciudadCodigo == null && other.ciudadCodigo != null) || (this.ciudadCodigo != null && !this.ciudadCodigo.equals(other.ciudadCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.sistemarce.entity.Ciudad[ ciudadCodigo=" + ciudadCodigo + " ]";
    }
    
}
