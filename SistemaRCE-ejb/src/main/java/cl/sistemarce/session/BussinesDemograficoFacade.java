/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.sistemarce.session;


import cl.sistemarce.entity.Profesional;
import cl.sistemarce.entity.Tipoprevision;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author AndresEduardo
 */
@Stateless
public class BussinesDemograficoFacade implements BussinesDemograficoFacadeLocal {

    @PersistenceContext(unitName = "cl_SistemaRCE-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Profesional getProfesionalByRut(Integer rut, String dv) {
        Query query = em.createQuery("SELECT p FROM Profesional p WHERE p.profesionalPK.profesionalrut = :rut AND p.profesionalPK.profesionalDv = :dv");
        query.setParameter("rut", rut);
        query.setParameter("dv", dv);
        if (!query.getResultList().isEmpty()) {
            return (Profesional) query.getResultList().get(0);
        } else {
            return null;
        }
    }

    @Override
    public List<Tipoprevision> getListTipoPrevisiones(Integer id) {
        Query q = em.createQuery("SELECT tp FROM Tipoprevision tp WHERE tp.previsionCodigo.previsionCodigo = :prev");
        q.setParameter("prev", id);
        return q.getResultList();
    }
}
