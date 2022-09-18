package items.common;

import models.Game;
import models.player.Player;

public class MagneticDisintegrator {

    public static final String itemDescription = "11 points if the player destroys an inhibitor.";

    public static double getPoints(Game game, Player player) {
        return player.stats().specificStats().assistsKills().inhibitorKills() >= 0 ? 11 : 0;
    }

}
