package entities;

import entities.Player;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import utilities.TeamSizeType;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-03-26T09:25:30")
@StaticMetamodel(Team.class)
public class Team_ { 

    public static volatile SingularAttribute<Team, Long> id;
    public static volatile SingularAttribute<Team, String> team_name;
    public static volatile ListAttribute<Team, Player> players;
    public static volatile SingularAttribute<Team, TeamSizeType> team_size;

}