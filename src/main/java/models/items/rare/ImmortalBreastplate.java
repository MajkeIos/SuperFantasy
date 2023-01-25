package models.items.rare;

import models.items.Item;
import models.Game;
import models.player.Player;

public class ImmortalBreastplate extends Item {

    @Override
    public double getPoints(Game game, Player player) {
        double minDeathNumber = 0;
        for (Player tmpPlayer : game.getAllPlayers()) {
            minDeathNumber = Math.min(minDeathNumber,
                    tmpPlayer.stats().kdaFarmWards().kda().deaths());
        }
        return player.stats().kdaFarmWards().kda().deaths() == minDeathNumber ? 14 : 0;
    }

    @Override
    public String getItemDescription() {
        return "14 points if the player has the lowest deaths number of the game.";
    }

    @Override
    public String getItemName() {
        return "Immortal Breastplate";
    }

    @Override
    public int getItemCost() {
        return 1;
    }

}
