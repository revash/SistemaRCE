/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.sistemarce.session;

import cl.sistemarce.entity.Niveleducacional;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresEduardo
 */
@Local
public interface NiveleducacionalFacadeLocal {

    void create(Niveleducacional niveleducacional);

    void edit(Niveleducacional niveleducacional);

    void remove(Niveleducacional niveleducacional);

    Niveleducacional find(Object id);

    List<Niveleducacional> findAll();

    List<Niveleducacional> findRange(int[] range);

    int count();
    
}
