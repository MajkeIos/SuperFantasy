package models.items.rare;

import models.items.Item;
import models.Game;
import models.player.Player;

public class SwordsOfDarkness extends Item {

    @Override
    public double getPoints(Game game, Player player) {
        return player.stats().specificStats().multiKills().doubleKills() > 0 ? 15 : 0;
    }

    @Override
    public String getItemDescription() {
        return "15 points if the player makes a doublekill.";
    }

    @Override
    public String getItemName() {
        return "Swords Of Darkness";
    }

    @Override
    public int getItemCost() {
        return 1;
    }

}
