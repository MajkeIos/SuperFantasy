package items.rare;

import models.Game;
import models.player.Player;

public class TwinSwords {

    public static final String itemDescription = "10 points for each doublekill the player makes.";

    public static double getPoints(Game game, Player player) {
        return player.stats().specificStats().multiKills().doubleKills() * 10;
    }

}
