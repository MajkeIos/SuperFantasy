package models.items.legendary;

import models.items.Item;
import models.Game;
import models.player.Player;

public class SpiritOfTheSquire extends Item {

    @Override
    public double getPoints(Game game, Player player) {
        return player.stats().kdaFarmWards().kda().assists() * 1.5;
    }

    @Override
    public String getItemDescription() {
        return "3 points for every 2 made by the player.";
    }

    @Override
    public String getItemName() {
        return "Spirit Of The Squire";
    }

    @Override
    public int getItemCost() {
        return 3;
    }

}
