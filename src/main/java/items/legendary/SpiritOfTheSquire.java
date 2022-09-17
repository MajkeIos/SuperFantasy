package items.legendary;

import models.Game;
import models.player.Player;

public class SpiritOfTheSquire {

    public static final String itemDescription = "3 points for every 2 made by the player.";

    public static double getPoints(Game game, Player player) {
        return player.stats().kdaFarmWards().kda().assists() * 1.5;
    }

}
