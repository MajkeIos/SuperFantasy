package items.epic;

import models.Game;
import models.player.Player;

public class BloodyInstinct {

    public static final String itemDescription = "15 points if the player assists in the first blood kill.";

    public static double getPoints(Game game, Player player) {
        return player.stats().specificStats().assistsKills().firstBloodAssist() ? 15 : 0;
    }
}
