package models.items.rare;

import models.items.Item;
import models.Game;
import models.player.Player;

public class ElementalDischarge extends Item {

    @Override
    public double getPoints(Game game, Player player) {
        double maxObjectiveDamage = 0;
        for (Player tmpPlayer : game.getAllPlayers()) {
            maxObjectiveDamage = Math.max(maxObjectiveDamage,
                    tmpPlayer.stats().damage().neutralDamage().damageDealtToObjectives());
        }
        return player.stats().damage().neutralDamage().damageDealtToObjectives() == maxObjectiveDamage ? 18 : 0;
    }

    @Override
    public String getItemDescription() {
        return "18 points if the player deals the highest damage to objectives of the game.";
    }

    @Override
    public String getItemName() {
        return "Elemental Discharge";
    }

    @Override
    public int getItemCost() {
        return 1;
    }

}
