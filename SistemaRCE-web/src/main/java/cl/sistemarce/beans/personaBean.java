/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.sistemarce.beans;

import cl.sistemarce.entity.Ciudad;
import cl.sistemarce.entity.Comuna;
import cl.sistemarce.entity.Estadocivil;
import cl.sistemarce.entity.Nacionalidad;
import cl.sistemarce.entity.Niveleducacional;
import cl.sistemarce.entity.Persona;
import cl.sistemarce.entity.Prevision;
import cl.sistemarce.entity.Pueblooriginario;
import cl.sistemarce.entity.Religion;
import cl.sistemarce.entity.Sexo;
import cl.sistemarce.entity.Tipoprevision;
import cl.sistemarce.session.BussinesDemograficoFacade;
import cl.sistemarce.session.BussinesDemograficoFacadeLocal;
import cl.sistemarce.session.CiudadFacade;
import cl.sistemarce.session.CiudadFacadeLocal;
import cl.sistemarce.session.ComunaFacade;
import cl.sistemarce.session.ComunaFacadeLocal;
import cl.sistemarce.session.EstadocivilFacade;
import cl.sistemarce.session.EstadocivilFacadeLocal;
import cl.sistemarce.session.NacionalidadFacade;
import cl.sistemarce.session.NacionalidadFacadeLocal;
import cl.sistemarce.session.NiveleducacionalFacade;
import cl.sistemarce.session.NiveleducacionalFacadeLocal;
import cl.sistemarce.session.PersonaFacade;
import cl.sistemarce.session.PersonaFacadeLocal;
import cl.sistemarce.session.PrevisionFacade;
import cl.sistemarce.session.PrevisionFacadeLocal;
import cl.sistemarce.session.PueblooriginarioFacade;
import cl.sistemarce.session.PueblooriginarioFacadeLocal;
import cl.sistemarce.session.ReligionFacade;
import cl.sistemarce.session.ReligionFacadeLocal;
import cl.sistemarce.session.SexoFacade;
import cl.sistemarce.session.SexoFacadeLocal;
import cl.sistemarce.session.TipoprevisionFacade;
import cl.sistemarce.session.TipoprevisionFacadeLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author AndresEduardo
 */
@ManagedBean
@RequestScoped
public class personaBean {
    @EJB
    private SexoFacadeLocal sexoFacade;
    @EJB
    private final BussinesDemograficoFacadeLocal bussinesDemograficoFacade;
    @EJB
    private final TipoprevisionFacadeLocal tipoprevisionFacade;
    @EJB
    private final ReligionFacadeLocal religionFacade;
    @EJB
    private final PueblooriginarioFacadeLocal pueblooriginarioFacade;
    @EJB
    private final PrevisionFacadeLocal previsionFacade;
    @EJB
    private final NiveleducacionalFacadeLocal niveleducacionalFacade;
    @EJB
    private final NacionalidadFacadeLocal nacionalidadFacade;
    @EJB
    private final EstadocivilFacadeLocal estadocivilFacade;
    @EJB
    private final ComunaFacadeLocal comunaFacade;
    @EJB
    private final CiudadFacadeLocal ciudadFacade;
    @EJB
    private final PersonaFacadeLocal personaFacade;

    private Persona persona;
    private List<Ciudad> ciudades;
    private List<Comuna> comunas;
    private List<Estadocivil> estadosCiviles;
    private List<Nacionalidad> nacionalidades;
    private List<Prevision> previsiones;
    private List<Pueblooriginario> pueblosOriginarios;
    private List<Religion> religiones;
    private List<Tipoprevision> tipoPrevisiones;
    private List<Niveleducacional> nivelesEducacionales;
    private String rut;
    private Prevision prevision;
    private List<Sexo> sexos;

