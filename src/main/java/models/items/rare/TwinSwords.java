package models.items.rare;

import models.items.Item;
import models.Game;
import models.player.Player;

public class TwinSwords extends Item {

    @Override
    public double getPoints(Game game, Player player) {
        return player.stats().specificStats().multiKills().doubleKills() * 10;
    }

    @Override
    public String getItemDescription() {
        return "10 points for each doublekill the player makes.";
    }

    @Override
    public String getItemName() {
        return "Twin Swords";
    }

    @Override
    public int getItemCost() {
        return 1;
    }

}
