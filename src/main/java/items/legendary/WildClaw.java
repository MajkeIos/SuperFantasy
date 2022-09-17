package items.legendary;

import models.Game;
import models.player.Player;

public class WildClaw {

    public static final String itemDescription = "1 point for every 8 neutral minions killed by the player.";

    public static double getPoints(Game game, Player player) {
        return player.stats().kdaFarmWards().farmStats().neutralMinionsKilled() / 8.0;
    }
}
