package models.items.common;

import models.items.Item;
import models.Game;
import models.player.Player;

public class HawksEye extends Item {

    @Override
    public double getPoints(Game game, Player player) {
        return player.stats().kdaFarmWards().wardStats().visionScore() >= 50 ? 8 : 0;
    }

    @Override
    public String getItemDescription() {
        return "8 points if the player gets a vision score of 50 or more.";
    }

    @Override
    public String getItemName() {
        return "Hawk's Eye";
    }

    @Override
    public int getItemCost() {
        return 0;
    }

}
