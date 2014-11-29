/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.sistemarce.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AndresEduardo
 */
@Entity
@Table(name = "tratamiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tratamiento.findAll", query = "SELECT t FROM Tratamiento t"),
    @NamedQuery(name = "Tratamiento.findByTratamientoId", query = "SELECT t FROM Tratamiento t WHERE t.tratamientoId = :tratamientoId"),
    @NamedQuery(name = "Tratamiento.findByTratamientoFecha", query = "SELECT t FROM Tratamiento t WHERE t.tratamientoFecha = :tratamientoFecha"),
    @NamedQuery(name = "Tratamiento.findByTratamientoCuerpo", query = "SELECT t FROM Tratamiento t WHERE t.tratamientoCuerpo = :tratamientoCuerpo")})
public class Tratamiento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "tratamiento_id")
    private Integer tratamientoId;
    @Column(name = "tratamiento_fecha")
    @Temporal(TemporalType.DATE)
    private Date tratamientoFecha;
    @Size(max = 2147483647)
    @Column(name = "tratamiento_cuerpo")
    private String tratamientoCuerpo;
    @JoinColumns({
        @JoinColumn(name = "profesionalrut", referencedColumnName = "profesionalrut"),
        @JoinColumn(name = "profesional_dv", referencedColumnName = "profesional_dv")})
    @ManyToOne(optional = false)
    private Profesional profesional;
    @JoinColumns({
        @JoinColumn(name = "persona_rut", referencedColumnName = "persona_rut"),
        @JoinColumn(name = "persona_dv", referencedColumnName = "persona_dv"),
        @JoinColumn(name = "nacionalidad_codigo", referencedColumnName = "nacionalidad_codigo"),
        @JoinColumn(name = "ficha_numero", referencedColumnName = "ficha_numero")})
    @ManyToOne(optional = false)
    private Paciente paciente;
    @JoinColumn(name = "episodio_numero", referencedColumnName = "episodio_numero")
    @ManyToOne(optional = false)
    private Episodioclinicoobstetrico episodioNumero;

    public Tratamiento() {
    }

    public Tratamiento(Integer tratamientoId) {
        this.tratamientoId = tratamientoId;
    }

    public Integer getTratamientoId() {
        return tratamientoId;
    }

    public void setTratamientoId(Integer tratamientoId) {
        this.tratamientoId = tratamientoId;
    }

    public Date getTratamientoFecha() {
        return tratamientoFecha;
    }

    public void setTratamientoFecha(Date tratamientoFecha) {
        this.tratamientoFecha = tratamientoFecha;
    }

    public String getTratamientoCuerpo() {
        return tratamientoCuerpo;
    }

    public void setTratamientoCuerpo(String tratamientoCuerpo) {
        this.tratamientoCuerpo = tratamientoCuerpo;
    }

    public Profesional getProfesional() {
        return profesional;
    }

    public void setProfesional(Profesional profesional) {
        this.profesional = profesional;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Episodioclinicoobstetrico getEpisodioNumero() {
        return episodioNumero;
    }

    public void setEpisodioNumero(Episodioclinicoobstetrico episodioNumero) {
        this.episodioNumero = episodioNumero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tratamientoId != null ? tratamientoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tratamiento)) {
            return false;
        }
        Tratamiento other = (Tratamiento) object;
        if ((this.tratamientoId == null && other.tratamientoId != null) || (this.tratamientoId != null && !this.tratamientoId.equals(other.tratamientoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.sistemarce.entity.Tratamiento[ tratamientoId=" + tratamientoId + " ]";
    }
    
}
