package models.items.rare;

import models.items.Item;
import models.Game;
import models.player.Player;

public class LargeSwordOfHate extends Item {

    @Override
    public double getPoints(Game game, Player player) {
        double maxChampionDamage = 0;
        for (Player tmpPlayer : game.getAllPlayers()) {
            maxChampionDamage = Math.max(maxChampionDamage,
                    tmpPlayer.stats().damage().championDamage().totalDamageDealtToChampions());
        }
        return player.stats().damage().championDamage().totalDamageDealtToChampions() == maxChampionDamage ? 20 : 0;
    }

    @Override
    public String getItemDescription() {
        return "20 points if the player deals the highest damage to enemy champions of the game.";
    }

    @Override
    public String getItemName() {
        return "Large Sword Of Hate";
    }

    @Override
    public int getItemCost() {
        return 1;
    }

}
