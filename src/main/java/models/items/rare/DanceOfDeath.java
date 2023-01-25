package models.items.rare;

import models.items.Item;
import models.Game;
import models.player.Player;

public class DanceOfDeath extends Item {

    @Override
    public double getPoints(Game game, Player player) {
        return player.stats().kdaFarmWards().kda().kills() >= 4 ? 8 : 0;
    }

    @Override
    public String getItemDescription() {
        return "8 points if the player performs 4 kills or more.";
    }

    @Override
    public String getItemName() {
        return "Dance Of Death";
    }

    @Override
    public int getItemCost() {
        return 1;
    }

}
