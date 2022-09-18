package items.rare;

import models.Game;
import models.player.Player;

public class DemonClaws {

    public static final String itemDescription = "17 points if the player makes the highest number " +
            "of minions killed per minute of the game.";

    public static double getPoints(Game game, Player player) {
        double maxMinionKilled = 0;
        for (Player tmpPlayer : game.getAllPlayers()) {
            maxMinionKilled = Math.max(maxMinionKilled,
                    tmpPlayer.stats().kdaFarmWards().farmStats().totalMinionsKilled());
        }
        return player.stats().kdaFarmWards().farmStats().totalMinionsKilled() == maxMinionKilled ? 17 : 0;
    }

}
