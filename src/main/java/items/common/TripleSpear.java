package items.common;

import models.Game;
import models.player.Player;

public class TripleSpear {

    public static final String itemDescription = "20 points for each triplekill the player makes.";

    public static double getPoints(Game game, Player player) {
        return player.stats().specificStats().multiKills().tripleKills() * 20;
    }

}
