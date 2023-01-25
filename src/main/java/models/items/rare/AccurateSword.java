package models.items.rare;

import models.items.Item;
import models.Game;
import models.player.Player;

public class AccurateSword extends Item {

    @Override
    public double getPoints(Game game, Player player) {
        double maxCriticalStrike = 0;
        for (Player tmpPlayer : game.getAllPlayers()) {
            maxCriticalStrike = Math.max(maxCriticalStrike,
                    tmpPlayer.stats().specificStats().fancyStats().largestCriticalStrike());
        }
        return player.stats().specificStats().fancyStats().largestCriticalStrike() == maxCriticalStrike ? 16 : 0;
    }

    @Override
    public String getItemDescription() {
        return "16 points if the player makes the biggest critical hit of the game.";
    }

    @Override
    public String getItemName() {
        return "Accurate Sword";
    }

    @Override
    public int getItemCost() {
        return 1;
    }

}
