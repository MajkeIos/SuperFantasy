package items.common;

import models.Game;
import models.player.Player;

public class StaffOfConqueredWorlds {

    public static final String itemDescription = "11 points if the player destroys the largest number of wards in the game.";

    public static double getPoints(Game game, Player player) {
        double maxWardsDestroyed = 0;
        for (Player tmpPlayer : game.getAllPlayers()) {
            maxWardsDestroyed = Math.max(maxWardsDestroyed,
                    tmpPlayer.stats().kdaFarmWards().wardStats().wardsKilled());
        }
        return player.stats().kdaFarmWards().wardStats().wardsKilled() == maxWardsDestroyed ? 11 : 0;
    }

}
