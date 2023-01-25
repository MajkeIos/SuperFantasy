package models.items.common;

import models.items.Item;
import models.Game;
import models.player.Player;

public class SiegeMace extends Item {

    @Override
    public double getPoints(Game game, Player player) {
        return player.stats().specificStats().assistsKills().firstTowerAssist() ? 16 : 0;
    }

    @Override
    public String getItemDescription() {
        return "16 points if the player assists the first destroyed tower of the game.";
    }

    @Override
    public String getItemName() {
        return "Siege Mace";
    }

    @Override
    public int getItemCost() {
        return 0;
    }

}
