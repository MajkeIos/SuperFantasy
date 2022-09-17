package models.player.statistics.basic;

import org.json.JSONObject;

public record MultiKills(int doubleKills, int tripleKills, int quadraKills, int pentaKills) {

    public static MultiKills deserialize(JSONObject jsonObject) {

        int doubleKills = jsonObject.getInt("doubleKills");
        int tripleKills = jsonObject.getInt("tripleKills");
        int quadraKills = jsonObject.getInt("quadraKills");
        int pentaKills = jsonObject.getInt("pentaKills");

        return new MultiKills(doubleKills, tripleKills, quadraKills, pentaKills);
    }

}
