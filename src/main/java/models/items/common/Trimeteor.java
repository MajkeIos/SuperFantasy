package models.items.common;

import models.items.Item;
import models.Game;
import models.player.Player;

public class Trimeteor extends Item {

    @Override
    public double getPoints(Game game, Player player) {
        return player.stats().specificStats().multiKills().tripleKills() > 0 ? 30 : 0;
    }

    @Override
    public String getItemDescription() {
        return "30 points if the player makes a triplekill.";
    }

    @Override
    public String getItemName() {
        return "Trimeteor";
    }

    @Override
    public int getItemCost() {
        return 0;
    }

}
