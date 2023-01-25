package models.items.rare;

import models.items.Item;
import models.Game;
import models.player.Player;

public class DemonClaws extends Item {

    @Override
    public double getPoints(Game game, Player player) {
        double maxMinionKilled = 0;
        for (Player tmpPlayer : game.getAllPlayers()) {
            maxMinionKilled = Math.max(maxMinionKilled,
                    tmpPlayer.stats().kdaFarmWards().farmStats().totalMinionsKilled());
        }
        return player.stats().kdaFarmWards().farmStats().totalMinionsKilled() == maxMinionKilled ? 17 : 0;
    }

    @Override
    public String getItemDescription() {
        return "17 points if the player makes the highest number of minions killed per minute of the game.";
    }

    @Override
    public String getItemName() {
        return "Demon Claws";
    }

    @Override
    public int getItemCost() {
        return 1;
    }

}
