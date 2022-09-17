package items.epic;

import models.Game;
import models.player.Player;

public class SecretScroll {

    public static final String itemDescription = "18 points if the player gets 450 or more gold per minute.";

    public static double getPoints(Game game, Player player) {
        return player.stats().specificStats().challenges().goldPerMinute() >= 450 ? 18 : 0;
    }
}
