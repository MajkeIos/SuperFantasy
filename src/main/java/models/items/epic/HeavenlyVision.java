package models.items.epic;

import models.items.Item;
import models.Game;
import models.player.Player;

public class HeavenlyVision extends Item {

    @Override
    public double getPoints(Game game, Player player) {
        double maxVisionScore = 0;
        for (Player tmpPlayer : game.getAllPlayers()) {
            maxVisionScore = Math.max(maxVisionScore,
                    tmpPlayer.stats().kdaFarmWards().wardStats().visionScore());
        }
        return player.stats().kdaFarmWards().wardStats().visionScore() == maxVisionScore ? 22 : 0;
    }

    @Override
    public String getItemDescription() {
        return "22 points if the player gets the highest vision score of the game.";
    }

    @Override
    public String getItemName() {
        return "Heavenly Vision";
    }

    @Override
    public int getItemCost() {
        return 2;
    }

}
