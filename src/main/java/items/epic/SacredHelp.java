package items.epic;

import models.Game;
import models.player.Player;

public class SacredHelp {

    public static final String itemDescription = "20 points if the player makes a healing number of more than 8000.";

    public static double getPoints(Game game, Player player) {
        return player.stats().specificStats().fancyStats().totalHeal() >= 800 ? 20 : 0;
    }
}
