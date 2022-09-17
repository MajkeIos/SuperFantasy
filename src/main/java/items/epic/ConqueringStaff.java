package items.epic;

import models.Game;
import models.player.Player;

public class ConqueringStaff {

    public static final String itemDescription = "24 points if the player destroys 15 wards or more.";

    public static double getPoints(Game game, Player player) {
        return player.stats().kdaFarmWards().wardStats().wardsKilled() >= 15 ? 24 : 0;
    }
}
