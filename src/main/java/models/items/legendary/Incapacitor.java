package models.items.legendary;

import models.items.Item;
import models.Game;
import models.player.Player;

public class Incapacitor extends Item {

    @Override
    public double getPoints(Game game, Player player) {
        return player.stats().kdaFarmWards().wardStats().wardsKilled() * 1.5;
    }

    @Override
    public String getItemDescription() {
        return "3 points for every 2 wards destroyed by the player.";
    }

    @Override
    public String getItemName() {
        return "Incapacitor";
    }

    @Override
    public int getItemCost() {
        return 3;
    }

}
