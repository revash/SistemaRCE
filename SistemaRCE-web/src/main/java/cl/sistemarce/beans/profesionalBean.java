/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.sistemarce.beans;



import cl.sistemarce.entity.Profesional;
import cl.sistemarce.session.BussinesDemograficoFacade;
import cl.sistemarce.session.BussinesDemograficoFacadeLocal;
import cl.sistemarce.session.ProfesionalFacade;
import cl.sistemarce.utils.appBean;
import static cl.sistemarce.utils.appBean.sha256;
import java.io.IOException;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author AndresEduardo
 */
@ManagedBean
@RequestScoped
public class profesionalBean {
    
    @EJB
    private final BussinesDemograficoFacadeLocal bussinesDemograficoFacade;
    

    @EJB
    private final cl.sistemarce.session.ProfesionalFacadeLocal profesionalFacade;
    private Profesional profeciona;
    private String rut, dv, clave;

    /**
     * Creates a new instance of profecionalBean
     */
    //constructor base, debe instanciar la clase ejb para poder utilizarla, debe
    //dejarse en final la calse ya que no posee get y set
    public profesionalBean() {
        profesionalFacade = new ProfesionalFacade();
        bussinesDemograficoFacade = new BussinesDemograficoFacade();
    }

    //post construct se ejecuta despues de crear el bean, para inicializar datos
    @PostConstruct
    public void myInit() {
        //se deben instanciar las clases ya que sino daran error al ingresarle datos
        profeciona = new Profesional();
    }

    //metodos
    public void login() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        rut = rut.replace("-", "");
        rut = rut.replace(".", "");
        String rut1 = rut.substring(0, rut.length() - 1);
        String dv2 = rut.charAt(rut.length() - 1) + "";
        clave = sha256(clave);
        Profesional profecionalAux = bussinesDemograficoFacade.getProfesionalByRut(Integer.parseInt(rut1), dv2);
        if (profecionalAux == null) {
            System.out.println("null");
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error en Credenciales1", "Datos Invalidos"));
        } else {
            if (profecionalAux.getProfesionalClaveacceso().equals(clave)) {
                System.out.println("clave: " + profecionalAux.getProfesionalClaveacceso());
                System.out.println("clave creada: " +clave);
                 ExternalContext extContext = context.getExternalContext();
                extContext.getSessionMap().put("UsuarioSistema", profecionalAux);
                if(profecionalAux.getRolCodigo().getRolCodigo()==1){
                String url = extContext.encodeActionURL(context.getApplication().getViewHandler().getActionURL(context, "/Administrador/AdminTemplate.xhtml"));
                extContext.redirect(url);}
                else{
                String url = extContext.encodeActionURL(context.getApplication().getViewHandler().getActionURL(context, "/Medico/MedicoTemplate.xhtml"));
                extContext.redirect(url);
                }
                
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error en Credenciales2", "Datos Invalidos"));
            }
        }
    }

    public void onValidaRut() {
        rut = rut.replace("-", "");
        rut = rut.replace(".", "");
        String rut1 = rut.substring(0, rut.length() - 1);
        dv = rut.charAt(rut.length() - 1) + "";
        if (!appBean.validarRut(rut1, dv)) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Rut Invalido", "Rut Invalido"));
        }
    }

    public void onFormateaRut() {
        this.setRut(appBean.FormateaRut(rut));
    }

    //get and set
    public Profesional getProfeciona() {
        return profeciona;
    }

    public void setProfeciona(Profesional profeciona) {
        this.profeciona = profeciona;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getDv() {
        return dv;
    }

    public void setDv(String dv) {
        this.dv = dv;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

}
