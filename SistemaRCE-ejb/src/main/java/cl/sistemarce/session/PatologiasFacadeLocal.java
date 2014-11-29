/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.sistemarce.session;

import cl.sistemarce.entity.Patologias;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresEduardo
 */
@Local
public interface PatologiasFacadeLocal {

    void create(Patologias patologias);

    void edit(Patologias patologias);

    void remove(Patologias patologias);

    Patologias find(Object id);

    List<Patologias> findAll();

    List<Patologias> findRange(int[] range);

    int count();
    
}
