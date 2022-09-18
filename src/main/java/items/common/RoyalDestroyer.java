package items.common;

import models.Game;
import models.player.Player;

public class RoyalDestroyer {

    public static final String itemDescription = "11 points if the player destroys the highest number of inhibitors of the game.";

    public static double getPoints(Game game, Player player) {
        double maxInhibKills = 0;
        for (Player tmpPlayer : game.getAllPlayers()) {
            maxInhibKills = Math.max(maxInhibKills,
                    tmpPlayer.stats().specificStats().assistsKills().inhibitorKills());
        }
        return player.stats().specificStats().assistsKills().inhibitorKills() == maxInhibKills ? 11 : 0;
    }

}
