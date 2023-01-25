package models.items.legendary;

import models.items.Item;
import models.Game;
import models.player.Player;

public class LegendAura extends Item {

    @Override
    public double getPoints(Game game, Player player) {
        return player.stats().specificStats().fancyStats().largestKillingSpree() >= 7 ? 40 : 0;
    }

    @Override
    public String getItemDescription() {
        return "40 points if the player makes a killing spree of 7 or more.";
    }

    @Override
    public String getItemName() {
        return "Legend Aura";
    }

    @Override
    public int getItemCost() {
        return 3;
    }

}
