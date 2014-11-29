/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.sistemarce.session;

import cl.sistemarce.entity.Tiposhipotesis;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresEduardo
 */
@Local
public interface TiposhipotesisFacadeLocal {

    void create(Tiposhipotesis tiposhipotesis);

    void edit(Tiposhipotesis tiposhipotesis);

    void remove(Tiposhipotesis tiposhipotesis);

    Tiposhipotesis find(Object id);

    List<Tiposhipotesis> findAll();

    List<Tiposhipotesis> findRange(int[] range);

    int count();
    
}
