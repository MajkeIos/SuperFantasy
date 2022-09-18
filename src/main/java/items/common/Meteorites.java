package items.common;

import models.Game;
import models.player.Player;

public class Meteorites {

    public static final String itemDescription = "70 points if the player makes a quadrakill.";

    public static double getPoints(Game game, Player player) {
        return player.stats().specificStats().multiKills().quadraKills() > 0 ? 70 : 0;
    }

}
