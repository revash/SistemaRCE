/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.sistemarce.session;

import cl.sistemarce.entity.Partos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresEduardo
 */
@Local
public interface PartosFacadeLocal {

    void create(Partos partos);

    void edit(Partos partos);

    void remove(Partos partos);

    Partos find(Object id);

    List<Partos> findAll();

    List<Partos> findRange(int[] range);

    int count();
    
}
