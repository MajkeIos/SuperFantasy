package models.player.statistics;

import models.player.statistics.basic.ChampionDamage;
import models.player.statistics.basic.NeutralDamage;
import org.json.JSONObject;

public record Damage(ChampionDamage championDamage, NeutralDamage neutralDamage) {

    public static Damage deserialize(JSONObject jsonObject) {

        ChampionDamage championDamage = ChampionDamage.deserialize(jsonObject);
        NeutralDamage neutralDamage = NeutralDamage.deserialize(jsonObject);

        return new Damage(championDamage, neutralDamage);
    }
}
