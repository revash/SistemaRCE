/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.sistemarce.session;

import cl.sistemarce.entity.Datosobstetricos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresEduardo
 */
@Local
public interface DatosobstetricosFacadeLocal {

    void create(Datosobstetricos datosobstetricos);

    void edit(Datosobstetricos datosobstetricos);

    void remove(Datosobstetricos datosobstetricos);

    Datosobstetricos find(Object id);

    List<Datosobstetricos> findAll();

    List<Datosobstetricos> findRange(int[] range);

    int count();
    
}
