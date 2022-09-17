package items.legendary;

import models.Game;
import models.player.Player;

public class Incapacitor {

    public static final String itemDescription = "3 points for every 2 wards destroyed by the player";

    public static double getPoints(Game game, Player player) {
        return player.stats().kdaFarmWards().wardStats().wardsKilled() * 1.5;
    }

}
