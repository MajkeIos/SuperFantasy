package models.player.statistics.basic;

import org.json.JSONObject;

public record WardStats(int visionScore, int wardsPlaced, int wardsKilled) {

    public static WardStats deserialize(JSONObject jsonObject) {

        int visionScore = jsonObject.getInt("visionScore");
        int wardsPlaced = jsonObject.getInt("wardsPlaced");
        int wardsKilled = jsonObject.getInt("wardsKilled");

        return new WardStats(visionScore, wardsPlaced, wardsKilled);
    }
}
