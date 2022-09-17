package models.player;

import models.player.statistics.Stats;
import org.json.JSONObject;

public record Player(Stats stats, String summonerName) {

    public static Player deserialize(JSONObject jsonObject) {

        Stats stats = Stats.deserialize(jsonObject);
        String summonerName = jsonObject.getString("summonerName");

        return new Player(stats, summonerName);
    }

    public Team getTeam() {
        String team = summonerName.substring(0, summonerName.indexOf(" "));
        for (Team tmp : Team.values()) {
            if (team.equals(tmp.toString()))
                return tmp;
        }
        return null;
    }
}
