package items.rare;

import models.Game;
import models.player.Player;

public class BeingOfLight {

    public static final String itemDescription = "18 points if the player makes the highest healing number of the game.";

    public static double getPoints(Game game, Player player) {
        double maxHealingNumber = 0;
        for (Player tmpPlayer : game.getAllPlayers()) {
            maxHealingNumber = Math.max(maxHealingNumber,
                    tmpPlayer.stats().specificStats().fancyStats().totalHeal());
        }
        return player.stats().specificStats().fancyStats().totalHeal() == maxHealingNumber ? 18 : 0;
    }
}
