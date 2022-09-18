package items.common;

import models.Game;
import models.player.Player;

public class CrownOfTheDwarfKing {

    public static final String itemDescription = "13 points if the player makes the highest gold number in the game.";

    public static double getPoints(Game game, Player player) {
        double maxGoldEarned = 0;
        for (Player tmpPlayer : game.getAllPlayers()) {
            maxGoldEarned = Math.max(maxGoldEarned,
                    tmpPlayer.stats().specificStats().fancyStats().goldEarned());
        }
        return player.stats().specificStats().fancyStats().goldEarned() == maxGoldEarned ? 13 : 0;
    }

}
