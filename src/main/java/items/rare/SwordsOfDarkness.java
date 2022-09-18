package items.rare;

import models.Game;
import models.player.Player;

public class SwordsOfDarkness {

    public static final String itemDescription = "15 points if the player makes a doublekill.";

    public static double getPoints(Game game, Player player) {
        return player.stats().specificStats().multiKills().doubleKills() > 0 ? 15 : 0;
    }

}
