package models.items.rare;

import models.items.Item;
import models.Game;
import models.player.Player;

public class RockTomb extends Item {

    @Override
    public double getPoints(Game game, Player player) {
        return player.stats().damage().neutralDamage().damageDealtToObjectives() >= 15500 ? 10 : 0;
    }

    @Override
    public String getItemDescription() {
        return "10 points if the player deals 15500 damage to objectives or more.";
    }

    @Override
    public String getItemName() {
        return "Rock Tomb";
    }

    @Override
    public int getItemCost() {
        return 1;
    }

}
