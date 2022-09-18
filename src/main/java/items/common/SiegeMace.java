package items.common;

import models.Game;
import models.player.Player;

public class SiegeMace {

    public static final String itemDescription = "16 points if the player assists the first destroyed tower of the game.";

    public static double getPoints(Game game, Player player) {
        return player.stats().specificStats().assistsKills().firstTowerAssist() ? 16 : 0;
    }

}
