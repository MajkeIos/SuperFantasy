package models.items.legendary;

import models.items.Item;
import models.Game;
import models.player.Player;

public class GuardianTotem extends Item {

    @Override
    public double getPoints(Game game, Player player) {
        return player.stats().kdaFarmWards().wardStats().wardsPlaced() / 3.0;
    }

    @Override
    public String getItemDescription() {
        return "1 point for every 3 wards placed by the player.";
    }

    @Override
    public String getItemName() {
        return "Guardian Totem";
    }

    @Override
    public int getItemCost() {
        return 3;
    }

}
