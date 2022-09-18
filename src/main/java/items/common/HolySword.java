package items.common;

import models.Game;
import models.player.Player;

public class HolySword {

    public static final String itemDescription = "10 points if the player makes the highest kills count of the game.";

    public static double getPoints(Game game, Player player) {
        double maxKills = 0;
        for (Player tmpPlayer : game.getAllPlayers()) {
            maxKills = Math.max(maxKills,
                    tmpPlayer.stats().kdaFarmWards().kda().kills());
        }
        return player.stats().kdaFarmWards().kda().kills() == maxKills ? 10 : 0;
    }

}
