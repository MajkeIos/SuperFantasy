package models.player.statistics.basic;

import org.json.JSONObject;

public record AssistsKills(boolean firstBloodAssist, boolean firstBloodKill, boolean firstTowerAssist,
                           boolean firstTowerKill, int inhibitorKills, int inhibitorTakedowns) {

    public static AssistsKills deserialize(JSONObject jsonObject) {

        boolean firstBloodAssist = jsonObject.getBoolean("firstBloodAssist");
        boolean firstBloodKill = jsonObject.getBoolean("firstBloodKill");
        boolean firstTowerAssist = jsonObject.getBoolean("firstTowerAssist");
        boolean firstTowerKill = jsonObject.getBoolean("firstTowerKill");
        int inhibitorKills = jsonObject.getInt("inhibitorKills");
        int inhibitorTakedowns = jsonObject.getInt("inhibitorTakedowns");

        return new AssistsKills(firstBloodAssist, firstBloodKill, firstTowerAssist,
                firstTowerKill, inhibitorKills, inhibitorTakedowns);
    }
}
