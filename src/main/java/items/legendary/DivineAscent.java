package items.legendary;

import models.Game;
import models.player.Player;

public class DivineAscent {

    public static final String itemDescription = "25 points if the player reaches level 18.";

    public static double getPoints(Game game, Player player) {
        return player.stats().specificStats().fancyStats().champLevel() == 18 ? 25 : 0;
    }

}
