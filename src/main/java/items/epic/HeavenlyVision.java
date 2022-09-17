package items.epic;

import models.Game;
import models.player.Player;

public class HeavenlyVision {

    public static final String itemDescription = "22 points if the player gets the highest vision score of the game.";

    public static double getPoints(Game game, Player player) {
        double maxVisionScore = 0;
        for (Player tmpPlayer : game.getAllPlayers()) {
            maxVisionScore = Math.max(maxVisionScore,
                    tmpPlayer.stats().kdaFarmWards().wardStats().visionScore());
        }
        return player.stats().kdaFarmWards().wardStats().visionScore() == maxVisionScore ? 22 : 0;
    }
}
