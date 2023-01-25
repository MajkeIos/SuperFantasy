package models.items.epic;

import models.items.Item;
import models.Game;
import models.player.Player;

public class BeastHunter extends Item {

    @Override
    public  double getPoints(Game game, Player player) {
        double maxNeutralMinions = 0;
        for (Player tmpPlayer : game.getAllPlayers()) {
            maxNeutralMinions = Math.max(maxNeutralMinions,
                    tmpPlayer.stats().kdaFarmWards().farmStats().neutralMinionsKilled());
        }
        return player.stats().kdaFarmWards().farmStats().neutralMinionsKilled() == maxNeutralMinions ? 18 : 0;
    }

    @Override
    public String getItemDescription() {
        return "18 points if the player kills the highest number of neutral minions of the game.";
    }

    @Override
    public String getItemName() {
        return "Beast Hunter";
    }

    @Override
    public int getItemCost() {
        return 2;
    }

}
