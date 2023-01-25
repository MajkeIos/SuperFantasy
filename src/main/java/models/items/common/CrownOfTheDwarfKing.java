package models.items.common;

import models.items.Item;
import models.Game;
import models.player.Player;

public class CrownOfTheDwarfKing extends Item {

    @Override
    public double getPoints(Game game, Player player) {
        double maxGoldEarned = 0;
        for (Player tmpPlayer : game.getAllPlayers()) {
            maxGoldEarned = Math.max(maxGoldEarned,
                    tmpPlayer.stats().specificStats().fancyStats().goldEarned());
        }
        return player.stats().specificStats().fancyStats().goldEarned() == maxGoldEarned ? 13 : 0;
    }

    @Override
    public String getItemDescription() {
        return "13 points if the player makes the highest gold number in the game.";
    }

    @Override
    public String getItemName() {
        return "Crown Of The Dwarf King";
    }

    @Override
    public int getItemCost() {
        return 0;
    }

}
