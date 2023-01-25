package models.items.legendary;

import models.items.Item;
import models.Game;
import models.player.Player;

public class SharpBlade extends Item {

    @Override
    public double getPoints(Game game, Player player) {
        return player.stats().kdaFarmWards().kda().kills() * 3;
    }

    @Override
    public String getItemDescription() {
        return "3 points for each kill done by the player.";
    }

    @Override
    public String getItemName() {
        return "Sharp Blade";
    }

    @Override
    public int getItemCost() {
        return 3;
    }

}
