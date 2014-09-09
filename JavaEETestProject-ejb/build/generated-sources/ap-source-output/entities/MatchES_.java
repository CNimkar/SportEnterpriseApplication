package entities;

import entities.Team;
import entities.Ticket;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import utilities.PrizeMoneyType;
import utilities.SportType;
import utilities.VenueType;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-03-26T09:25:30")
@StaticMetamodel(MatchES.class)
public class MatchES_ { 

    public static volatile SingularAttribute<MatchES, Long> id;
    public static volatile SingularAttribute<MatchES, Team> teamOne;
    public static volatile SingularAttribute<MatchES, Team> teamTwo;
    public static volatile SingularAttribute<MatchES, Team> winner;
    public static volatile SingularAttribute<MatchES, VenueType> venue;
    public static volatile SingularAttribute<MatchES, Date> date;
    public static volatile SingularAttribute<MatchES, PrizeMoneyType> prize_money;
    public static volatile SingularAttribute<MatchES, SportType> sport_type;
    public static volatile ListAttribute<MatchES, Ticket> tickets;

}