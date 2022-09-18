package items.common;

import models.Game;
import models.player.Player;

public class WildSpirit {

    public static final String itemDescription = "10 points if the player kills 140 or more neutral minions.";

    public static double getPoints(Game game, Player player) {
        return player.stats().kdaFarmWards().farmStats().neutralMinionsKilled() >= 140 ? 10 : 0;
    }

}
