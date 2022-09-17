package items.legendary;

import models.Game;
import models.player.Player;

public class LegendAura {
    public static final String itemDescription = "40 points if the player makes a killing spree of 7 or more.";

    public static double getPoints(Game game, Player player) {
        return player.stats().specificStats().fancyStats().largestKillingSpree() >= 7 ? 40 : 0;
    }

}
