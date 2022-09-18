package items.common;

import models.Game;
import models.player.Player;

public class EarthlyStaff {

    public static final String itemDescription = "15 points if the player destroys the first tower of the game.";

    public static double getPoints(Game game, Player player) {
        return player.stats().specificStats().assistsKills().firstTowerKill() ? 15 : 0;
    }

}
