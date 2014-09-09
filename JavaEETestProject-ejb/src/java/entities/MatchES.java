/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import utilities.PrizeMoneyType;
import utilities.SportType;
import utilities.VenueType;

/**
 *
 * @author chaitany
 */


@Entity

public class MatchES implements Serializable {
    @OneToMany(mappedBy = "match")
    private List<Ticket> tickets;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   
    
    private Long id;
    
    @Enumerated(EnumType.STRING)
    private PrizeMoneyType prize_money;

   
    @Enumerated(EnumType.STRING)
    private VenueType venue;

    
    private SportType sport_type;

    public SportType getSport_type() {
        return sport_type;
    }

    public void setSport_type(SportType sport_type) {
        this.sport_type = sport_type;
    }

    
    
    //@ManyToOne
    //@JoinColumn(nullable=false)
    //private Sport sport;
    
    
    
    @OneToOne
    private Team teamOne;

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
    
    @OneToOne
    private Team teamTwo;
    
    @OneToOne
    private Team winner;

    
     public PrizeMoneyType getPrize_money() {
        return prize_money;
    }

    public void setPrize_money(PrizeMoneyType prize_money) {
        this.prize_money = prize_money;
    }
    
    public Team getWinner() {
        return winner;
    }

    public void setWinner(Team winner) {
        this.winner = winner;
    }

//    public Sport getSport() {
//        return sport;
//    }
//
//    public void setSport(Sport sport) {
//        this.sport = sport;
//    }

   

    public Team getTeamOne() {
        return teamOne;
    }

    public void setTeamOne(Team teamOne) {
        this.teamOne = teamOne;
    }

    public Team getTeamTwo() {
        return teamTwo;
    }

    public void setTeamTwo(Team teamTwo) {
        this.teamTwo = teamTwo;
    }
    
    public VenueType getVenue() {
        return venue;
    }

    public void setVenue(VenueType venue) {
        this.venue = venue;
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
        if (!(object instanceof MatchES)) {
            return false;
        }
        MatchES other = (MatchES) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Match[ id=" + id + " ]";
    }
    
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
