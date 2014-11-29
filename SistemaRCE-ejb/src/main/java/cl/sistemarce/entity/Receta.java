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
@Table(name = "receta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Receta.findAll", query = "SELECT r FROM Receta r"),
    @NamedQuery(name = "Receta.findByRecetaId", query = "SELECT r FROM Receta r WHERE r.recetaId = :recetaId"),
    @NamedQuery(name = "Receta.findByRecetaFecha", query = "SELECT r FROM Receta r WHERE r.recetaFecha = :recetaFecha"),
    @NamedQuery(name = "Receta.findByRecetaCuerpo", query = "SELECT r FROM Receta r WHERE r.recetaCuerpo = :recetaCuerpo")})
public class Receta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "receta_id")
    private Integer recetaId;
    @Column(name = "receta_fecha")
    @Temporal(TemporalType.DATE)
    private Date recetaFecha;
    @Size(max = 2147483647)
    @Column(name = "receta_cuerpo")
    private String recetaCuerpo;
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

    public Receta() {
    }

    public Receta(Integer recetaId) {
        this.recetaId = recetaId;
    }

    public Integer getRecetaId() {
        return recetaId;
    }

    public void setRecetaId(Integer recetaId) {
        this.recetaId = recetaId;
    }

    public Date getRecetaFecha() {
        return recetaFecha;
    }

    public void setRecetaFecha(Date recetaFecha) {
        this.recetaFecha = recetaFecha;
    }

    public String getRecetaCuerpo() {
        return recetaCuerpo;
    }

    public void setRecetaCuerpo(String recetaCuerpo) {
        this.recetaCuerpo = recetaCuerpo;
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
        hash += (recetaId != null ? recetaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Receta)) {
            return false;
        }
        Receta other = (Receta) object;
        if ((this.recetaId == null && other.recetaId != null) || (this.recetaId != null && !this.recetaId.equals(other.recetaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.sistemarce.entity.Receta[ recetaId=" + recetaId + " ]";
    }
    
}
