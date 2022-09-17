package models.player.statistics.basic;

import org.json.JSONObject;

public record FancyStats(int champLevel, int goldEarned, int largestCriticalStrike,
                         int largestKillingSpree, int timeCCingOthers, int totalHeal) {

    public static FancyStats deserialize(JSONObject jsonObject) {

        int champLevel = jsonObject.getInt("champLevel");
        int goldEarned = jsonObject.getInt("goldEarned");
        int largestCriticalStrike = jsonObject.getInt("largestCriticalStrike");
        int largestKillingSpree = jsonObject.getInt("largestKillingSpree");
        int timeCCingOthers = jsonObject.getInt("timeCCingOthers");
        int totalHeal = jsonObject.getInt("totalHeal");

        return new FancyStats(champLevel, goldEarned, largestCriticalStrike,
                largestKillingSpree, timeCCingOthers, totalHeal);
    }
}
