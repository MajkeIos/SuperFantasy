package models.items.common;

import models.items.Item;
import models.Game;
import models.player.Player;

public class EarthlyStaff extends Item {

    @Override
    public double getPoints(Game game, Player player) {
        return player.stats().specificStats().assistsKills().firstTowerKill() ? 15 : 0;
    }

    @Override
    public String getItemDescription() {
        return "15 points if the player destroys the first tower of the game.";
    }

    @Override
    public String getItemName() {
        return "Earthly Staff";
    }

    @Override
    public int getItemCost() {
        return 0;
    }

}
