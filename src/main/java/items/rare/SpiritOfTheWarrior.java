package items.rare;

import models.Game;
import models.player.Player;

public class SpiritOfTheWarrior {

    public static final String itemDescription = "16 points if the player deals the most physical damage in the game.";

    public static double getPoints(Game game, Player player) {
        double maxPhysicalDamage = 0;
        for (Player tmpPlayer : game.getAllPlayers()) {
            maxPhysicalDamage = Math.max(maxPhysicalDamage,
                    tmpPlayer.stats().damage().championDamage().physicalDamageDealtToChampions());
        }
        return player.stats().damage().championDamage().physicalDamageDealtToChampions() == maxPhysicalDamage ? 16 : 0;
    }
}
