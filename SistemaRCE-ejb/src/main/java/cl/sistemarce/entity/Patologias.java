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
@Table(name = "patologias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Patologias.findAll", query = "SELECT p FROM Patologias p"),
    @NamedQuery(name = "Patologias.findByPatologiaCodigo", query = "SELECT p FROM Patologias p WHERE p.patologiaCodigo = :patologiaCodigo"),
    @NamedQuery(name = "Patologias.findByPatologiaGes", query = "SELECT p FROM Patologias p WHERE p.patologiaGes = :patologiaGes"),
    @NamedQuery(name = "Patologias.findByPatologiaNombre", query = "SELECT p FROM Patologias p WHERE p.patologiaNombre = :patologiaNombre")})
public class Patologias implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "patologia_codigo")
    private Integer patologiaCodigo;
    @Column(name = "patologia_ges")
    private Short patologiaGes;
    @Size(max = 100)
    @Column(name = "patologia_nombre")
    private String patologiaNombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patologiaCodigo")
    private List<Diagnosticos> diagnosticosList;

    public Patologias() {
    }

    public Patologias(Integer patologiaCodigo) {
        this.patologiaCodigo = patologiaCodigo;
    }

    public Integer getPatologiaCodigo() {
        return patologiaCodigo;
    }

    public void setPatologiaCodigo(Integer patologiaCodigo) {
        this.patologiaCodigo = patologiaCodigo;
    }

    public Short getPatologiaGes() {
        return patologiaGes;
    }

    public void setPatologiaGes(Short patologiaGes) {
        this.patologiaGes = patologiaGes;
    }

    public String getPatologiaNombre() {
        return patologiaNombre;
    }

    public void setPatologiaNombre(String patologiaNombre) {
        this.patologiaNombre = patologiaNombre;
    }

    @XmlTransient
    public List<Diagnosticos> getDiagnosticosList() {
        return diagnosticosList;
    }

    public void setDiagnosticosList(List<Diagnosticos> diagnosticosList) {
        this.diagnosticosList = diagnosticosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (patologiaCodigo != null ? patologiaCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Patologias)) {
            return false;
        }
        Patologias other = (Patologias) object;
        if ((this.patologiaCodigo == null && other.patologiaCodigo != null) || (this.patologiaCodigo != null && !this.patologiaCodigo.equals(other.patologiaCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.sistemarce.entity.Patologias[ patologiaCodigo=" + patologiaCodigo + " ]";
    }
    
}
