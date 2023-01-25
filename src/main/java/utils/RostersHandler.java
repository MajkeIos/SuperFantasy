package utils;

import models.Roster;
import models.User;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import static java.lang.System.exit;

public class RostersHandler {

    private final String rostersFilename = "rosters.json";
    private Map<String, Roster> rosters;
    private static RostersHandler rostersHandler;

    private RostersHandler() {
        try {
            initialize();
        } catch (Exception e) {
            e.printStackTrace();
            exit(-1);
        }
    }

    public static RostersHandler getInstance() {
        if (rostersHandler != null) {
            return rostersHandler;
        }
        return new RostersHandler();
    }

    public void saveRosters() {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        rosters.forEach((rosterOwner, roster) -> {
            JSONObject rosterJson = new JSONObject();
            rosterJson.put("rosterOwner", rosterOwner);
            rosterJson.put("roster", roster.serialize());
            jsonArray.put(rosterJson);
        });
        jsonObject.put("rosters", jsonArray);
        FileHandler.saveJsonToFile(jsonObject, rostersFilename);
    }

    private void initialize() throws Exception {
        rosters = new HashMap<>();
        JSONObject jsonObject = FileHandler.readJsonFromFile(FileHandler.folderPathname + rostersFilename);
        if (jsonObject == null) {
            return;
        }
        JSONArray jsonArray = jsonObject.getJSONArray("rosters");
        IntStream.range(0, jsonArray.length()).forEach(i -> {
                    JSONObject rosterJson = jsonArray.getJSONObject(i);
                    rosters.put(rosterJson.getString("rosterOwner"), Roster.deserialize(rosterJson.getJSONObject("roster")));
                });
    }

    public Map<String, Roster> getRosters() {
        return rosters;
    }

    public void addRoster(String user, Roster roster) {
        rosters.put(user, roster);
        saveRosters();
    }

    public void removeRoster(String user) {
        rosters.remove(user);
        saveRosters();
    }

}
