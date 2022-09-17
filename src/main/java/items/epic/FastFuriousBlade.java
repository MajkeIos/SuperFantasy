package items.epic;

import models.Game;
import models.player.Player;

public class FastFuriousBlade {

    public static final String itemDescription = "16 points if the player kills 9 or more minions per minute.";

    public static double getPoints(Game game, Player player) {
        return player.stats().kdaFarmWards().farmStats().totalMinionsKilled() /
                (game.getGameDuration() / 60.0) >= 9 ? 16 : 0;
    }
}
