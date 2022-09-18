package items.common;

import models.Game;
import models.player.Player;

public class ColossalMace {

    public static final String itemDescription = "11 points if the player makes the highest damage to enemy towers of the game.";

    public static double getPoints(Game game, Player player) {
        double maxTowersDamage = 0;
        for (Player tmpPlayer : game.getAllPlayers()) {
            maxTowersDamage = Math.max(maxTowersDamage,
                    tmpPlayer.stats().damage().neutralDamage().damageDealtToTurrets());
        }
        return player.stats().damage().neutralDamage().damageDealtToTurrets() == maxTowersDamage ? 11 : 0;
    }

}
