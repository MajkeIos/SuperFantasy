package items.rare;

import models.Game;
import models.player.Player;

public class RockTomb {

    public static final String itemDescription = "10 points if the player deals 15500 damage to objectives or more.";

    public static double getPoints(Game game, Player player) {
        return player.stats().damage().neutralDamage().damageDealtToObjectives() >= 15500 ? 10 : 0;
    }
}
