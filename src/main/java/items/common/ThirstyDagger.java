package items.common;

import models.Game;
import models.player.Player;

public class ThirstyDagger {

    public static final String itemDescription = "15 points if the player makes the first blood of the game.";

    public static double getPoints(Game game, Player player) {
        return player.stats().specificStats().assistsKills().firstBloodKill() ? 15 : 0;
    }

}
