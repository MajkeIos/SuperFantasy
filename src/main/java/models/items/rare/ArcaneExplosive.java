package models.items.rare;

import models.items.Item;
import models.Game;
import models.player.Player;

public class ArcaneExplosive extends Item {

    @Override
    public double getPoints(Game game, Player player) {
        return player.stats().damage().neutralDamage().damageDealtToTurrets() >= 4500 ? 12 : 0;
    }

    @Override
    public String getItemDescription() {
        return "12 points if the player deals 4500 damage to enemy towers or more.";
    }

    @Override
    public String getItemName() {
        return "Arcane Explosive";
    }

    @Override
    public int getItemCost() {
        return 1;
    }

}
