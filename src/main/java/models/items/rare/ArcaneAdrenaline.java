package models.items.rare;

import models.items.Item;
import models.Game;
import models.player.Player;

public class ArcaneAdrenaline extends Item {

    @Override
    public double getPoints(Game game, Player player) {
        double maxMagicDamage = 0;
        for (Player tmpPlayer : game.getAllPlayers()) {
            maxMagicDamage = Math.max(maxMagicDamage,
                    tmpPlayer.stats().damage().championDamage().magicDamageDealtToChampions());
        }
        return player.stats().damage().championDamage().magicDamageDealtToChampions() == maxMagicDamage ? 16 : 0;
    }

    @Override
    public String getItemDescription() {
        return "16 points if the player deals the highest magic damage in the game.";
    }

    @Override
    public String getItemName() {
        return "Arcane Adrenaline";
    }

    @Override
    public int getItemCost() {
        return 1;
    }

}
