package models.items.rare;

import models.items.Item;
import models.Game;
import models.player.Player;

public class DeathHelper extends Item {

    @Override
    public double getPoints(Game game, Player player) {
        return player.stats().kdaFarmWards().kda().assists() >= 8 ? 10 : 0;
    }

    @Override
    public String getItemDescription() {
        return "10 points if the player makes 8 assists or more.";
    }

    @Override
    public String getItemName() {
        return "Death Helper";
    }

    @Override
    public int getItemCost() {
        return 1;
    }

}
