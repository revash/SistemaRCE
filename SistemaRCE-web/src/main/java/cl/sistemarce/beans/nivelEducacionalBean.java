/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.sistemarce.beans;


import cl.sistemarce.entity.Niveleducacional;
import cl.sistemarce.session.NiveleducacionalFacade;
import cl.sistemarce.session.NiveleducacionalFacadeLocal;
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
 * @author Mauro
 */
@ManagedBean
@RequestScoped
public class nivelEducacionalBean {
    @EJB
    private final NiveleducacionalFacadeLocal niveleducacionalFacade;
    private Niveleducacional nivel;
    private List<Niveleducacional> niveles;
    private List<Niveleducacional> filterNiveles;
    private Niveleducacional selectNivel;
    private boolean boton;
        

    /**
     * Creates a new instance of nivelEducacionalBean
     */
    public nivelEducacionalBean() {
        niveleducacionalFacade = new NiveleducacionalFacade();
    
    }
    @PostConstruct
    public void myInit() {
        niveles = niveleducacionalFacade.findAll(); 
        nivel = new Niveleducacional();
        selectNivel = new Niveleducacional();
        boton = true;
        
    }
    public void createNiveles(ActionEvent event){
        FacesContext context = FacesContext.getCurrentInstance();
        RequestContext reqContext = RequestContext.getCurrentInstance();
        boolean creado = false;
        String formulario ="formCreateNivel";
        String dialog ="";
        if (nivel.getNiveleducacionalNombre().equalsIgnoreCase("")){
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Debe ingresar nombre del nivel educacional", null));
        }else{
            niveleducacionalFacade.create(nivel);
            nivel = new Niveleducacional();
            formulario = "crearNivel";
            dialog ="dlg1";
            creado = true;
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Datos Correctamente Creados", null));
          }
        niveles = niveleducacionalFacade.findAll();
        reqContext.addCallbackParam("formulario", formulario);
        reqContext.addCallbackParam("creado", creado);
        reqContext.addCallbackParam("dialog", dialog);
    }
        public void updateNiveles(ActionEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        RequestContext reqContext = RequestContext.getCurrentInstance();
        boolean creado = false;
        String formulario = "";
        String dialog = "";
        if (nivel.getNiveleducacionalNombre().equalsIgnoreCase("")) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Debe ingresar nombre del nivel educacional", null));
        } else {
            niveleducacionalFacade.edit(nivel);
            nivel=new Niveleducacional();
            formulario = "formEditNivel";
            dialog = "dlg2";
            creado = true;
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Datos Correctamente Editados", null));
        }
        niveles = niveleducacionalFacade.findAll();
        reqContext.addCallbackParam("formulario", formulario);
        reqContext.addCallbackParam("creado", creado);
        reqContext.addCallbackParam("dialog", dialog);
    }

    public Niveleducacional getNivel() {
        return nivel;
    }

    public void setNivel(Niveleducacional nivel) {
        this.nivel = nivel;
    }

    public List<Niveleducacional> getNiveles() {
        return niveles;
    }

    public void setNiveles(List<Niveleducacional> niveles) {
        this.niveles = niveles;
    }

    public List<Niveleducacional> getFilterNiveles() {
        return filterNiveles;
    }

    public void setFilterNiveles(List<Niveleducacional> filterNiveles) {
        this.filterNiveles = filterNiveles;
    }

    public Niveleducacional getSelectNivel() {
        return selectNivel;
    }

    public void setSelectNivel(Niveleducacional selectNivel) {
        this.selectNivel = selectNivel;
    }

    public boolean isBoton() {
        return boton;
    }

    public void setBoton(boolean boton) {
        this.boton = boton;
    }
        
}
