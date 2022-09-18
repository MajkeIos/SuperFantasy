package items.common;

import models.Game;
import models.player.Player;

public class DivineImpetu {

    public static final String itemDescription = "11 points if the player gets the best KDA of the game.";

    public static double getPoints(Game game, Player player) {
        double maxKDA = 0;
        for (Player tmpPlayer : game.getAllPlayers()) {
            maxKDA = Math.max(maxKDA,
                    tmpPlayer.stats().kdaFarmWards().kda().getKda());
        }
        return player.stats().kdaFarmWards().kda().getKda()== maxKDA ? 11 : 0;
    }

}
