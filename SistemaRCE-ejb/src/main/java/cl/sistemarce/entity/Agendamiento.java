/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.sistemarce.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AndresEduardo
 */
@Entity
@Table(name = "agendamiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Agendamiento.findAll", query = "SELECT a FROM Agendamiento a"),
    @NamedQuery(name = "Agendamiento.findByFecha", query = "SELECT a FROM Agendamiento a WHERE a.agendamientoPK.fecha = :fecha"),
    @NamedQuery(name = "Agendamiento.findByHora", query = "SELECT a FROM Agendamiento a WHERE a.agendamientoPK.hora = :hora")})
public class Agendamiento implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AgendamientoPK agendamientoPK;
    @JoinColumns({
        @JoinColumn(name = "persona_rut", referencedColumnName = "persona_rut"),
        @JoinColumn(name = "persona_dv", referencedColumnName = "persona_dv"),
        @JoinColumn(name = "nacionalidad_codigo", referencedColumnName = "nacionalidad_codigo"),
        @JoinColumn(name = "ficha_numero", referencedColumnName = "ficha_numero")})
    @ManyToOne(optional = false)
    private Paciente paciente;
    @JoinColumn(name = "especialidad_codigo", referencedColumnName = "especialidad_codigo")
    @ManyToOne(optional = false)
    private Especialidad especialidadCodigo;

    public Agendamiento() {
    }

    public Agendamiento(AgendamientoPK agendamientoPK) {
        this.agendamientoPK = agendamientoPK;
    }

    public Agendamiento(Date fecha, Date hora) {
        this.agendamientoPK = new AgendamientoPK(fecha, hora);
    }

    public AgendamientoPK getAgendamientoPK() {
        return agendamientoPK;
    }

    public void setAgendamientoPK(AgendamientoPK agendamientoPK) {
        this.agendamientoPK = agendamientoPK;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Especialidad getEspecialidadCodigo() {
        return especialidadCodigo;
    }

    public void setEspecialidadCodigo(Especialidad especialidadCodigo) {
        this.especialidadCodigo = especialidadCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (agendamientoPK != null ? agendamientoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Agendamiento)) {
            return false;
        }
        Agendamiento other = (Agendamiento) object;
        if ((this.agendamientoPK == null && other.agendamientoPK != null) || (this.agendamientoPK != null && !this.agendamientoPK.equals(other.agendamientoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.sistemarce.entity.Agendamiento[ agendamientoPK=" + agendamientoPK + " ]";
    }
    
}
