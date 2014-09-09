/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author chaitany
 */
@ManagedBean
@SessionScoped
public class LogutManaged {
    
    public void logout() throws Exception
    {
    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
    ec.invalidateSession();
    ec.redirect(ec.getRequestContextPath() + "/faces/index.xhtml");
    }

    /**
     * Creates a new instance of LogutManaged
     */
    public LogutManaged() {
    }
    
}
