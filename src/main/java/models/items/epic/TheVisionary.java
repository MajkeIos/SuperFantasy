package models.items.epic;

import models.items.Item;
import models.Game;
import models.player.Player;

public class TheVisionary extends Item {

    @Override
    public double getPoints(Game game, Player player) {
        double maxWardsPlaced = 0;
        for (Player tmpPlayer : game.getAllPlayers()) {
            maxWardsPlaced = Math.max(maxWardsPlaced,
                    tmpPlayer.stats().kdaFarmWards().wardStats().wardsPlaced());
        }
        return player.stats().kdaFarmWards().wardStats().wardsPlaced() == maxWardsPlaced ? 18 : 0;
    }

    @Override
    public String getItemDescription() {
        return "18 points if the player places the highest number of wards of the game.";
    }

    @Override
    public String getItemName() {
        return "The Visionary";
    }

    @Override
    public int getItemCost() {
        return 2;
    }

}
