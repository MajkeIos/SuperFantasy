package items.common;

import models.Game;
import models.player.Player;

public class OmnipresentAmulet {

    public static final String itemDescription = "11 points if if the player makes the highest number of assists in the game.";

    public static double getPoints(Game game, Player player) {
        double maxAssists = 0;
        for (Player tmpPlayer : game.getAllPlayers()) {
            maxAssists = Math.max(maxAssists,
                    tmpPlayer.stats().kdaFarmWards().kda().assists());
        }
        return player.stats().kdaFarmWards().kda().assists() == maxAssists ? 11 : 0;
    }

}
