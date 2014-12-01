/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.sistemarce.session;

import cl.sistemarce.entity.Tratamiento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresEduardo
 */
@Local
public interface TratamientoFacadeLocal {

    void create(Tratamiento tratamiento);

    void edit(Tratamiento tratamiento);

    void remove(Tratamiento tratamiento);

    Tratamiento find(Object id);

    List<Tratamiento> findAll();

    List<Tratamiento> findRange(int[] range);

    int count();
    
}
