package items.common;

import models.Game;
import models.player.Player;

public class Trimeteor {

    public static final String itemDescription = "30 points if the player makes a triplekill.";

    public static double getPoints(Game game, Player player) {
        return player.stats().specificStats().multiKills().tripleKills() > 0 ? 30 : 0;
    }

}
