package models.player.statistics.basic;

import org.json.JSONObject;

public record ChampionDamage(int magicDamageDealtToChampions, int physicalDamageDealtToChampions,
                             int totalDamageDealtToChampions, int totalDamageTaken) {

    public static ChampionDamage deserialize(JSONObject jsonObject) {

        int magicDamageDealtToChampions = jsonObject.getInt("magicDamageDealtToChampions");
        int physicalDamageDealtToChampions = jsonObject.getInt("physicalDamageDealtToChampions");
        int totalDamageDealtToChampions = jsonObject.getInt("totalDamageDealtToChampions");
        int totalDamageTaken = jsonObject.getInt("totalDamageTaken");

        return new ChampionDamage(magicDamageDealtToChampions, physicalDamageDealtToChampions,
                totalDamageDealtToChampions, totalDamageTaken);
    }
}
