package items.rare;

import models.Game;
import models.player.Player;

public class SoulHunter {

    public static final String itemDescription = "15 points if the player gets most solokills in the game.";

    public static double getPoints(Game game, Player player) {
        double maxSolokills = 0;
        for (Player tmpPlayer : game.getAllPlayers()) {
            maxSolokills = Math.max(maxSolokills,
                    tmpPlayer.stats().specificStats().challenges().soloKills());
        }
        return player.stats().specificStats().challenges().soloKills() == maxSolokills ? 15 : 0;
    }
}
