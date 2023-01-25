package utils;

import models.items.Item;

import java.util.*;
import java.util.stream.Collectors;

public class StatisticsHandler {

    public static List<Map.Entry<String, Double>> legendaryItemsRank(String summonerName) {
        return onePlayerItemRankFromAllGames(ItemsHandler.getLegendaryItems(), summonerName);
    }

    public static List<Map.Entry<String, Double>> epicItemsRank(String summonerName) {
        return onePlayerItemRankFromAllGames(ItemsHandler.getEpicItems(), summonerName);
    }

    public static List<Map.Entry<String, Double>> rareItemsRank(String summonerName) {
        return onePlayerItemRankFromAllGames(ItemsHandler.getRareItems(), summonerName);
    }

    public static List<Map.Entry<String, Double>> commonItemsRank(String summonerName) {
        return onePlayerItemRankFromAllGames(ItemsHandler.getCommonItems(), summonerName);
    }

    private static List<Map.Entry<String, Double>> onePlayerItemRankFromAllGames(HashMap<String, ? extends Item> items, String summonerName) {
        List<Map.Entry<String, Double>> itemRank = new LinkedList<>();
        items.keySet().forEach(item -> {
            double averagePoints = ItemsHandler.getAverageItemPointsFromAllGames(item, summonerName);
            itemRank.add(new AbstractMap.SimpleEntry<>(item, averagePoints));
        });
        return itemRank.stream().sorted(Map.Entry.<String, Double>comparingByValue().reversed()).collect(Collectors.toList());
    }
}
