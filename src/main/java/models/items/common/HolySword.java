package models.items.common;

import models.items.Item;
import models.Game;
import models.player.Player;

public class HolySword extends Item {

    @Override
    public double getPoints(Game game, Player player) {
        double maxKills = 0;
        for (Player tmpPlayer : game.getAllPlayers()) {
            maxKills = Math.max(maxKills,
                    tmpPlayer.stats().kdaFarmWards().kda().kills());
        }
        return player.stats().kdaFarmWards().kda().kills() == maxKills ? 10 : 0;
    }

    @Override
    public String getItemDescription() {
        return "10 points if the player makes the highest kills count of the game.";
    }

    @Override
    public String getItemName() {
        return "Holy Sword";
    }

    @Override
    public int getItemCost() {
        return 0;
    }

}
