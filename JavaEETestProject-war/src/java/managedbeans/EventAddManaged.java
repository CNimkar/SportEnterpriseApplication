/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedbeans;

import entities.MatchES;
import entities.Team;
import entityfacades.MatchESFacade;
import entityfacades.TeamFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import utilities.PrizeMoneyType;
import utilities.SportType;
import utilities.VenueType;

/**
 *
 * @author chaitany
 */
@ManagedBean
@RequestScoped
public class EventAddManaged {
    @EJB
    private TeamFacade teamFacade;
    
    @EJB
    private MatchESFacade matchESFacade;
    
    private List<Team> teams;
    
        private String team_one;
    private String team_two;

    public String getTeam_two() {
        return team_two;
    }

    public void setTeam_two(String team_two) {
        this.team_two = team_two;
    }


    public String getTeam_one() {
        return team_one;
    }

    public void setTeam_one(String team_one) {
        this.team_one = team_one;
    }


    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    
    
     public SelectItem [] getPrizeMoneyTypes()
    {
       SelectItem [] prizes = new SelectItem[PrizeMoneyType.values().length];
       int i=0;
       for(PrizeMoneyType pm : PrizeMoneyType.values() )
       {
           prizes[i++] = new SelectItem(pm, pm.name());
           
       }
       return prizes;
        
    }
     
      public SelectItem [] getSportTypes()
    {
       SelectItem [] sportnames = new SelectItem[SportType.values().length];
       int i=0;
       for(SportType sp : SportType.values() )
       {
           sportnames[i++] = new SelectItem(sp, sp.name());
           
       }
       return sportnames;
        
    }
     
     
     public SelectItem [] getVenueTypes()
    {
       SelectItem [] venues = new SelectItem[VenueType.values().length];
       int i=0;
       for(VenueType vn : VenueType.values() )
       {
          venues[i++] = new SelectItem(vn, vn.name());
           
       }
       return venues;
        
    }
     
     
     public SelectItem [] getAllTeams()
    {
        teams = teamFacade.findAll();
        SelectItem [] allteams = new SelectItem[teams.size()];
        int i=0;
        for(Team t: teams)
        {
            allteams[i++] = new SelectItem(t.getId(), t.getTeam_name());
        }
        return allteams;
    }
 
    
    MatchES m = new MatchES();

    public MatchES getM() {
        return m;
    }

    public void setM(MatchES m) {
        this.m = m;
    }
//    public List<MatchES> getUpcomingMatches()
//    {
//       return matchESFacade.getUpcomingMatches();
//    }
    
    public List<MatchES> getAllMatches()
    {
       return matchESFacade.getAllMatches();
    }
    
  public void addTeam() {  
        //Persist user  
         
        FacesContext fc = FacesContext.getCurrentInstance();
       // User u = new User(username,password,email,"user",college_name,age,course,course_year,contact_number,city,street,postal_code);
        if(matchESFacade.createMatch(m,team_one,team_two))
        {
            fc.addMessage(null, new FacesMessage("Successful", "Added " +m.getSport_type()+"match !"));
            
        }   
        else
        {
       
        fc.addMessage("regform:username", new FacesMessage("Unknown server error!!"));
        }
        
        
        
    }
    /**
     * Creates a new instance of EventAddManaged
     */
    public EventAddManaged() {
    }
    
}
