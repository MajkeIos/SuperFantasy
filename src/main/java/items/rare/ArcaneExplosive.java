package items.rare;

import models.Game;
import models.player.Player;

public class ArcaneExplosive {

    public static final String itemDescription = "12 points if the player deals 4500 damage to enemy towers or more.";

    public static double getPoints(Game game, Player player) {
        return player.stats().damage().neutralDamage().damageDealtToTurrets() >= 4500 ? 12 : 0;
    }
}
