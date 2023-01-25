package models.items.common;

import models.items.Item;
import models.Game;
import models.player.Player;

public class EvasiveProtection extends Item {

    @Override
    public double getPoints(Game game, Player player) {
        return player.stats().kdaFarmWards().kda().deaths() == 0 ? 15 : 0;
    }

    @Override
    public String getItemDescription() {
        return "15 points if the player does not die during the game.";
    }

    @Override
    public String getItemName() {
        return "Evasive Protection";
    }

    @Override
    public int getItemCost() {
        return 0;
    }

}
