package models.items.rare;

import models.items.Item;
import models.Game;
import models.player.Player;

public class HuntressOfSouls extends Item {

    @Override
    public double getPoints(Game game, Player player) {
        double maxMinionKilled = 0;
        for (Player tmpPlayer : game.getAllPlayers()) {
            maxMinionKilled = Math.max(maxMinionKilled,
                    tmpPlayer.stats().kdaFarmWards().farmStats().totalMinionsKilled());
        }
        return player.stats().kdaFarmWards().farmStats().totalMinionsKilled() == maxMinionKilled ? 19 : 0;
    }

    @Override
    public String getItemDescription() {
        return "19 points if the player kills the highest number of minions of the game.";
    }

    @Override
    public String getItemName() {
        return "Huntress Of Souls";
    }

    @Override
    public int getItemCost() {
        return 1;
    }

}
