package models.player.statistics;

import models.player.statistics.basic.FarmStats;
import models.player.statistics.basic.KDA;
import models.player.statistics.basic.WardStats;
import org.json.JSONObject;

public record KdaFarmWards(KDA kda, FarmStats farmStats, WardStats wardStats) {

    public static KdaFarmWards deserialize(JSONObject jsonObject) {

        KDA kda = KDA.deserialize(jsonObject);
        FarmStats farmStats = FarmStats.deserialize(jsonObject);
        WardStats wardStats = WardStats.deserialize(jsonObject);
        
        return new KdaFarmWards(kda, farmStats, wardStats);
    }
}
