/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.sistemarce.session;

import cl.sistemarce.entity.Tipopartos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresEduardo
 */
@Local
public interface TipopartosFacadeLocal {

    void create(Tipopartos tipopartos);

    void edit(Tipopartos tipopartos);

    void remove(Tipopartos tipopartos);

    Tipopartos find(Object id);

    List<Tipopartos> findAll();

    List<Tipopartos> findRange(int[] range);

    int count();
    
}
