package models.items.rare;

import models.items.Item;
import models.Game;
import models.player.Player;

public class VersatilSaber extends Item {

    @Override
    public double getPoints(Game game, Player player) {
        return player.stats().kdaFarmWards().kda().getKda() >= 6 ? 11 : 0;
    }

    @Override
    public String getItemDescription() {
        return "11 points if the player gets a KDA of 6 or greater.";
    }

    @Override
    public String getItemName() {
        return "Versatil Saber";
    }

    @Override
    public int getItemCost() {
        return 1;
    }

}
