package items.legendary;

import models.Game;
import models.player.Player;

public class GuardianTotem {

    public static final String itemDescription = "1 point for every 3 wards placed by the player.";

    public static double getPoints(Game game, Player player) {
        return player.stats().kdaFarmWards().wardStats().wardsPlaced() / 3.0;
    }

}
