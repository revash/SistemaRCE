/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.sistemarce.session;

import cl.sistemarce.entity.Controldiabetico;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresEduardo
 */
@Local
public interface ControldiabeticoFacadeLocal {

    void create(Controldiabetico controldiabetico);

    void edit(Controldiabetico controldiabetico);

    void remove(Controldiabetico controldiabetico);

    Controldiabetico find(Object id);

    List<Controldiabetico> findAll();

    List<Controldiabetico> findRange(int[] range);

    int count();
    
}
