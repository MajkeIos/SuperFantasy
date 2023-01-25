package models.items.rare;

import models.items.Item;
import models.Game;
import models.player.Player;

public class UnstoppableLightning extends Item {

    @Override
    public double getPoints(Game game, Player player) {
        return player.stats().specificStats().fancyStats().largestKillingSpree() >= 5 ? 18 : 0;
    }

    @Override
    public String getItemDescription() {
        return "18 points if the player makes a killing streak of 5 or more.";
    }

    @Override
    public String getItemName() {
        return "Unstoppable Lightning";
    }

    @Override
    public int getItemCost() {
        return 1;
    }

}
