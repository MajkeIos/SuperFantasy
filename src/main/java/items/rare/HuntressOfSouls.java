package items.rare;

import models.Game;
import models.player.Player;

public class HuntressOfSouls {

    public static final String itemDescription = "19 points if the player kills the highest number of minions of the game.";

    public static double getPoints(Game game, Player player) {
        double maxMinionKilled = 0;
        for (Player tmpPlayer : game.getAllPlayers()) {
            maxMinionKilled = Math.max(maxMinionKilled,
                    tmpPlayer.stats().kdaFarmWards().farmStats().totalMinionsKilled());
        }
        return player.stats().kdaFarmWards().farmStats().totalMinionsKilled() == maxMinionKilled ? 19 : 0;
    }
}
