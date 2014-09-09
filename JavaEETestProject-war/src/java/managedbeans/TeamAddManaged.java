/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedbeans;

import entities.Player;
import entities.Team;
import entityfacades.PlayerFacade;
import entityfacades.TeamFacade;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import utilities.TeamSizeType;

/**
 *
 * @author chaitany
 */
@ManagedBean
@RequestScoped
public class TeamAddManaged {
    @EJB
    private TeamFacade teamFacade;
    
    
    @EJB
    private PlayerFacade playerFacade;
    
    
    Team t = new Team();
    
    private List<String> selectedPlayers;

    public List<String> getSelectedPlayers() {
        return selectedPlayers;
    }

    public void setSelectedPlayers(List<String> selectedPlayers) {
        this.selectedPlayers = selectedPlayers;
    }

    List<Player> players;

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
    
    
    
    public SelectItem [] getTeam_sizes()
    {
       SelectItem [] items = new SelectItem[TeamSizeType.values().length];
       int i=0;
       for(TeamSizeType ts : TeamSizeType.values() )
       {
           items[i++] = new SelectItem(ts, ts.name());
           
       }
       return items;
        
    }
    
    public SelectItem [] getPlayer_lists()
    {
        players = playerFacade.findAllPlayers();
        SelectItem [] allplayers = new SelectItem[players.size()];
        int i=0;
        for(Player p: players)
        {
            allplayers[i++] = new SelectItem(p.getId(), p.getPlayer_name());
        }
        return allplayers;
    }
 
    public Team getT() {
        return t;
    }

    public void setT(Team t) {
        this.t = t;
    }
    

     public void addTeam() {  
        //Persist user  
         
        FacesContext fc = FacesContext.getCurrentInstance();
       // User u = new User(username,password,email,"user",college_name,age,course,course_year,contact_number,city,street,postal_code);
        if(teamFacade.createTeam(t, this.selectedPlayers))
        {
            fc.addMessage(null, new FacesMessage("Successful", "Added " +t.getTeam_name()+" !"));
            
        }   
        else
        {
       
        fc.addMessage("regform:username", new FacesMessage("Unknown server error!!"));
        }
        
        
        
    } 
    /**
     * Creates a new instance of TeamAddManaged
     */
    public TeamAddManaged() {
    }
    
}
