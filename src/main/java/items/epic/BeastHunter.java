package items.epic;

import models.Game;
import models.player.Player;

public class BeastHunter {

    public static final String itemDescription = "18 points if the player kills " +
            "the highest number of neutral minions of the game.";

    public static double getPoints(Game game, Player player) {
        double maxNeutralMinions = 0;
        for (Player tmpPlayer : game.getAllPlayers()) {
            maxNeutralMinions = Math.max(maxNeutralMinions,
                    tmpPlayer.stats().kdaFarmWards().farmStats().neutralMinionsKilled());
        }
        return player.stats().kdaFarmWards().farmStats().neutralMinionsKilled() == maxNeutralMinions ? 18 : 0;
    }
}
