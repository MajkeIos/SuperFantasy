package models.items.epic;

import models.items.Item;
import models.Game;
import models.player.Player;

public class TreasurersWisdom extends Item {

    @Override
    public double getPoints(Game game, Player player) {
        return player.stats().specificStats().fancyStats().goldEarned() >= 12800 ? 17 : 0;
    }

    @Override
    public String getItemDescription() {
        return "17 points if the player gets 12800 gold or more.";
    }

    @Override
    public String getItemName() {
        return "Treasurer's Wisdom";
    }

    @Override
    public int getItemCost() {
        return 2;
    }

}
