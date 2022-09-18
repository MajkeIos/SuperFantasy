package items.rare;

import models.Game;
import models.player.Player;

public class ElementalDischarge {

    public static final String itemDescription = "18 points if the player deals the highest damage to objectives of the game.";

    public static double getPoints(Game game, Player player) {
        double maxObjectiveDamage = 0;
        for (Player tmpPlayer : game.getAllPlayers()) {
            maxObjectiveDamage = Math.max(maxObjectiveDamage,
                    tmpPlayer.stats().damage().neutralDamage().damageDealtToObjectives());
        }
        return player.stats().damage().neutralDamage().damageDealtToObjectives() == maxObjectiveDamage ? 18 : 0;
    }
}
