package models.items;

import models.Game;
import models.player.Player;

abstract public class Item {

    public abstract double getPoints(Game game, Player player);
    public abstract String getItemDescription();
    public abstract String getItemName();
    public abstract int getItemCost();
}
