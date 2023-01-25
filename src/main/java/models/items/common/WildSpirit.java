package models.items.common;

import models.items.Item;
import models.Game;
import models.player.Player;

public class WildSpirit extends Item {

    @Override
    public double getPoints(Game game, Player player) {
        return player.stats().kdaFarmWards().farmStats().neutralMinionsKilled() >= 140 ? 10 : 0;
    }

    @Override
    public String getItemDescription() {
        return "10 points if the player kills 140 or more neutral minions.";
    }

    @Override
    public String getItemName() {
        return "Wild Spirit";
    }

    @Override
    public int getItemCost() {
        return 0;
    }

}
