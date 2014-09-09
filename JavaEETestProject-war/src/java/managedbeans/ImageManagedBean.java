/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedbeans;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author chaitany
 */
@ManagedBean
@RequestScoped
public class ImageManagedBean {
      private List<String> images;  
  
   
      public List<String> getImages() {  
        return images;  
    }  

    /**
     * Creates a new instance of ImageManagedBean
     */
    public ImageManagedBean() {
            images = new ArrayList<String>();  
        images.add("unify1.jpg");  
        images.add("unify6.jpg");
        images.add("unify8.jpg");
        images.add("unify9.jpg");
        images.add("unify10.jpg");
        images.add("unify11.jpg");
        
    }
    
}
