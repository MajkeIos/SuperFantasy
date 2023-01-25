package models.items.epic;

import models.items.Item;
import models.Game;
import models.player.Player;

public class FastFuriousBlade extends Item {

    @Override
    public double getPoints(Game game, Player player) {
        return player.stats().kdaFarmWards().farmStats().totalMinionsKilled() /
                (game.getGameDuration() / 60.0) >= 9 ? 16 : 0;
    }

    @Override
    public String getItemDescription() {
        return "16 points if the player kills 9 or more minions per minute.";
    }

    @Override
    public String getItemName() {
        return "Fast Furious Blade";
    }

    @Override
    public int getItemCost() {
        return 2;
    }

}
