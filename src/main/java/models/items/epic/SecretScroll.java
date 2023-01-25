package models.items.epic;

import models.items.Item;
import models.Game;
import models.player.Player;

public class SecretScroll extends Item {

    @Override
    public double getPoints(Game game, Player player) {
        return player.stats().specificStats().challenges().goldPerMinute() >= 450 ? 18 : 0;
    }

    @Override
    public String getItemDescription() {
        return "18 points if the player gets 450 or more gold per minute.";
    }

    @Override
    public String getItemName() {
        return "Secret Scroll";
    }

    @Override
    public int getItemCost() {
        return 2;
    }

}
