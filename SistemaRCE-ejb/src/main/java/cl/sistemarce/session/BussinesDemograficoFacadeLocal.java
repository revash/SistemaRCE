/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.sistemarce.session;


import cl.sistemarce.entity.Profesional;
import cl.sistemarce.entity.Tipoprevision;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresEduardo
 */
@Local
public interface BussinesDemograficoFacadeLocal {
    
    public Profesional getProfesionalByRut(Integer rut,String dv);
    public List<Tipoprevision> getListTipoPrevisiones(Integer id);
}
