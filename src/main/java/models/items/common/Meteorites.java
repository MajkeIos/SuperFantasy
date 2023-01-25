package models.items.common;

import models.items.Item;
import models.Game;
import models.player.Player;

public class Meteorites extends Item {

    @Override
    public double getPoints(Game game, Player player) {
        return player.stats().specificStats().multiKills().quadraKills() > 0 ? 70 : 0;
    }

    @Override
    public String getItemDescription() {
        return "70 points if the player makes a quadrakill.";
    }

    @Override
    public String getItemName() {
        return "Meteorites";
    }

    @Override
    public int getItemCost() {
        return 0;
    }

}
