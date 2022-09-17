package items.legendary;

import models.Game;
import models.player.Player;

public class Scythe {

    public static final String itemDescription = "1 point for every 18 minions killed by the player.";

    public static double getPoints(Game game, Player player) {
        return player.stats().kdaFarmWards().farmStats().totalMinionsKilled() / 18.0;
    }

}
