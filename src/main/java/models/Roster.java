package models;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Roster {

    private final Map<String, String> players;
    private final Map<String, List<String>> playersItems;

    public Roster(Map<String, String> players, Map<String, List<String>> playersItems) {
        this.players = players;
        this.playersItems = playersItems;
    }

    public Map<String, String> getPlayers() {
        return players;
    }

    public Map<String, List<String>> getPlayersItems() {
        return playersItems;
    }

    public JSONObject serialize() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("topPlayer", players.get("top"));
        jsonObject.put("junglePlayer", players.get("jungle"));
        jsonObject.put("middlePlayer", players.get("middle"));
        jsonObject.put("bottomPlayer", players.get("bottom"));
        jsonObject.put("supportPlayer", players.get("support"));
        HashMap<String, JSONArray> itemsJson = new HashMap<>();
        playersItems.forEach((position, items) -> {
            JSONArray jsonArray = new JSONArray();
            jsonArray.putAll(playersItems.get(position));
            itemsJson.put(position, jsonArray);
        });
        jsonObject.put("topItems", itemsJson.get("top"));
        jsonObject.put("jungleItems", itemsJson.get("jungle"));
        jsonObject.put("middleItems", itemsJson.get("middle"));
        jsonObject.put("bottomItems", itemsJson.get("bottom"));
        jsonObject.put("supportItems", itemsJson.get("support"));
        return jsonObject;
    }

    public static Roster deserialize(JSONObject jsonObject) {
        HashMap<String, String> players = new HashMap<>() {{
            put("top", jsonObject.getString("topPlayer"));
            put("jungle", jsonObject.getString("junglePlayer"));
            put("middle", jsonObject.getString("middlePlayer"));
            put("bottom", jsonObject.getString("bottomPlayer"));
            put("support", jsonObject.getString("supportPlayer"));
        }};
        HashMap<String, JSONArray> itemsJson = new HashMap<>() {{
            put("top", jsonObject.getJSONArray("topItems"));
            put("jungle", jsonObject.getJSONArray("jungleItems"));
            put("middle", jsonObject.getJSONArray("middleItems"));
            put("bottom", jsonObject.getJSONArray("bottomItems"));
            put("support", jsonObject.getJSONArray("supportItems"));
        }};
        HashMap<String, List<String>> itemsMap = new HashMap<>();
        itemsJson.forEach((position, itemJson) -> {
            List<String> items = new ArrayList<>();
            itemsJson.get(position).forEach(item -> items.add((String) item));
            itemsMap.put(position, items);
        });
        return new Roster(players, itemsMap);
    }

}
