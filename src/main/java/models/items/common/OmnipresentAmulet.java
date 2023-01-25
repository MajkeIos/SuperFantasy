package models.items.common;

import models.items.Item;
import models.Game;
import models.player.Player;

public class OmnipresentAmulet extends Item {

    @Override
    public double getPoints(Game game, Player player) {
        double maxAssists = 0;
        for (Player tmpPlayer : game.getAllPlayers()) {
            maxAssists = Math.max(maxAssists,
                    tmpPlayer.stats().kdaFarmWards().kda().assists());
        }
        return player.stats().kdaFarmWards().kda().assists() == maxAssists ? 11 : 0;
    }

    @Override
    public String getItemDescription() {
        return "11 points if if the player makes the highest number of assists in the game.";
    }

    @Override
    public String getItemName() {
        return "Omnipresent Amulet";
    }

    @Override
    public int getItemCost() {
        return 0;
    }

}
