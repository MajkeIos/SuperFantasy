package items.epic;

import models.Game;
import models.player.Player;

public class SteelAura {

    public static final String itemDescription = "18 points if the player has the most damage taken.";

    public static double getPoints(Game game, Player player) {
        double maxDamageTaken = 0;
        for (Player tmpPlayer : game.getAllPlayers()) {
            maxDamageTaken = Math.max(maxDamageTaken,
                    tmpPlayer.stats().damage().championDamage().totalDamageTaken());
        }
        return player.stats().damage().championDamage().totalDamageTaken() == maxDamageTaken ? 18 : 0;
    }
}
