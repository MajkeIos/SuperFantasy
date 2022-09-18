package items.common;

import models.Game;
import models.player.Player;

public class HawksEye {

    public static final String itemDescription = "8 points if the player gets a vision score of 50 or more.";

    public static double getPoints(Game game, Player player) {
        return player.stats().kdaFarmWards().wardStats().visionScore() >= 50 ? 8 : 0;
    }

}
