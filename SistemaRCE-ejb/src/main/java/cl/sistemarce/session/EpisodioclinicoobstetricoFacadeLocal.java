/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.sistemarce.session;

import cl.sistemarce.entity.Episodioclinicoobstetrico;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresEduardo
 */
@Local
public interface EpisodioclinicoobstetricoFacadeLocal {

    void create(Episodioclinicoobstetrico episodioclinicoobstetrico);

    void edit(Episodioclinicoobstetrico episodioclinicoobstetrico);

    void remove(Episodioclinicoobstetrico episodioclinicoobstetrico);

    Episodioclinicoobstetrico find(Object id);

    List<Episodioclinicoobstetrico> findAll();

    List<Episodioclinicoobstetrico> findRange(int[] range);

    int count();
    
}
