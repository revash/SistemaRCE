/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.sistemarce.beans;

import cl.sistemarce.entity.Sexo;
import cl.sistemarce.session.SexoFacade;
import cl.sistemarce.session.SexoFacadeLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.context.RequestContext;

/**
 *
 * @author AndresEduardo
 */
@ManagedBean
@RequestScoped
public class sexoBean {

    //declaracion de variables
    @EJB
    private final SexoFacadeLocal sexoFacade;
    private Sexo sexo;
    private List<Sexo> sexos;
    private List<Sexo> filterSexos;
    private Sexo selectedSexo;
    private boolean boton;

    //constructor
    public sexoBean() {
        sexoFacade = new SexoFacade();
    }

    //postconstructor
    @PostConstruct
    public void myInit() {
        sexos = sexoFacade.findAll();
        sexo = new Sexo();
        selectedSexo = new Sexo();
        boton = true;
    }

    //metodos
    public void createSexo(ActionEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        RequestContext reqContext = RequestContext.getCurrentInstance();
        boolean creado = false;
        String formulario = "formCreateSexo";
        String dialog = "";
        if (sexo.getSexoDescripcion().equalsIgnoreCase("")) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Debe Ingresar Datos En Descripcion Sexo", null));
        } else {
            sexoFacade.create(sexo);
            sexo=new Sexo();
            formulario = "crearSexos";
            dialog = "dlg1";
            creado = true;
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Datos Correctamente Creados", null));
        }
        sexos = sexoFacade.findAll();
        reqContext.addCallbackParam("formulario", formulario);
        reqContext.addCallbackParam("creado", creado);
        reqContext.addCallbackParam("dialog", dialog);
    }
    
    public void updateSexo(ActionEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        RequestContext reqContext = RequestContext.getCurrentInstance();
        boolean creado = false;
        String formulario = "";
        String dialog = "";
        if (sexo.getSexoDescripcion().equalsIgnoreCase("")) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Debe Ingresar Datos En Descripcion Sexo", null));
        } else {
            sexoFacade.edit(sexo);
            sexo=new Sexo();
            formulario = "formEditSexo";
            dialog = "dlg2";
            creado = true;
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Datos Correctamente Editados", null));
        }
        sexos = sexoFacade.findAll();
        reqContext.addCallbackParam("formulario", formulario);
        reqContext.addCallbackParam("creado", creado);
        reqContext.addCallbackParam("dialog", dialog);
    }
    
    public void onRowSelect() {
        boton = false;
        sexo = selectedSexo;
    }

    //get and set
    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public List<Sexo> getSexos() {
        return sexos;
    }

    public void setSexos(List<Sexo> sexos) {
        this.sexos = sexos;
    }

    public List<Sexo> getFilterSexos() {
        return filterSexos;
    }

    public void setFilterSexos(List<Sexo> filterSexos) {
        this.filterSexos = filterSexos;
    }

    public Sexo getSelectedSexo() {
        return selectedSexo;
    }

    public void setSelectedSexo(Sexo selectedSexo) {
        this.selectedSexo = selectedSexo;
    }

    public boolean isBoton() {
        return boton;
    }

    public void setBoton(boolean boton) {
        this.boton = boton;
    }
    
    

}
