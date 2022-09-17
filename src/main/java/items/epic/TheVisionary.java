package items.epic;

import models.Game;
import models.player.Player;

public class TheVisionary {

    public static final String itemDescription = "18 points if the player " +
            "places the highest number of wards of the game.";

    public static double getPoints(Game game, Player player) {
        double maxWardsPlaced = 0;
        for (Player tmpPlayer : game.getAllPlayers()) {
            maxWardsPlaced = Math.max(maxWardsPlaced,
                    tmpPlayer.stats().kdaFarmWards().wardStats().wardsPlaced());
        }
        return player.stats().kdaFarmWards().wardStats().wardsPlaced() == maxWardsPlaced ? 18 : 0;
    }
}
