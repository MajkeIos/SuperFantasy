package items.rare;

import models.Game;
import models.player.Player;

public class TheUndertaker {

    public static final String itemDescription = "14 points if the player makes the highest killing streak of the game.";

    public static double getPoints(Game game, Player player) {
        double maxKillingStreak = 0;
        for (Player tmpPlayer : game.getAllPlayers()) {
            maxKillingStreak = Math.max(maxKillingStreak,
                    tmpPlayer.stats().specificStats().fancyStats().largestKillingSpree());
        }
        return player.stats().specificStats().fancyStats().largestKillingSpree() == maxKillingStreak ? 14 : 0;
    }

}
