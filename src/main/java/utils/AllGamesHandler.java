package utils;

import models.Game;

import java.util.ArrayList;
import java.util.List;

public class AllGamesHandler {

    private final List<Game> games;
    private static AllGamesHandler allGamesHandler;

    private AllGamesHandler() {
        games = new ArrayList<>();
        updateGames();
    }

    public static AllGamesHandler getInstance() {
        if (allGamesHandler == null)
            return new AllGamesHandler();
        return allGamesHandler;
    }

    public List<Game> getGames() {
        return games;
    }

    public int countPlayerGames(String summonerName) {
        return games.stream().filter(game -> game.hasPlayer(summonerName)).toList().size();
    }

    private void updateGames() {
        FileHandler.getAllFiles(FileHandler.gamesPathname).forEach(folder ->
            FileHandler.getAllFiles(folder).forEach(file -> {
                try {
                    games.add(FileHandler.readGameFromFile(file));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            })
        );
    }
}
