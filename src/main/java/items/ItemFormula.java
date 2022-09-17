package items;

import models.Game;
import models.player.Player;

public interface ItemFormula {
    double getPoints(Game game, Player player);
}
