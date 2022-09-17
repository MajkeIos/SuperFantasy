package items.epic;

import models.Game;
import models.player.Player;

public class OmnipresentSpirit {

    public static final String itemDescription = "18 points if the player has the highest kill participation.";

    public static double getPoints(Game game, Player player) {
        double maxKillParticipation = 0;
        for (Player tmpPlayer : game.getAllPlayers()) {
            maxKillParticipation = Math.max(maxKillParticipation,
                    tmpPlayer.stats().specificStats().challenges().killParticipation());
        }
        return player.stats().specificStats().challenges().killParticipation() == maxKillParticipation ? 18 : 0;
    }
}
