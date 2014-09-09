/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedbeans;

import entities.Player;
import entityfacades.PlayerFacade;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author chaitany
 */
@ManagedBean
@RequestScoped
public class PlayerAddManaged {
    @EJB
    private PlayerFacade playerFacade;
    
    Player p = new Player();

    public Player getP() {
        return p;
    }

    public void setP(Player p) {
        this.p = p;
    }
    
    public void addPlayer() {  
        //Persist user  
       
        FacesContext fc = FacesContext.getCurrentInstance();
       // User u = new User(username,password,email,"user",college_name,age,course,course_year,contact_number,city,street,postal_code);
        if(playerFacade.create(p))
        {
            fc.addMessage(null, new FacesMessage("Successful", "Added " + p.getPlayer_name()+" !"));
            
        }   
        else
        {
       
        fc.addMessage("regform:username", new FacesMessage("Unknown server error!!"));
        }
        
        
        
    }  
        
    /**
     * Creates a new instance of PlayerAddManaged
     */
    public PlayerAddManaged() {
    }
    
}
