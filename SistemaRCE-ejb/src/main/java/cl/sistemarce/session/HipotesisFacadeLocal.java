/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.sistemarce.session;

import cl.sistemarce.entity.Hipotesis;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresEduardo
 */
@Local
public interface HipotesisFacadeLocal {

    void create(Hipotesis hipotesis);

    void edit(Hipotesis hipotesis);

    void remove(Hipotesis hipotesis);

    Hipotesis find(Object id);

    List<Hipotesis> findAll();

    List<Hipotesis> findRange(int[] range);

    int count();
    
}
