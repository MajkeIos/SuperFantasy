package models.items.legendary;

import models.items.Item;
import models.Game;
import models.player.Player;

public class Scythe extends Item {

    @Override
    public double getPoints(Game game, Player player) {
        return player.stats().kdaFarmWards().farmStats().totalMinionsKilled() / 18.0;
    }

    @Override
    public String getItemDescription() {
        return "1 point for every 18 minions killed by the player.";
    }

    @Override
    public String getItemName() {
        return "Scythe";
    }

    @Override
    public int getItemCost() {
        return 3;
    }

}
