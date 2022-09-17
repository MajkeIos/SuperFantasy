package items.epic;

import models.Game;
import models.player.Player;

public class ThePuppeteer {
    public static final String itemDescription = "20 points if the player is the one " +
            "who has CC'ed (crowd controled) the enemies the longest.";

    public static double getPoints(Game game, Player player) {
        double maxCCTime = 0;
        for (Player tmpPlayer : game.getAllPlayers()) {
            maxCCTime = Math.max(maxCCTime,
                    tmpPlayer.stats().specificStats().fancyStats().timeCCingOthers());
        }
        return player.stats().specificStats().fancyStats().timeCCingOthers() == maxCCTime ? 20 : 0;
    }
}
