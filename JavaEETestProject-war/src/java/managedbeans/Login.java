/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedbeans;

import entityfacades.UserFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author chaitany
 */
@ManagedBean
@SessionScoped
public class Login {
    @EJB
    private UserFacade userFacade;
    
    private String username;
    private String password;

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
    
    public String validate()
    {
        if(userFacade.check(username, password))
            return "loginsuccess";
        
        return "loginfailure";
    }
    
    /**
     * Creates a new instance of Login
     */
    public Login() {
    }
    
}
