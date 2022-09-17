package items.legendary;

import models.Game;
import models.player.Player;

public class SharpBlade {

    public static final String itemDescription = "3 points for each kill done by the player.";

    public static double getPoints(Game game, Player player) {
        return player.stats().kdaFarmWards().kda().kills() * 3;
    }
}
