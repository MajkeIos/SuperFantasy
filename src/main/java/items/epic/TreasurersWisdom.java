package items.epic;

import models.Game;
import models.player.Player;

public class TreasurersWisdom {
    public static final String itemDescription = "17 points if the player gets 12800 gold or more.";

    public static double getPoints(Game game, Player player) {
        return player.stats().specificStats().fancyStats().goldEarned() >= 12800 ? 17 : 0;
    }
}
