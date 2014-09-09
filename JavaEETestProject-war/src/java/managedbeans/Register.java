/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedbeans;

import entities.User;
import entityfacades.UserFacade;
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
public class Register {
    @EJB
    private UserFacade userFacade;
    

    private String username;
    private String password;
    private String confpassword;

    public String getConfpassword() {
        return confpassword;
    }

    public void setConfpassword(String confpassword) {
        this.confpassword = confpassword;
    }

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
  //  public String registerThisUser()
    //{
       // FacesContext fc = FacesContext.getCurrentInstance();
      //  User u = new User(username,password,email,"user");
        //if(userFacade.create(u))
      //  {
          //  fc.addMessage(null, new FacesMessage("Successful", "Hello " + username +" !"));
            //return null;
        //}   
       
        //fc.addMessage("f:username", new FacesMessage("Unknown server error!!"));
        
        
        //return null;
        
        
    //}
    
    public String registerThisUser()
    {
    return "login";
    }

    /**
     * Creates a new instance of Register
     */
    public Register() {
    }
    
}
