/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entityfacades;

import entities.User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
//import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author chaitany
 */
@Stateless
public class UserFacade extends AbstractFacade<User> {
    @PersistenceContext(unitName = "JavaEETestProject-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(User.class);
    }
    
//public boolean storeThis(String username, String password, String email)
//{
//    User u = new User(username,password,email);
//    try{
//     em.persist(u);
//   }
//   catch(Exception e){e.printStackTrace(); return false;} 
//    
//    return true;
//
//}
//    
    public boolean check(String username,String password)
    {
    
        Query q = em.createNamedQuery("User.validate");
        q.setParameter("username", username);
        q.setParameter("password", password);
        try
        {
            User u = (User)q.getSingleResult();
        }
        catch(NoResultException nre)
        {
            nre.printStackTrace();
            return false;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
            
        }
        
        return true;
    }
}
