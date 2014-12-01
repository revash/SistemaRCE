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
@Table(name = "estados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estados.findAll", query = "SELECT e FROM Estados e"),
    @NamedQuery(name = "Estados.findByEstadoId", query = "SELECT e FROM Estados e WHERE e.estadoId = :estadoId"),
    @NamedQuery(name = "Estados.findByEstadoDesc", query = "SELECT e FROM Estados e WHERE e.estadoDesc = :estadoDesc")})
public class Estados implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_id")
    private Integer estadoId;
    @Size(max = 100)
    @Column(name = "estado_desc")
    private String estadoDesc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoId")
    private List<Diagnosticos> diagnosticosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoId")
    private List<Hipotesis> hipotesisList;

    public Estados() {
    }

    public Estados(Integer estadoId) {
        this.estadoId = estadoId;
    }

    public Integer getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Integer estadoId) {
        this.estadoId = estadoId;
    }

    public String getEstadoDesc() {
        return estadoDesc;
    }

    public void setEstadoDesc(String estadoDesc) {
        this.estadoDesc = estadoDesc;
    }

    @XmlTransient
    public List<Diagnosticos> getDiagnosticosList() {
        return diagnosticosList;
    }

    public void setDiagnosticosList(List<Diagnosticos> diagnosticosList) {
        this.diagnosticosList = diagnosticosList;
    }

    @XmlTransient
    public List<Hipotesis> getHipotesisList() {
        return hipotesisList;
    }

    public void setHipotesisList(List<Hipotesis> hipotesisList) {
        this.hipotesisList = hipotesisList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estadoId != null ? estadoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estados)) {
            return false;
        }
        Estados other = (Estados) object;
        if ((this.estadoId == null && other.estadoId != null) || (this.estadoId != null && !this.estadoId.equals(other.estadoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.sistemarce.entity.Estados[ estadoId=" + estadoId + " ]";
    }
    
}
