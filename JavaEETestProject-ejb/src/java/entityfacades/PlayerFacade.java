/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entityfacades;

import entities.Player;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author chaitany
 */
@Stateless
public class PlayerFacade extends AbstractFacade<Player> {
    @PersistenceContext(unitName = "JavaEETestProject-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PlayerFacade() {
        super(Player.class);
    }
    
    public List<Player> findAllPlayers()
    {
        Query q  = em.createNamedQuery("Players.findAll");
        return q.getResultList();
    }
    
}
