package items.epic;

import models.Game;
import models.player.Player;

public class BersekerAx {
    public static final String itemDescription = "14 points if the player deals more than 14500 damage to enemy champions.";

    public static double getPoints(Game game, Player player) {
        return player.stats().damage().championDamage().totalDamageDealtToChampions() >= 14500 ? 14 : 0;
    }
}
