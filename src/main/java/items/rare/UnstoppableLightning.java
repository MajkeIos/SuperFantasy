package items.rare;

import models.Game;
import models.player.Player;

public class UnstoppableLightning {

    public static final String itemDescription = "18 points if the player makes a killing streak of 5 or more.";

    public static double getPoints(Game game, Player player) {
        return player.stats().specificStats().fancyStats().largestKillingSpree() >= 5 ? 18 : 0;
    }

}
