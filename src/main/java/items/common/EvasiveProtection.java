package items.common;

import models.Game;
import models.player.Player;

public class EvasiveProtection {

    public static final String itemDescription = "15 points if the player does not die during the game.";

    public static double getPoints(Game game, Player player) {
        return player.stats().kdaFarmWards().kda().deaths() == 0 ? 15 : 0;
    }

}
