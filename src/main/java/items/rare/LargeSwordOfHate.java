package items.rare;

import models.Game;
import models.player.Player;

public class LargeSwordOfHate {

    public static final String itemDescription = "20 points if the player deals the highest damage to enemy champions of the game.";

    public static double getPoints(Game game, Player player) {
        double maxChampionDamage = 0;
        for (Player tmpPlayer : game.getAllPlayers()) {
            maxChampionDamage = Math.max(maxChampionDamage,
                    tmpPlayer.stats().damage().championDamage().totalDamageDealtToChampions());
        }
        return player.stats().damage().championDamage().totalDamageDealtToChampions() == maxChampionDamage ? 20 : 0;
    }
}
