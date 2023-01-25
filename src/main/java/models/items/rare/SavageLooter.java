package models.items.rare;

import models.items.Item;
import models.Game;
import models.player.Player;

public class SavageLooter extends Item {
//TODO

    @Override
    public double getPoints(Game game, Player player) {
        return -1;
    }

    @Override
    public String getItemDescription() {
        return "20 points if the player has the highest neutral minions killed in the enemy jungle.";
    }

    @Override
    public String getItemName() {
        return "Savage Looter";
    }

    @Override
    public int getItemCost() {
        return 1;
    }

}
