package models.items.epic;

import models.items.Item;
import models.Game;
import models.player.Player;

public class ThePuppeteer extends Item {

    @Override
    public double getPoints(Game game, Player player) {
        double maxCCTime = 0;
        for (Player tmpPlayer : game.getAllPlayers()) {
            maxCCTime = Math.max(maxCCTime,
                    tmpPlayer.stats().specificStats().fancyStats().timeCCingOthers());
        }
        return player.stats().specificStats().fancyStats().timeCCingOthers() == maxCCTime ? 20 : 0;
    }

    @Override
    public String getItemDescription() {
        return "20 points if the player is the one who has CC'ed (crowd controled) the enemies the longest.";
    }

    @Override
    public String getItemName() {
        return "The Puppeteer";
    }

    @Override
    public int getItemCost() {
        return 2;
    }

}
