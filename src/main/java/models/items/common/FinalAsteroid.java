package models.items.common;

import models.items.Item;
import models.Game;
import models.player.Player;

public class FinalAsteroid extends Item {

    @Override
    public double getPoints(Game game, Player player) {
        return player.stats().specificStats().multiKills().pentaKills() > 0 ? 100 : 0;
    }

    @Override
    public String getItemDescription() {
        return "100 points if the player makes a pentakill.";
    }

    @Override
    public String getItemName() {
        return "Final Asteroid";
    }

    @Override
    public int getItemCost() {
        return 0;
    }

}
