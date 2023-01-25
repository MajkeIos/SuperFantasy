package models.items.epic;

import models.items.Item;
import models.Game;
import models.player.Player;

public class RampageMomentum extends Item {

    @Override
    public double getPoints(Game game, Player player) {
        return player.stats().specificStats().fancyStats().largestKillingSpree() >= 4 ? 15 : 0;
    }

    @Override
    public String getItemDescription() {
        return "15 points if the player makes a killing spree of 4 or more.";
    }

    @Override
    public String getItemName() {
        return "Rampage Momentum";
    }

    @Override
    public int getItemCost() {
        return 2;
    }

}
