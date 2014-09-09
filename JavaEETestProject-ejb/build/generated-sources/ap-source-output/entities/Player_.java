package entities;

import entities.Team;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-03-26T09:25:30")
@StaticMetamodel(Player.class)
public class Player_ { 

    public static volatile SingularAttribute<Player, Long> id;
    public static volatile SingularAttribute<Player, String> player_name;
    public static volatile SingularAttribute<Player, String> player_course;
    public static volatile ListAttribute<Player, Team> teams;
    public static volatile SingularAttribute<Player, String> player_age;
    public static volatile SingularAttribute<Player, String> player_college_name;
    public static volatile SingularAttribute<Player, String> player_city;

}