package items.legendary;

import models.Game;
import models.player.Player;

public class ThirstyScythes {

    public static final String itemDescription = "25 points if the player kills 320 or more minions.";

    public static double getPoints(Game game, Player player) {
        return player.stats().kdaFarmWards().farmStats().totalMinionsKilled() >= 320 ? 25 : 0;
    }

}
