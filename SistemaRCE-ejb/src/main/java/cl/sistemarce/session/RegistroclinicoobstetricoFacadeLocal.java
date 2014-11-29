/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.sistemarce.session;

import cl.sistemarce.entity.Registroclinicoobstetrico;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresEduardo
 */
@Local
public interface RegistroclinicoobstetricoFacadeLocal {

    void create(Registroclinicoobstetrico registroclinicoobstetrico);

    void edit(Registroclinicoobstetrico registroclinicoobstetrico);

    void remove(Registroclinicoobstetrico registroclinicoobstetrico);

    Registroclinicoobstetrico find(Object id);

    List<Registroclinicoobstetrico> findAll();

    List<Registroclinicoobstetrico> findRange(int[] range);

    int count();
    
}
