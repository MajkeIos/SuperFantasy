package models.items.common;

import models.items.Item;
import models.Game;
import models.player.Player;

public class DualSpear extends Item {

    @Override
    public double getPoints(Game game, Player player) {
        double maxDoublekills = 0;
        for (Player tmpPlayer : game.getAllPlayers()) {
            maxDoublekills = Math.max(maxDoublekills,
                    tmpPlayer.stats().specificStats().multiKills().doubleKills());
        }
        return player.stats().specificStats().multiKills().doubleKills() == maxDoublekills ? 8 : 0;
    }

    @Override
    public String getItemDescription() {
        return "8 points if the player makes the highest number of doublekills of the game.";
    }

    @Override
    public String getItemName() {
        return "Dual Spear";
    }

    @Override
    public int getItemCost() {
        return 0;
    }


}
