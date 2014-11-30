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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

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
    
    //constructor
    public sexoBean() {
        sexoFacade = new SexoFacade();
    }
    
    //postconstructor
    @PostConstruct
    public void myInit(){
        sexos = sexoFacade.findAll();
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
    
    
}
