package items.epic;

import models.Game;
import models.player.Player;

public class ObsidianBattlePlate {

    public static final String itemDescription = "20 points if the player does " +
            "not die more than 2 times during the game.";

    public static double getPoints(Game game, Player player) {
        return player.stats().kdaFarmWards().kda().deaths() <= 2 ? 20 : 0;
    }
}
