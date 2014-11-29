/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.sistemarce.session;

import cl.sistemarce.entity.Episodioclinicoobstetrico;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author AndresEduardo
 */
@Stateless
public class EpisodioclinicoobstetricoFacade extends AbstractFacade<Episodioclinicoobstetrico> implements EpisodioclinicoobstetricoFacadeLocal {
    @PersistenceContext(unitName = "cl_SistemaRCE-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EpisodioclinicoobstetricoFacade() {
        super(Episodioclinicoobstetrico.class);
    }
    
}
