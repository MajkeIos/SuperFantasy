package models.items.legendary;

import models.items.Item;
import models.Game;
import models.player.Player;

public class TheStalker extends Item {

    @Override
    public double getPoints(Game game, Player player) {
        return player.stats().kdaFarmWards().wardStats().wardsPlaced() >= 32 ? 18 : 0;
    }

    @Override
    public String getItemDescription() {
        return "18 points if the player places 32 wards or more.";
    }

    @Override
    public String getItemName() {
        return "The Stalker";
    }

    @Override
    public int getItemCost() {
        return 3;
    }

}
