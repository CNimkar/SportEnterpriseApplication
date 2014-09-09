/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedbeans;

import entities.User;
import entityfacades.UserFacade;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author chaitany
 */
@ManagedBean (name = "wizard")
@ViewScoped

public class WizardManaged {
    
     private static Logger logger = Logger.getLogger(WizardManaged.class.getName());
    
    
    
    @EJB
    private UserFacade userFacade;
     public User u = new User();
   
    //skip
        private boolean skip;

    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }
       

    public User getU() {
        return u;
    }

    public void setU(User u) {
        this.u = u;
    }
        
        

    public void save(ActionEvent actionEvent) throws IOException {  
        //Persist user  
       u.setParticular_role("user");
        FacesContext fc = FacesContext.getCurrentInstance();
       // User u = new User(username,password,email,"user",college_name,age,course,course_year,contact_number,city,street,postal_code);
        if(userFacade.create(u))
        {
            fc.addMessage(null, new FacesMessage("Successful", "Hello " + u.getUsername()+"     " +u.getUser_lastname() +" !"));
   //        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
     //      ec.redirect(ec.getRequestContextPath()+"/faces/index.xhtml");
   
        }   
        else
        {
       
        fc.addMessage("regform:username", new FacesMessage("Unknown server error!!"));
        }
        
        
        
    }  


    public String wizardProceed(FlowEvent event)
    {
        logger.info("Current wizard step:" + event.getOldStep());  
        logger.info("Next step:" + event.getNewStep());  
    
           
        if(skip) {  
            skip = false;   //reset in case user goes back  
            return "confirm";  
        }  
        else {  
            return event.getNewStep();  
        }  
    }
    /**
     * Creates a new instance of WizardManaged
     */
    public WizardManaged() {
        
    }
    
}
