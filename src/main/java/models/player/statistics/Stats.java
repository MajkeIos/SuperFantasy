package models.player.statistics;

import org.json.JSONObject;

public record Stats(KdaFarmWards kdaFarmWards, Damage damage, SpecificStats specificStats) {

    public static Stats deserialize(JSONObject jsonObject) {

        KdaFarmWards kdaFarmWards = KdaFarmWards.deserialize(jsonObject);
        Damage damage = Damage.deserialize(jsonObject);
        SpecificStats specificStats = SpecificStats.deserialize(jsonObject);

        return new Stats(kdaFarmWards, damage, specificStats);
    }
}
