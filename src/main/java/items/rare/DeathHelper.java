package items.rare;

import models.Game;
import models.player.Player;

public class DeathHelper {

    public static final String itemDescription = "10 points if the player makes 8 assists or more.";

    public static double getPoints(Game game, Player player) {
        return player.stats().kdaFarmWards().kda().assists() >= 8 ? 10 : 0;
    }
}
