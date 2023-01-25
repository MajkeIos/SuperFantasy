package models.items.common;

import models.items.Item;
import models.Game;
import models.player.Player;

public class DivineImpetu extends Item {

    @Override
    public double getPoints(Game game, Player player) {
        double maxKDA = 0;
        for (Player tmpPlayer : game.getAllPlayers()) {
            maxKDA = Math.max(maxKDA,
                    tmpPlayer.stats().kdaFarmWards().kda().getKda());
        }
        return player.stats().kdaFarmWards().kda().getKda()== maxKDA ? 11 : 0;
    }

    @Override
    public String getItemDescription() {
        return "11 points if the player gets the best KDA of the game.";
    }

    @Override
    public String getItemName() {
        return "Divine Impetu";
    }

    @Override
    public int getItemCost() {
        return 0;
    }

}
