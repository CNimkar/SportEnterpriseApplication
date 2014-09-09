/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author chaitany
 */
@Entity
@NamedQueries({
    @NamedQuery(name="Players.findAll",query="SELECT p FROM Player p")
})
public class Player implements Serializable {
    @ManyToMany(mappedBy = "players")
    private List<Team> teams;

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String player_name;
 
    
    private String player_age;
    private String player_college_name;
    private String player_course;
    
    private String player_city;

    public String getPlayer_city() {
        return player_city;
    }

    public void setPlayer_city(String player_city) {
        this.player_city = player_city;
    }


    public String getPlayer_course() {
        return player_course;
    }

    public void setPlayer_course(String player_course) {
        this.player_course = player_course;
    }


    public String getPlayer_college_name() {
        return player_college_name;
    }

    public void setPlayer_college_name(String player_college_name) {
        this.player_college_name = player_college_name;
    }


    public String getPlayer_age() {
        return player_age;
    }

    public void setPlayer_age(String player_age) {
        this.player_age = player_age;
    }


    


    public String getPlayer_name() {
        return player_name;
    }

    public void setPlayer_name(String player_name) {
        this.player_name = player_name;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Player)) {
            return false;
        }
        Player other = (Player) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Player[ id=" + id + " ]";
    }
    
}
