package models.items.common;

import models.items.Item;
import models.Game;
import models.player.Player;

public class StaffOfConqueredWorlds extends Item {

    @Override
    public double getPoints(Game game, Player player) {
        double maxWardsDestroyed = 0;
        for (Player tmpPlayer : game.getAllPlayers()) {
            maxWardsDestroyed = Math.max(maxWardsDestroyed,
                    tmpPlayer.stats().kdaFarmWards().wardStats().wardsKilled());
        }
        return player.stats().kdaFarmWards().wardStats().wardsKilled() == maxWardsDestroyed ? 11 : 0;
    }

    @Override
    public String getItemDescription() {
        return "11 points if the player destroys the largest number of wards in the game.";
    }

    @Override
    public String getItemName() {
        return "Staff Of Conquered Worlds";
    }

    @Override
    public int getItemCost() {
        return 0;
    }

}
