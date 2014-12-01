/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.sistemarce.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AndresEduardo
 */
@Entity
@Table(name = "diagnosticos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Diagnosticos.findAll", query = "SELECT d FROM Diagnosticos d"),
    @NamedQuery(name = "Diagnosticos.findByObservaciones", query = "SELECT d FROM Diagnosticos d WHERE d.observaciones = :observaciones"),
    @NamedQuery(name = "Diagnosticos.findByDiagnosticoGes", query = "SELECT d FROM Diagnosticos d WHERE d.diagnosticoGes = :diagnosticoGes"),
    @NamedQuery(name = "Diagnosticos.findByDiagnosticoId", query = "SELECT d FROM Diagnosticos d WHERE d.diagnosticoId = :diagnosticoId"),
    @NamedQuery(name = "Diagnosticos.findByControlId", query = "SELECT d FROM Diagnosticos d WHERE d.controlId = :controlId")})
public class Diagnosticos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 2147483647)
    @Column(name = "observaciones")
    private String observaciones;
    @Column(name = "diagnostico_ges")
    private Short diagnosticoGes;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "diagnostico_id")
    private Integer diagnosticoId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "control_id")
    private int controlId;
    @JoinColumn(name = "patologia_codigo", referencedColumnName = "patologia_codigo")
    @ManyToOne(optional = false)
    private Patologias patologiaCodigo;
    @JoinColumn(name = "estado_id", referencedColumnName = "estado_id")
    @ManyToOne(optional = false)
    private Estados estadoId;
    @JoinColumn(name = "correltativocontrolobstetrico", referencedColumnName = "correltativocontrolobstetrico")
    @ManyToOne
    private Controlobstetrico correltativocontrolobstetrico;

    public Diagnosticos() {
    }

    public Diagnosticos(Integer diagnosticoId) {
        this.diagnosticoId = diagnosticoId;
    }

    public Diagnosticos(Integer diagnosticoId, int controlId) {
        this.diagnosticoId = diagnosticoId;
        this.controlId = controlId;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Short getDiagnosticoGes() {
        return diagnosticoGes;
    }

    public void setDiagnosticoGes(Short diagnosticoGes) {
        this.diagnosticoGes = diagnosticoGes;
    }

    public Integer getDiagnosticoId() {
        return diagnosticoId;
    }

    public void setDiagnosticoId(Integer diagnosticoId) {
        this.diagnosticoId = diagnosticoId;
    }

    public int getControlId() {
        return controlId;
    }

    public void setControlId(int controlId) {
        this.controlId = controlId;
    }

    public Patologias getPatologiaCodigo() {
        return patologiaCodigo;
    }

    public void setPatologiaCodigo(Patologias patologiaCodigo) {
        this.patologiaCodigo = patologiaCodigo;
    }

    public Estados getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Estados estadoId) {
        this.estadoId = estadoId;
    }

    public Controlobstetrico getCorreltativocontrolobstetrico() {
        return correltativocontrolobstetrico;
    }

    public void setCorreltativocontrolobstetrico(Controlobstetrico correltativocontrolobstetrico) {
        this.correltativocontrolobstetrico = correltativocontrolobstetrico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (diagnosticoId != null ? diagnosticoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diagnosticos)) {
            return false;
        }
        Diagnosticos other = (Diagnosticos) object;
        if ((this.diagnosticoId == null && other.diagnosticoId != null) || (this.diagnosticoId != null && !this.diagnosticoId.equals(other.diagnosticoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.sistemarce.entity.Diagnosticos[ diagnosticoId=" + diagnosticoId + " ]";
    }
    
}
