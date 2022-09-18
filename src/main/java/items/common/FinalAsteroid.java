package items.common;

import models.Game;
import models.player.Player;

public class FinalAsteroid {

    public static final String itemDescription = "100 points if the player makes a pentakill.";

    public static double getPoints(Game game, Player player) {
        return player.stats().specificStats().multiKills().pentaKills() > 0 ? 100 : 0;
    }

}
