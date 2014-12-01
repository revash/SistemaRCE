/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.sistemarce.session;

import cl.sistemarce.entity.Profesional;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresEduardo
 */
@Local
public interface ProfesionalFacadeLocal {

    void create(Profesional profesional);

    void edit(Profesional profesional);

    void remove(Profesional profesional);

    Profesional find(Object id);

    List<Profesional> findAll();

    List<Profesional> findRange(int[] range);

    int count();
    
}
