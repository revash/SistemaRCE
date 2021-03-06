/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.sistemarce.session;

import cl.sistemarce.entity.Agendamiento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresEduardo
 */
@Local
public interface AgendamientoFacadeLocal {

    void create(Agendamiento agendamiento);

    void edit(Agendamiento agendamiento);

    void remove(Agendamiento agendamiento);

    Agendamiento find(Object id);

    List<Agendamiento> findAll();

    List<Agendamiento> findRange(int[] range);

    int count();
    
}
