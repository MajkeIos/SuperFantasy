package items.legendary;

import models.Game;
import models.player.Player;

public class TheStalker {

    public static final String itemDescription = "18 points if the player places 32 wards or more.";

    public static double getPoints(Game game, Player player) {
        return player.stats().kdaFarmWards().wardStats().wardsPlaced() >= 32 ? 18 : 0;
    }

}
