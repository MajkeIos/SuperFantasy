package models.items.epic;

import models.items.Item;
import models.Game;
import models.player.Player;

public class SteelAura extends Item {

    @Override
    public double getPoints(Game game, Player player) {
        double maxDamageTaken = 0;
        for (Player tmpPlayer : game.getAllPlayers()) {
            maxDamageTaken = Math.max(maxDamageTaken,
                    tmpPlayer.stats().damage().championDamage().totalDamageTaken());
        }
        return player.stats().damage().championDamage().totalDamageTaken() == maxDamageTaken ? 18 : 0;
    }

    @Override
    public String getItemDescription() {
        return "18 points if the player has the most damage taken.";
    }

    @Override
    public String getItemName() {
        return "Steel Aura";
    }

    @Override
    public int getItemCost() {
        return 2;
    }

}
