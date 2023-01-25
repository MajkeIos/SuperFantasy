package models.items.rare;

import models.items.Item;
import models.Game;
import models.player.Player;

public class SoulHunter extends Item {

    @Override
    public double getPoints(Game game, Player player) {
        double maxSolokills = 0;
        for (Player tmpPlayer : game.getAllPlayers()) {
            maxSolokills = Math.max(maxSolokills,
                    tmpPlayer.stats().specificStats().challenges().soloKills());
        }
        return player.stats().specificStats().challenges().soloKills() == maxSolokills ? 15 : 0;
    }

    @Override
    public String getItemDescription() {
        return "15 points if the player gets most solokills in the game.";
    }

    @Override
    public String getItemName() {
        return "Soul Hunter";
    }

    @Override
    public int getItemCost() {
        return 1;
    }

}
