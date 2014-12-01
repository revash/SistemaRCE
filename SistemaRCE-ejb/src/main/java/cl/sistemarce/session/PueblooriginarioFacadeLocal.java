/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.sistemarce.session;

import cl.sistemarce.entity.Pueblooriginario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresEduardo
 */
@Local
public interface PueblooriginarioFacadeLocal {

    void create(Pueblooriginario pueblooriginario);

    void edit(Pueblooriginario pueblooriginario);

    void remove(Pueblooriginario pueblooriginario);

    Pueblooriginario find(Object id);

    List<Pueblooriginario> findAll();

    List<Pueblooriginario> findRange(int[] range);

    int count();
    
}
