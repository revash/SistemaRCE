/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.sistemarce.session;

import cl.sistemarce.entity.Controlobstetrico;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresEduardo
 */
@Local
public interface ControlobstetricoFacadeLocal {

    void create(Controlobstetrico controlobstetrico);

    void edit(Controlobstetrico controlobstetrico);

    void remove(Controlobstetrico controlobstetrico);

    Controlobstetrico find(Object id);

    List<Controlobstetrico> findAll();

    List<Controlobstetrico> findRange(int[] range);

    int count();
    
}
