package models.items.rare;

import models.items.Item;
import models.Game;
import models.player.Player;

public class TheUndertaker extends Item {

    @Override
    public double getPoints(Game game, Player player) {
        double maxKillingStreak = 0;
        for (Player tmpPlayer : game.getAllPlayers()) {
            maxKillingStreak = Math.max(maxKillingStreak,
                    tmpPlayer.stats().specificStats().fancyStats().largestKillingSpree());
        }
        return player.stats().specificStats().fancyStats().largestKillingSpree() == maxKillingStreak ? 14 : 0;
    }

    @Override
    public String getItemDescription() {
        return "14 points if the player makes the highest killing streak of the game.";
    }

    @Override
    public String getItemName() {
        return "The Undertaker";
    }

    @Override
    public int getItemCost() {
        return 1;
    }

}
