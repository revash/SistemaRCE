/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.sistemarce.session;

import cl.sistemarce.entity.Consultanutricional;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresEduardo
 */
@Local
public interface ConsultanutricionalFacadeLocal {

    void create(Consultanutricional consultanutricional);

    void edit(Consultanutricional consultanutricional);

    void remove(Consultanutricional consultanutricional);

    Consultanutricional find(Object id);

    List<Consultanutricional> findAll();

    List<Consultanutricional> findRange(int[] range);

    int count();
    
}
