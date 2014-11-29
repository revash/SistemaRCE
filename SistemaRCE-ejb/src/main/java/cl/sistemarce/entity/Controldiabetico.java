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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AndresEduardo
 */
@Entity
@Table(name = "controldiabetico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Controldiabetico.findAll", query = "SELECT c FROM Controldiabetico c"),
    @NamedQuery(name = "Controldiabetico.findByCdId", query = "SELECT c FROM Controldiabetico c WHERE c.cdId = :cdId"),
    @NamedQuery(name = "Controldiabetico.findByCdFecha", query = "SELECT c FROM Controldiabetico c WHERE c.cdFecha = :cdFecha"),
    @NamedQuery(name = "Controldiabetico.findByCdAntDiabFam", query = "SELECT c FROM Controldiabetico c WHERE c.cdAntDiabFam = :cdAntDiabFam"),
    @NamedQuery(name = "Controldiabetico.findByCdAntecedentesMorbidos", query = "SELECT c FROM Controldiabetico c WHERE c.cdAntecedentesMorbidos = :cdAntecedentesMorbidos"),
    @NamedQuery(name = "Controldiabetico.findByCdDiagIngreso", query = "SELECT c FROM Controldiabetico c WHERE c.cdDiagIngreso = :cdDiagIngreso"),
    @NamedQuery(name = "Controldiabetico.findByCdDiagExamDiabetes", query = "SELECT c FROM Controldiabetico c WHERE c.cdDiagExamDiabetes = :cdDiagExamDiabetes"),
    @NamedQuery(name = "Controldiabetico.findByCdResultadoExam", query = "SELECT c FROM Controldiabetico c WHERE c.cdResultadoExam = :cdResultadoExam"),
    @NamedQuery(name = "Controldiabetico.findByCdTipoTratamiento", query = "SELECT c FROM Controldiabetico c WHERE c.cdTipoTratamiento = :cdTipoTratamiento"),
    @NamedQuery(name = "Controldiabetico.findByCdHospitalizacion", query = "SELECT c FROM Controldiabetico c WHERE c.cdHospitalizacion = :cdHospitalizacion"),
    @NamedQuery(name = "Controldiabetico.findByCdRegimenExclisivo", query = "SELECT c FROM Controldiabetico c WHERE c.cdRegimenExclisivo = :cdRegimenExclisivo"),
    @NamedQuery(name = "Controldiabetico.findByCdOtros", query = "SELECT c FROM Controldiabetico c WHERE c.cdOtros = :cdOtros")})
