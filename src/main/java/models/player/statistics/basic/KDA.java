package models.player.statistics.basic;

import org.json.JSONObject;

public record KDA(int kills, int deaths, int assists) {

    public double getKda() {
        return (double)(kills + assists) / deaths;
    }

    public static KDA deserialize(JSONObject jsonObject) {

        int kills = jsonObject.getInt("kills");
        int deaths = jsonObject.getInt("deaths");
        int assists = jsonObject.getInt("assists");

        return new KDA(kills, deaths, assists);
    }
}
