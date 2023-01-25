package models.items.epic;

import models.items.Item;
import models.Game;
import models.player.Player;

public class SacredHelp extends Item {

    @Override
    public double getPoints(Game game, Player player) {
        return player.stats().specificStats().fancyStats().totalHeal() >= 800 ? 20 : 0;
    }

    @Override
    public String getItemDescription() {
        return "20 points if the player makes a healing number of more than 8000.";
    }

    @Override
    public String getItemName() {
        return "Sacred Help";
    }

    @Override
    public int getItemCost() {
        return 2;
    }

}
