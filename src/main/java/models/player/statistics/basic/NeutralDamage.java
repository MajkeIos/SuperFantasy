package models.player.statistics.basic;

import org.json.JSONObject;

public record NeutralDamage(int damageDealtToBuildings, int damageDealtToObjectives, int damageDealtToTurrets) {

    public static NeutralDamage deserialize(JSONObject jsonObject) {

        int damageDealtToBuildings = jsonObject.getInt("damageDealtToBuildings");
        int damageDealtToObjectives = jsonObject.getInt("damageDealtToObjectives");
        int damageDealtToTurrets = jsonObject.getInt("damageDealtToTurrets");

        return new NeutralDamage(damageDealtToBuildings, damageDealtToObjectives, damageDealtToTurrets);
    }
}
