package items.rare;

import models.Game;
import models.player.Player;

public class AccurateSword {

    public static final String itemDescription = "16 points if the player makes the biggest critical hit of the game.";

    public static double getPoints(Game game, Player player) {
        double maxCriticalStrike = 0;
        for (Player tmpPlayer : game.getAllPlayers()) {
            maxCriticalStrike = Math.max(maxCriticalStrike,
                    tmpPlayer.stats().specificStats().fancyStats().largestCriticalStrike());
        }
        return player.stats().specificStats().fancyStats().largestCriticalStrike() == maxCriticalStrike ? 16 : 0;
    }

}
