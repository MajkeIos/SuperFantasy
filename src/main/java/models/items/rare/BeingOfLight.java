package models.items.rare;

import models.items.Item;
import models.Game;
import models.player.Player;

public class BeingOfLight extends Item {

    @Override
    public double getPoints(Game game, Player player) {
        double maxHealingNumber = 0;
        for (Player tmpPlayer : game.getAllPlayers()) {
            maxHealingNumber = Math.max(maxHealingNumber,
                    tmpPlayer.stats().specificStats().fancyStats().totalHeal());
        }
        return player.stats().specificStats().fancyStats().totalHeal() == maxHealingNumber ? 18 : 0;
    }

    @Override
    public String getItemDescription() {
        return "18 points if the player makes the highest healing number of the game.";
    }

    @Override
    public String getItemName() {
        return "Being Of Light";
    }

    @Override
    public int getItemCost() {
        return 1;
    }

}
