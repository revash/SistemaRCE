/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.sistemarce.session;

import cl.sistemarce.entity.Diagnosticos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresEduardo
 */
@Local
public interface DiagnosticosFacadeLocal {

    void create(Diagnosticos diagnosticos);

    void edit(Diagnosticos diagnosticos);

    void remove(Diagnosticos diagnosticos);

    Diagnosticos find(Object id);

    List<Diagnosticos> findAll();

    List<Diagnosticos> findRange(int[] range);

    int count();
    
}
