package items.common;

import models.Game;
import models.player.Player;

public class DualSpear {

    public static final String itemDescription = "8 points if the player makes the highest number of doublekills of the game.";

    public static double getPoints(Game game, Player player) {
        double maxDoublekills = 0;
        for (Player tmpPlayer : game.getAllPlayers()) {
            maxDoublekills = Math.max(maxDoublekills,
                    tmpPlayer.stats().specificStats().multiKills().doubleKills());
        }
        return player.stats().specificStats().multiKills().doubleKills() == maxDoublekills ? 8 : 0;
    }

}
