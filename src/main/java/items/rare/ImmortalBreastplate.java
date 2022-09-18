package items.rare;

import models.Game;
import models.player.Player;

public class ImmortalBreastplate {

    public static final String itemDescription = "14 points if the player has the lowest deaths number of the game.";

    public static double getPoints(Game game, Player player) {
        double minDeathNumber = 0;
        for (Player tmpPlayer : game.getAllPlayers()) {
            minDeathNumber = Math.min(minDeathNumber,
                    tmpPlayer.stats().kdaFarmWards().kda().deaths());
        }
        return player.stats().kdaFarmWards().kda().deaths() == minDeathNumber ? 14 : 0;
    }
}
