package models.items.epic;

import models.items.Item;
import models.Game;
import models.player.Player;

public class BloodyInstinct extends Item {

    @Override
    public double getPoints(Game game, Player player) {
        return player.stats().specificStats().assistsKills().firstBloodAssist() ? 15 : 0;
    }

    @Override
    public String getItemDescription() {
        return "15 points if the player assists in the first blood kill.";
    }

    @Override
    public String getItemName() {
        return "Bloody Instinct";
    }

    @Override
    public int getItemCost() {
        return 2;
    }

}
