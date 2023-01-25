package models.items.common;

import models.items.Item;
import models.Game;
import models.player.Player;

public class ThirstyDagger extends Item {

    @Override
    public double getPoints(Game game, Player player) {
        return player.stats().specificStats().assistsKills().firstBloodKill() ? 15 : 0;
    }

    @Override
    public String getItemDescription() {
        return "15 points if the player makes the first blood of the game.";
    }

    @Override
    public String getItemName() {
        return "Thirsty Dagger";
    }

    @Override
    public int getItemCost() {
        return 0;
    }

}
