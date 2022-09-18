package items.rare;

import models.Game;
import models.player.Player;

public class VersatilSaber {

    public static final String itemDescription = "11 points if the player gets a KDA of 6 or greater.";

    public static double getPoints(Game game, Player player) {
        return player.stats().kdaFarmWards().kda().getKda() >= 6 ? 11 : 0;
    }

}
