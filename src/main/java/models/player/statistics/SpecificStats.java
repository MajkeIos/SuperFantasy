package models.player.statistics;

import models.player.statistics.basic.AssistsKills;
import models.player.statistics.basic.Challenges;
import models.player.statistics.basic.FancyStats;
import models.player.statistics.basic.MultiKills;
import org.json.JSONObject;

public record SpecificStats(AssistsKills assistsKills, Challenges challenges,
                            FancyStats fancyStats, MultiKills multiKills) {

    public static SpecificStats deserialize(JSONObject jsonObject) {

        AssistsKills assistsKills = AssistsKills.deserialize(jsonObject);
        Challenges challenges = Challenges.deserialize(jsonObject.getJSONObject("challenges"));
        FancyStats fancyStats = FancyStats.deserialize(jsonObject);
        MultiKills multiKills = MultiKills.deserialize(jsonObject);

        return new SpecificStats(assistsKills, challenges, fancyStats, multiKills);
    }
}
