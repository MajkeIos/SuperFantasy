package models.items.legendary;

import models.items.Item;
import models.Game;
import models.player.Player;

public class ThirstyScythes extends Item {

    @Override
    public double getPoints(Game game, Player player) {
        return player.stats().kdaFarmWards().farmStats().totalMinionsKilled() >= 320 ? 25 : 0;
    }

    @Override
    public String getItemDescription() {
        return "25 points if the player kills 320 or more minions.";
    }

    @Override
    public String getItemName() {
        return "Thirsty Scythes";
    }

    @Override
    public int getItemCost() {
        return 3;
    }

}
