package models.items.common;

import models.items.Item;
import models.Game;
import models.player.Player;

public class MagneticDisintegrator extends Item {

    @Override
    public double getPoints(Game game, Player player) {
        return player.stats().specificStats().assistsKills().inhibitorKills() >= 0 ? 11 : 0;
    }

    @Override
    public String getItemDescription() {
        return "11 points if the player destroys an inhibitor.";
    }

    @Override
    public String getItemName() {
        return "Magnetic Disintegrator";
    }

    @Override
    public int getItemCost() {
        return 0;
    }

}
