/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.sistemarce.session;

import cl.sistemarce.entity.Datosembarazo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresEduardo
 */
@Local
public interface DatosembarazoFacadeLocal {

    void create(Datosembarazo datosembarazo);

    void edit(Datosembarazo datosembarazo);

    void remove(Datosembarazo datosembarazo);

    Datosembarazo find(Object id);

    List<Datosembarazo> findAll();

    List<Datosembarazo> findRange(int[] range);

    int count();
    
}
