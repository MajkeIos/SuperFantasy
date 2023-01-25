package models.items.epic;

import models.items.Item;
import models.Game;
import models.player.Player;

public class OmnipresentSpirit extends Item {

    @Override
    public double getPoints(Game game, Player player) {
        double maxKillParticipation = 0;
        for (Player tmpPlayer : game.getAllPlayers()) {
            maxKillParticipation = Math.max(maxKillParticipation,
                    tmpPlayer.stats().specificStats().challenges().killParticipation());
        }
        return player.stats().specificStats().challenges().killParticipation() == maxKillParticipation ? 18 : 0;
    }

    @Override
    public String getItemDescription() {
        return "18 points if the player has the highest kill participation.";
    }

    @Override
    public String getItemName() {
        return "Omnipresent Spirit";
    }

    @Override
    public int getItemCost() {
        return 2;
    }

}
