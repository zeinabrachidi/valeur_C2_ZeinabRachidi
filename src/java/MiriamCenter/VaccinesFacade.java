/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MiriamCenter;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author zeina
 */
@Stateless
public class VaccinesFacade extends AbstractFacade<Vaccines> {

    @PersistenceContext(unitName = "DOSSIER_MEDICALPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VaccinesFacade() {
        super(Vaccines.class);
    }
    
}
