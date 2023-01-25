package models.items.legendary;

import models.items.Item;
import models.Game;
import models.player.Player;

public class WildClaw extends Item {

    @Override
    public double getPoints(Game game, Player player) {
        return player.stats().kdaFarmWards().farmStats().neutralMinionsKilled() / 8.0;
    }

    @Override
    public String getItemDescription() {
        return "1 point for every 8 neutral minions killed by the player.";
    }

    @Override
    public String getItemName() {
        return "Wild Claw";
    }

    @Override
    public int getItemCost() {
        return 3;
    }

}
