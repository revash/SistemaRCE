/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.sistemarce.session;

import cl.sistemarce.entity.Historialcontroldiabetico;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresEduardo
 */
@Local
public interface HistorialcontroldiabeticoFacadeLocal {

    void create(Historialcontroldiabetico historialcontroldiabetico);

    void edit(Historialcontroldiabetico historialcontroldiabetico);

    void remove(Historialcontroldiabetico historialcontroldiabetico);

    Historialcontroldiabetico find(Object id);

    List<Historialcontroldiabetico> findAll();

    List<Historialcontroldiabetico> findRange(int[] range);

    int count();
    
}
