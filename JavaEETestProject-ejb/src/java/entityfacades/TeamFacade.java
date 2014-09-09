/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entityfacades;

import entities.Player;
import entities.Team;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author chaitany
 */
@Stateless
public class TeamFacade extends AbstractFacade<Team> {
    @PersistenceContext(unitName = "JavaEETestProject-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TeamFacade() {
        super(Team.class);
    }
    public boolean createTeam(Team t,List<String> pids)
    {
        try
        {
          List<Player> s = new ArrayList<>();
         
            for(String id: pids)
            {
                 Player p = em.find(Player.class,Long.parseLong(id));
                s.add(p);
             }
            t.setPlayers(s);
            em.persist(t);
            for(Player p1: s)
            {
                p1.getTeams().add(t);
                em.persist(p1);
            }
            
            return true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
    
}
