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
@Table(name = "region")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Region.findAll", query = "SELECT r FROM Region r"),
    @NamedQuery(name = "Region.findByRegionCodigo", query = "SELECT r FROM Region r WHERE r.regionCodigo = :regionCodigo"),
    @NamedQuery(name = "Region.findByRegionNombre", query = "SELECT r FROM Region r WHERE r.regionNombre = :regionNombre")})
public class Region implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "region_codigo")
    private Integer regionCodigo;
    @Size(max = 100)
    @Column(name = "region_nombre")
    private String regionNombre;
    @OneToMany(mappedBy = "regionCodigo")
    private List<Ciudad> ciudadList;

    public Region() {
    }

    public Region(Integer regionCodigo) {
        this.regionCodigo = regionCodigo;
    }

    public Integer getRegionCodigo() {
        return regionCodigo;
    }

    public void setRegionCodigo(Integer regionCodigo) {
        this.regionCodigo = regionCodigo;
    }

    public String getRegionNombre() {
        return regionNombre;
    }

    public void setRegionNombre(String regionNombre) {
        this.regionNombre = regionNombre;
    }

    @XmlTransient
    public List<Ciudad> getCiudadList() {
        return ciudadList;
    }

    public void setCiudadList(List<Ciudad> ciudadList) {
        this.ciudadList = ciudadList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (regionCodigo != null ? regionCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Region)) {
            return false;
        }
        Region other = (Region) object;
        if ((this.regionCodigo == null && other.regionCodigo != null) || (this.regionCodigo != null && !this.regionCodigo.equals(other.regionCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.sistemarce.entity.Region[ regionCodigo=" + regionCodigo + " ]";
    }
    
}
