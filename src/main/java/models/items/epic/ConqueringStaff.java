package models.items.epic;

import models.items.Item;
import models.Game;
import models.player.Player;

public class ConqueringStaff extends Item {

    @Override
    public double getPoints(Game game, Player player) {
        return player.stats().kdaFarmWards().wardStats().wardsKilled() >= 15 ? 24 : 0;
    }

    @Override
    public String getItemDescription() {
        return "24 points if the player destroys 15 wards or more.";
    }

    @Override
    public String getItemName() {
        return "Conquering Staff";
    }

    @Override
    public int getItemCost() {
        return 2;
    }

}