public class Controldiabetico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cd_id")
    private Integer cdId;
    @Column(name = "cd_fecha")
    @Temporal(TemporalType.DATE)
    private Date cdFecha;
    @Size(max = 2147483647)
    @Column(name = "cd_ant_diab_fam")
    private String cdAntDiabFam;
    @Size(max = 2147483647)
    @Column(name = "cd_antecedentes_morbidos")
    private String cdAntecedentesMorbidos;
    @Size(max = 2147483647)
    @Column(name = "cd_diag_ingreso")
    private String cdDiagIngreso;
    @Size(max = 2147483647)
    @Column(name = "cd_diag_exam_diabetes")
    private String cdDiagExamDiabetes;
    @Column(name = "cd_resultado_exam")
    private Integer cdResultadoExam;
    @Size(max = 2147483647)
    @Column(name = "cd_tipo_tratamiento")
    private String cdTipoTratamiento;
    @Column(name = "cd_hospitalizacion")
    private Short cdHospitalizacion;
    @Size(max = 2147483647)
    @Column(name = "cd_regimen_exclisivo")
    private String cdRegimenExclisivo;
    @Size(max = 2147483647)
    @Column(name = "cd_otros")
    private String cdOtros;
    @JoinColumns({
        @JoinColumn(name = "profesionalrut", referencedColumnName = "profesionalrut"),
        @JoinColumn(name = "profesional_dv", referencedColumnName = "profesional_dv")})
    @ManyToOne(optional = false)
    private Profesional profesional;
    @JoinColumn(name = "episodio_numero", referencedColumnName = "episodio_numero")
    @ManyToOne(optional = false)
    private Episodioclinicoobstetrico episodioNumero;
    @OneToMany(mappedBy = "cdId")
    private List<Historialcontroldiabetico> historialcontroldiabeticoList;

    public Controldiabetico() {
    }

    public Controldiabetico(Integer cdId) {
        this.cdId = cdId;
    }

    public Integer getCdId() {
        return cdId;
    }

    public void setCdId(Integer cdId) {
        this.cdId = cdId;
    }

    public Date getCdFecha() {
        return cdFecha;
    }

    public void setCdFecha(Date cdFecha) {
        this.cdFecha = cdFecha;
    }

    public String getCdAntDiabFam() {
        return cdAntDiabFam;
    }

    public void setCdAntDiabFam(String cdAntDiabFam) {
        this.cdAntDiabFam = cdAntDiabFam;
    }

    public String getCdAntecedentesMorbidos() {
        return cdAntecedentesMorbidos;
    }

    public void setCdAntecedentesMorbidos(String cdAntecedentesMorbidos) {
        this.cdAntecedentesMorbidos = cdAntecedentesMorbidos;
    }

    public String getCdDiagIngreso() {
        return cdDiagIngreso;
    }

    public void setCdDiagIngreso(String cdDiagIngreso) {
        this.cdDiagIngreso = cdDiagIngreso;
    }

    public String getCdDiagExamDiabetes() {
        return cdDiagExamDiabetes;
    }

    public void setCdDiagExamDiabetes(String cdDiagExamDiabetes) {
        this.cdDiagExamDiabetes = cdDiagExamDiabetes;
    }

    public Integer getCdResultadoExam() {
        return cdResultadoExam;
    }

    public void setCdResultadoExam(Integer cdResultadoExam) {
        this.cdResultadoExam = cdResultadoExam;
    }

    public String getCdTipoTratamiento() {
        return cdTipoTratamiento;
    }

    public void setCdTipoTratamiento(String cdTipoTratamiento) {
        this.cdTipoTratamiento = cdTipoTratamiento;
    }

    public Short getCdHospitalizacion() {
        return cdHospitalizacion;
    }

    public void setCdHospitalizacion(Short cdHospitalizacion) {
        this.cdHospitalizacion = cdHospitalizacion;
    }

    public String getCdRegimenExclisivo() {
        return cdRegimenExclisivo;
    }

    public void setCdRegimenExclisivo(String cdRegimenExclisivo) {
        this.cdRegimenExclisivo = cdRegimenExclisivo;
    }

    public String getCdOtros() {
        return cdOtros;
    }

    public void setCdOtros(String cdOtros) {
        this.cdOtros = cdOtros;
    }

    public Profesional getProfesional() {
        return profesional;
    }

    public void setProfesional(Profesional profesional) {
        this.profesional = profesional;
    }

    public Episodioclinicoobstetrico getEpisodioNumero() {
        return episodioNumero;
    }

    public void setEpisodioNumero(Episodioclinicoobstetrico episodioNumero) {
        this.episodioNumero = episodioNumero;
    }

    @XmlTransient
    public List<Historialcontroldiabetico> getHistorialcontroldiabeticoList() {
        return historialcontroldiabeticoList;
    }

    public void setHistorialcontroldiabeticoList(List<Historialcontroldiabetico> historialcontroldiabeticoList) {
        this.historialcontroldiabeticoList = historialcontroldiabeticoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdId != null ? cdId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Controldiabetico)) {
            return false;
        }
        Controldiabetico other = (Controldiabetico) object;
        if ((this.cdId == null && other.cdId != null) || (this.cdId != null && !this.cdId.equals(other.cdId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.sistemarce.entity.Controldiabetico[ cdId=" + cdId + " ]";
    }
    
}