    //Se inicializa persona facade dentro del constructor para poder utilizar las 
    //opciones de CRUD.
    public personaBean() {
        personaFacade = new PersonaFacade();
        ciudadFacade = new CiudadFacade();
        comunaFacade = new ComunaFacade();
        estadocivilFacade = new EstadocivilFacade();
        nacionalidadFacade = new NacionalidadFacade();
        niveleducacionalFacade = new NiveleducacionalFacade();
        previsionFacade = new PrevisionFacade();
        pueblooriginarioFacade = new PueblooriginarioFacade();
        religionFacade = new ReligionFacade();
        tipoprevisionFacade = new TipoprevisionFacade();
        bussinesDemograficoFacade = new BussinesDemograficoFacade();
        sexoFacade = new SexoFacade();
        
        
    }

    //Postconstruct se utiliza para inicializar las variables una vez se crea el constuctor e inicializa el bean
    //sirve para precargar datos en las variables.
    @PostConstruct
    public void myInit() {
        persona = new Persona();
        ciudades = ciudadFacade.findAll();
        comunas = comunaFacade.findAll();
        estadosCiviles = estadocivilFacade.findAll();
        nacionalidades = nacionalidadFacade.findAll();
        previsiones = previsionFacade.findAll();
        pueblosOriginarios = pueblooriginarioFacade.findAll();
        religiones = religionFacade.findAll();
        tipoPrevisiones = tipoprevisionFacade.findAll();
        nivelesEducacionales = niveleducacionalFacade.findAll();
        rut = "";
        prevision = new Prevision();
        sexos = sexoFacade.findAll();
    }
    
    public void onChangeSelect(){
        tipoPrevisiones = bussinesDemograficoFacade.getListTipoPrevisiones(prevision.getPrevisionCodigo());
    }
    //get y set
    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Ciudad> getCiudades() {
        return ciudades;
    }

    public void setCiudades(List<Ciudad> ciudades) {
        this.ciudades = ciudades;
    }

    public List<Comuna> getComunas() {
        return comunas;
    }

    public void setComunas(List<Comuna> comunas) {
        this.comunas = comunas;
    }

    public List<Estadocivil> getEstadosCiviles() {
        return estadosCiviles;
    }

    public void setEstadosCiviles(List<Estadocivil> estadosCiviles) {
        this.estadosCiviles = estadosCiviles;
    }

    public List<Nacionalidad> getNacionalidades() {
        return nacionalidades;
    }

    public void setNacionalidades(List<Nacionalidad> nacionalidades) {
        this.nacionalidades = nacionalidades;
    }

    public List<Prevision> getPrevisiones() {
        return previsiones;
    }

    public void setPrevisiones(List<Prevision> previsiones) {
        this.previsiones = previsiones;
    }

    public List<Pueblooriginario> getPueblosOriginarios() {
        return pueblosOriginarios;
    }

    public void setPueblosOriginarios(List<Pueblooriginario> pueblosOriginarios) {
        this.pueblosOriginarios = pueblosOriginarios;
    }

    public List<Religion> getReligiones() {
        return religiones;
    }

    public void setReligiones(List<Religion> religiones) {
        this.religiones = religiones;
    }

    public List<Tipoprevision> getTipoPrevisiones() {
        return tipoPrevisiones;
    }

    public void setTipoPrevisiones(List<Tipoprevision> tipoPrevisiones) {
        this.tipoPrevisiones = tipoPrevisiones;
    }

    public List<Niveleducacional> getNivelesEducacionales() {
        return nivelesEducacionales;
    }

    public void setNivelesEducacionales(List<Niveleducacional> nivelesEducacionales) {
        this.nivelesEducacionales = nivelesEducacionales;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public Prevision getPrevision() {
        return prevision;
    }

    public void setPrevision(Prevision prevision) {
        this.prevision = prevision;
    }

    public List<Sexo> getSexos() {
        return sexos;
    }

    public void setSexos(List<Sexo> sexos) {
        this.sexos = sexos;
    }

    
    
}
