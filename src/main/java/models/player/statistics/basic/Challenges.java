package models.player.statistics.basic;

import org.json.JSONObject;

public record Challenges(double goldPerMinute, double killParticipation, int soloKills, int turretPlatesTaken) {

    public static Challenges deserialize(JSONObject jsonObject) {

        double goldPerMinute = jsonObject.getDouble("goldPerMinute");
        double killParticipation;
        try {
            killParticipation = jsonObject.getDouble("killParticipation");
        } catch (Exception e) {
            killParticipation = 0;
        }
        int soloKills = jsonObject.getInt("soloKills");
        int turretPlatesTaken = jsonObject.getInt("turretPlatesTaken");

        return new Challenges(goldPerMinute, killParticipation, soloKills, turretPlatesTaken);
    }
}
