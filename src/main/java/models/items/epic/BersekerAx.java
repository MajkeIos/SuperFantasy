package models.items.epic;

import models.items.Item;
import models.Game;
import models.player.Player;

public class BersekerAx extends Item {

    @Override
    public double getPoints(Game game, Player player) {
        return player.stats().damage().championDamage().totalDamageDealtToChampions() >= 14500 ? 14 : 0;
    }

    @Override
    public String getItemDescription() {
        return "14 points if the player deals more than 14500 damage to enemy champions.";
    }

    @Override
    public String getItemName() {
        return "Berseker Ax";
    }

    @Override
    public int getItemCost() {
        return 2;
    }

}
