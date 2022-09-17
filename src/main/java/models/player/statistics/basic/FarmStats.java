package models.player.statistics.basic;

import org.json.JSONObject;

public record FarmStats(int neutralMinionsKilled, int totalMinionsKilled) {

    public static FarmStats deserialize(JSONObject jsonObject) {
        int neutralMinionsKilled = jsonObject.getInt("neutralMinionsKilled");
        int totalMinionsKilled = jsonObject.getInt("totalMinionsKilled");

        return new FarmStats(neutralMinionsKilled, totalMinionsKilled);
    }

}
