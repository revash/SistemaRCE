/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.sistemarce.session;

import cl.sistemarce.entity.Episodioclinico;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresEduardo
 */
@Local
public interface EpisodioclinicoFacadeLocal {

    void create(Episodioclinico episodioclinico);

    void edit(Episodioclinico episodioclinico);

    void remove(Episodioclinico episodioclinico);

    Episodioclinico find(Object id);

    List<Episodioclinico> findAll();

    List<Episodioclinico> findRange(int[] range);

    int count();
    
}
