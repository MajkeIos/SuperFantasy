package models;

import models.player.Player;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.IntStream;

public class Game {

    private final List<Player> blueSidePlayers;
    private final List<Player> redSidePlayers;
    private final List<Player> allPlayers;
    private final int gameDuration;
    private final int gameId;

    public Game(List<Player> blueSidePlayers, List<Player> redSidePlayers, int gameDuration, int gameId) {
        this.blueSidePlayers = blueSidePlayers;
        this.redSidePlayers = redSidePlayers;
        this.gameDuration = gameDuration;
        this.gameId = gameId;
        this.allPlayers = new ArrayList<>();
        this.allPlayers.addAll(blueSidePlayers);
        this.allPlayers.addAll(redSidePlayers);
    }

    public List<Player> getBlueSidePlayers() {
        return blueSidePlayers;
    }

    public List<Player> getRedSidePlayers() {
        return redSidePlayers;
    }

    public List<Player> getAllPlayers() {
        return allPlayers;
    }

    public int getGameDuration() {
        return gameDuration;
    }

    public int getGameId() {
        return gameId;
    }

    public boolean hasPlayer(String summonerName) {
        AtomicBoolean returnValue = new AtomicBoolean(false);
        allPlayers.forEach(player -> {
            if (Objects.equals(player.summonerName(), summonerName))
                returnValue.set(true);
        });
        return returnValue.get();
    }

    public Player getPlayer(String summonerName) {
        for (Player player : allPlayers) {
            if (player.summonerName().equals(summonerName))
                return player;
        }
        return null;
    }

    public static Game deserialize(JSONObject jsonObject) {

        JSONArray participants = jsonObject.getJSONArray("participants");
        List<Player> blueSidePlayers = new ArrayList<>();
        List<Player> readSidePlayers = new ArrayList<>();
        IntStream.range(0, 5).mapToObj(i -> Player.deserialize(participants.getJSONObject(i))).forEach(blueSidePlayers::add);
        IntStream.range(5, 10).mapToObj(i -> Player.deserialize(participants.getJSONObject(i))).forEach(readSidePlayers::add);

        int gameDuration = jsonObject.getInt("gameDuration");
        int gameId = jsonObject.getInt("gameId");

        return new Game(blueSidePlayers, readSidePlayers, gameDuration, gameId);
    }
}
