/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.sistemarce.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AndresEduardo
 */
@Entity
@Table(name = "ficha")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ficha.findAll", query = "SELECT f FROM Ficha f"),
    @NamedQuery(name = "Ficha.findByFichaNumero", query = "SELECT f FROM Ficha f WHERE f.fichaNumero = :fichaNumero"),
    @NamedQuery(name = "Ficha.findByFichaFechaCreacion", query = "SELECT f FROM Ficha f WHERE f.fichaFechaCreacion = :fichaFechaCreacion"),
    @NamedQuery(name = "Ficha.findByFichaFechaBaja", query = "SELECT f FROM Ficha f WHERE f.fichaFechaBaja = :fichaFechaBaja")})
public class Ficha implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ficha_numero")
    private Integer fichaNumero;
    @Column(name = "ficha_fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fichaFechaCreacion;
    @Column(name = "ficha_fecha_baja")
    @Temporal(TemporalType.DATE)
    private Date fichaFechaBaja;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ficha")
    private List<Paciente> pacienteList;

    public Ficha() {
    }

    public Ficha(Integer fichaNumero) {
        this.fichaNumero = fichaNumero;
    }

    public Integer getFichaNumero() {
        return fichaNumero;
    }

    public void setFichaNumero(Integer fichaNumero) {
        this.fichaNumero = fichaNumero;
    }

    public Date getFichaFechaCreacion() {
        return fichaFechaCreacion;
    }

    public void setFichaFechaCreacion(Date fichaFechaCreacion) {
        this.fichaFechaCreacion = fichaFechaCreacion;
    }

    public Date getFichaFechaBaja() {
        return fichaFechaBaja;
    }

    public void setFichaFechaBaja(Date fichaFechaBaja) {
        this.fichaFechaBaja = fichaFechaBaja;
    }

    @XmlTransient
    public List<Paciente> getPacienteList() {
        return pacienteList;
    }

    public void setPacienteList(List<Paciente> pacienteList) {
        this.pacienteList = pacienteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fichaNumero != null ? fichaNumero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ficha)) {
            return false;
        }
        Ficha other = (Ficha) object;
        if ((this.fichaNumero == null && other.fichaNumero != null) || (this.fichaNumero != null && !this.fichaNumero.equals(other.fichaNumero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.sistemarce.entity.Ficha[ fichaNumero=" + fichaNumero + " ]";
    }
    
}
