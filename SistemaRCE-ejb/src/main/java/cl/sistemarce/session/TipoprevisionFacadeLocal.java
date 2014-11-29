/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.sistemarce.session;

import cl.sistemarce.entity.Tipoprevision;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresEduardo
 */
@Local
public interface TipoprevisionFacadeLocal {

    void create(Tipoprevision tipoprevision);

    void edit(Tipoprevision tipoprevision);

    void remove(Tipoprevision tipoprevision);

    Tipoprevision find(Object id);

    List<Tipoprevision> findAll();

    List<Tipoprevision> findRange(int[] range);

    int count();
    
}
