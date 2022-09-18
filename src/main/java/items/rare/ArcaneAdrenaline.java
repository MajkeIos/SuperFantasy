package items.rare;

import models.Game;
import models.player.Player;

public class ArcaneAdrenaline {

    public static final String itemDescription = "16 points if the player deals the highest magic damage in the game.";

    public static double getPoints(Game game, Player player) {
        double maxMagicDamage = 0;
        for (Player tmpPlayer : game.getAllPlayers()) {
            maxMagicDamage = Math.max(maxMagicDamage,
                    tmpPlayer.stats().damage().championDamage().magicDamageDealtToChampions());
        }
        return player.stats().damage().championDamage().magicDamageDealtToChampions() == maxMagicDamage ? 16 : 0;
    }

}
