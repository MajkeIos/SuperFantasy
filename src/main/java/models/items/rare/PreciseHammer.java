package models.items.rare;

import models.items.Item;
import models.Game;
import models.player.Player;

public class PreciseHammer extends Item {

    @Override
    public double getPoints(Game game, Player player) {
        double maxTurretPlatings = 0;
        for (Player tmpPlayer : game.getAllPlayers()) {
            maxTurretPlatings = Math.max(maxTurretPlatings,
                    tmpPlayer.stats().specificStats().challenges().turretPlatesTaken());
        }
        return player.stats().specificStats().challenges().turretPlatesTaken() == maxTurretPlatings ? 18 : 0;
    }

    @Override
    public String getItemDescription() {
        return "18 points if the player gets most turret platings in the game.";
    }

    @Override
    public String getItemName() {
        return "Precise Hammer";
    }

    @Override
    public int getItemCost() {
        return 1;
    }

}
