package utils;

import org.json.JSONObject;

import static java.lang.System.exit;

public class SettingsHandler {

    private final String settingsFilename = "settings.json";
    private int maxRosterCost;
    private int maxSameTeamPlayers;
    private int maxPlayerItemCopies;
    private int minPlayersChosen;
    private static SettingsHandler settingsHandler;

    private SettingsHandler() {
        try {
            initialize();
        } catch (Exception e) {
            e.printStackTrace();
            exit(-1);
        }
    }

    public static SettingsHandler getInstance() {
        if (settingsHandler != null) {
            return settingsHandler;
        }
        return new SettingsHandler();
    }

    public void updateRosterCost(int rosterCost) {
        maxRosterCost = rosterCost;
        saveSettings();
    }

    public void saveSettings() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("maxRosterCost", maxRosterCost);
        jsonObject.put("maxSameTeamPlayers", maxSameTeamPlayers);
        jsonObject.put("maxPlayerItemCopies", maxPlayerItemCopies);
        jsonObject.put("minPlayersChosen", minPlayersChosen);
        FileHandler.saveJsonToFile(jsonObject, settingsFilename);
    }

    private void initialize() throws Exception {
        JSONObject jsonObject = FileHandler.readJsonFromFile(FileHandler.folderPathname + settingsFilename);
        maxRosterCost = jsonObject.getInt("maxRosterCost");
        maxSameTeamPlayers = jsonObject.getInt("maxSameTeamPlayers");
        maxPlayerItemCopies = jsonObject.getInt("maxPlayerItemCopies");
        minPlayersChosen = jsonObject.getInt("minPlayersChosen");
    }

    public int getMaxRosterCost() {
        return maxRosterCost;
    }

    public int getMaxSameTeamPlayers() {
        return maxSameTeamPlayers;
    }

    public int getMaxPlayerItemCopies() {
        return maxPlayerItemCopies;
    }

    public int getMinPlayersChosen() {
        return minPlayersChosen;
    }

}
