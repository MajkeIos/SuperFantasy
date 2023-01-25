package models.items.common;

import models.items.Item;
import models.Game;
import models.player.Player;

public class ColossalMace extends Item {

    @Override
    public double getPoints(Game game, Player player) {
        double maxTowersDamage = 0;
        for (Player tmpPlayer : game.getAllPlayers()) {
            maxTowersDamage = Math.max(maxTowersDamage,
                    tmpPlayer.stats().damage().neutralDamage().damageDealtToTurrets());
        }
        return player.stats().damage().neutralDamage().damageDealtToTurrets() == maxTowersDamage ? 11 : 0;
    }

    @Override
    public String getItemDescription() {
        return "11 points if the player makes the highest damage to enemy towers of the game.";
    }

    @Override
    public String getItemName() {
        return "Colossal Mace";
    }

    @Override
    public int getItemCost() {
        return 0;
    }

}
