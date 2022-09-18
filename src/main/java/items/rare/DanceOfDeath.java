package items.rare;

import models.Game;
import models.player.Player;

public class DanceOfDeath {

    public static final String itemDescription = "8 points if the player performs 4 kills or more.";

    public static double getPoints(Game game, Player player) {
        return player.stats().kdaFarmWards().kda().kills() >= 4 ? 8 : 0;
    }

}
