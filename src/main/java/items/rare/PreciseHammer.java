package items.rare;

import models.Game;
import models.player.Player;

public class PreciseHammer {

    public static final String itemDescription = "18 points if the player gets most turret platings in the game.";

    public static double getPoints(Game game, Player player) {
        double maxTurretPlatings = 0;
        for (Player tmpPlayer : game.getAllPlayers()) {
            maxTurretPlatings = Math.max(maxTurretPlatings,
                    tmpPlayer.stats().specificStats().challenges().turretPlatesTaken());
        }
        return player.stats().specificStats().challenges().turretPlatesTaken() == maxTurretPlatings ? 18 : 0;
    }
}
