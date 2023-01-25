package models.items.epic;

import models.items.Item;
import models.Game;
import models.player.Player;

public class ObsidianBattlePlate extends Item {

    @Override
    public double getPoints(Game game, Player player) {
        return player.stats().kdaFarmWards().kda().deaths() <= 2 ? 20 : 0;
    }

    @Override
    public String getItemDescription() {
        return "20 points if the player does not die more than 2 times during the game.";
    }

    @Override
    public String getItemName() {
        return "Obsidian Battle Plate";
    }

    @Override
    public int getItemCost() {
        return 2;
    }

}
