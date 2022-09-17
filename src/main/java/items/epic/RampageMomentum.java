package items.epic;

import models.Game;
import models.player.Player;

public class RampageMomentum {

    public static final String itemDescription = "15 points if the player makes a killing spree of 4 or more.";

    public static double getPoints(Game game, Player player) {
        return player.stats().specificStats().fancyStats().largestKillingSpree() >= 4 ? 15 : 0;
    }
}
