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
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "episodioclinico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Episodioclinico.findAll", query = "SELECT e FROM Episodioclinico e"),
    @NamedQuery(name = "Episodioclinico.findByNumerocorrelativo", query = "SELECT e FROM Episodioclinico e WHERE e.numerocorrelativo = :numerocorrelativo"),
    @NamedQuery(name = "Episodioclinico.findByFechaInicio", query = "SELECT e FROM Episodioclinico e WHERE e.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Episodioclinico.findByFechaTermino", query = "SELECT e FROM Episodioclinico e WHERE e.fechaTermino = :fechaTermino"),
    @NamedQuery(name = "Episodioclinico.findByControlobstetricia", query = "SELECT e FROM Episodioclinico e WHERE e.controlobstetricia = :controlobstetricia"),
    @NamedQuery(name = "Episodioclinico.findByControldiabetico", query = "SELECT e FROM Episodioclinico e WHERE e.controldiabetico = :controldiabetico"),
    @NamedQuery(name = "Episodioclinico.findByEntrevistanutricional", query = "SELECT e FROM Episodioclinico e WHERE e.entrevistanutricional = :entrevistanutricional")})
public class Episodioclinico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "numerocorrelativo")
    private Integer numerocorrelativo;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "fecha_termino")
    @Temporal(TemporalType.DATE)
    private Date fechaTermino;
    @Column(name = "controlobstetricia")
    private Integer controlobstetricia;
    @Column(name = "controldiabetico")
    private Integer controldiabetico;
    @Column(name = "entrevistanutricional")
    private Integer entrevistanutricional;
    @OneToMany(mappedBy = "numerocorrelativo")
    private List<Controldiabetico> controldiabeticoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "episodioclinico")
    private List<Datosembarazo> datosembarazoList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "episodioclinico")
    private Consultanutricional consultanutricional;
    @JoinColumns({
        @JoinColumn(name = "persona_rut", referencedColumnName = "persona_rut"),
        @JoinColumn(name = "persona_dv", referencedColumnName = "persona_dv"),
        @JoinColumn(name = "nacionalidad_codigo", referencedColumnName = "nacionalidad_codigo"),
        @JoinColumn(name = "ficha_numero", referencedColumnName = "ficha_numero")})
    @ManyToOne(optional = false)
    private Paciente paciente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numerocorrelativo")
    private List<Controlobstetrico> controlobstetricoList;

    public Episodioclinico() {
    }

    public Episodioclinico(Integer numerocorrelativo) {
        this.numerocorrelativo = numerocorrelativo;
    }

    public Integer getNumerocorrelativo() {
        return numerocorrelativo;
    }

    public void setNumerocorrelativo(Integer numerocorrelativo) {
        this.numerocorrelativo = numerocorrelativo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(Date fechaTermino) {
        this.fechaTermino = fechaTermino;
    }

    public Integer getControlobstetricia() {
        return controlobstetricia;
    }

    public void setControlobstetricia(Integer controlobstetricia) {
        this.controlobstetricia = controlobstetricia;
    }

    public Integer getControldiabetico() {
        return controldiabetico;
    }

    public void setControldiabetico(Integer controldiabetico) {
        this.controldiabetico = controldiabetico;
    }

    public Integer getEntrevistanutricional() {
        return entrevistanutricional;
    }

    public void setEntrevistanutricional(Integer entrevistanutricional) {
        this.entrevistanutricional = entrevistanutricional;
    }

    @XmlTransient
    public List<Controldiabetico> getControldiabeticoList() {
        return controldiabeticoList;
    }

    public void setControldiabeticoList(List<Controldiabetico> controldiabeticoList) {
        this.controldiabeticoList = controldiabeticoList;
    }

    @XmlTransient
    public List<Datosembarazo> getDatosembarazoList() {
        return datosembarazoList;
    }

    public void setDatosembarazoList(List<Datosembarazo> datosembarazoList) {
        this.datosembarazoList = datosembarazoList;
    }

    public Consultanutricional getConsultanutricional() {
        return consultanutricional;
    }

    public void setConsultanutricional(Consultanutricional consultanutricional) {
        this.consultanutricional = consultanutricional;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @XmlTransient
    public List<Controlobstetrico> getControlobstetricoList() {
        return controlobstetricoList;
    }

    public void setControlobstetricoList(List<Controlobstetrico> controlobstetricoList) {
        this.controlobstetricoList = controlobstetricoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numerocorrelativo != null ? numerocorrelativo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Episodioclinico)) {
            return false;
        }
        Episodioclinico other = (Episodioclinico) object;
        if ((this.numerocorrelativo == null && other.numerocorrelativo != null) || (this.numerocorrelativo != null && !this.numerocorrelativo.equals(other.numerocorrelativo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.sistemarce.entity.Episodioclinico[ numerocorrelativo=" + numerocorrelativo + " ]";
    }
    
}
