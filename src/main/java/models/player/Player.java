package models.player;

import models.Team;
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

    public int getPlayerPoints() {
        int points = 0;
        points += stats.kdaFarmWards().kda().kills() * 5;
        points -= stats.kdaFarmWards().kda().deaths() * 3;
        points += stats.kdaFarmWards().kda().assists() * 2;
        return points;
    }
}
