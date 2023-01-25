package models.items.legendary;

import models.items.Item;
import models.Game;
import models.player.Player;

public class DivineAscent extends Item {

    @Override
    public double getPoints(Game game, Player player) {
        return player.stats().specificStats().fancyStats().champLevel() == 18 ? 25 : 0;
    }

    @Override
    public String getItemDescription() {
        return "25 points if the player reaches level 18.";
    }

    @Override
    public String getItemName() {
        return "Divine Ascent";
    }

    @Override
    public int getItemCost() {
        return 3;
    }

}
