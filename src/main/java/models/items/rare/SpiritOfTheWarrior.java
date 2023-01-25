package models.items.rare;

import models.items.Item;
import models.Game;
import models.player.Player;

public class SpiritOfTheWarrior extends Item {

    @Override
    public double getPoints(Game game, Player player) {
        double maxPhysicalDamage = 0;
        for (Player tmpPlayer : game.getAllPlayers()) {
            maxPhysicalDamage = Math.max(maxPhysicalDamage,
                    tmpPlayer.stats().damage().championDamage().physicalDamageDealtToChampions());
        }
        return player.stats().damage().championDamage().physicalDamageDealtToChampions() == maxPhysicalDamage ? 16 : 0;
    }

    @Override
    public String getItemDescription() {
        return "16 points if the player deals the most physical damage in the game.";
    }

    @Override
    public String getItemName() {
        return "Spirit Of The Warrior";
    }

    @Override
    public int getItemCost() {
        return 1;
    }

}
