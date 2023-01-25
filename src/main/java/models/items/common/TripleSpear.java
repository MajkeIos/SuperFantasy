package models.items.common;

import models.items.Item;
import models.Game;
import models.player.Player;

public class TripleSpear extends Item {

    @Override
    public double getPoints(Game game, Player player) {
        return player.stats().specificStats().multiKills().tripleKills() * 20;
    }

    @Override
    public String getItemDescription() {
        return "20 points for each triplekill the player makes.";
    }

    @Override
    public String getItemName() {
        return "Triple Spear";
    }

    @Override
    public int getItemCost() {
        return 0;
    }

}
