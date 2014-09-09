/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entityfacades;

import entities.MatchES;
import entities.Team;
import java.sql.Timestamp;
import java.util.Date;
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
public class MatchESFacade extends AbstractFacade<MatchES> {
    @PersistenceContext(unitName = "JavaEETestProject-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MatchESFacade() {
        super(MatchES.class);
    }
    public boolean createMatch(MatchES m, String t1, String t2)
    {
        try
        {
            Team team1 = em.find(Team.class,Long.parseLong(t1));
            Team team2 = em.find(Team.class, Long.parseLong(t2));
            m.setTeamOne(team1);
            m.setTeamTwo(team2);
            //m.setDate(new Timestamp(new Date().getTime() + 2345334l));
            m.setDate(new Timestamp(new Date().getTime()));
            em.persist(m);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }
    //public List<MatchES> getUpcomingMatches()
    public List<MatchES> getAllMatches()
    {
       //Query q = em.createQuery("SELECT m FROM MatchES m WHERE m.date >= :datetime");
        Query q = em.createQuery("SELECT m FROM MatchES m");
       //q.setParameter("datetime", new Timestamp(new Date().getTime()));
       return q.getResultList();
    }
    
}
