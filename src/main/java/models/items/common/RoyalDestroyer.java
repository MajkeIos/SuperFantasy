package models.items.common;

import models.items.Item;
import models.Game;
import models.player.Player;

public class RoyalDestroyer extends Item {

    @Override
    public double getPoints(Game game, Player player) {
        double maxInhibKills = 0;
        for (Player tmpPlayer : game.getAllPlayers()) {
            maxInhibKills = Math.max(maxInhibKills,
                    tmpPlayer.stats().specificStats().assistsKills().inhibitorKills());
        }
        return player.stats().specificStats().assistsKills().inhibitorKills() == maxInhibKills ? 11 : 0;
    }

    @Override
    public String getItemDescription() {
        return "11 points if the player destroys the highest number of inhibitors of the game.";
    }

    @Override
    public String getItemName() {
        return "Royal Destroyer";
    }

    @Override
    public int getItemCost() {
        return 0;
    }

}
