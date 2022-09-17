package utils;

import items.ItemFormula;

import java.util.*;
import java.util.stream.Collectors;

public class StatisticsHandler {

    public static List<Map.Entry<String, Double>> legendaryItemsRank(String summonerName) {
        return onePlayerItemRank(ItemsHandler.getLegendaryItems(), summonerName);
    }

    public static List<Map.Entry<String, Double>> epicItemsRank(String summonerName) {
        return onePlayerItemRank(ItemsHandler.getEpicItems(), summonerName);
    }

    public static List<Map.Entry<String, Double>> rareItemsRank(String summonerName) {
        return onePlayerItemRank(ItemsHandler.getRareItems(), summonerName);
    }

    public static List<Map.Entry<String, Double>> commonItemsRank(String summonerName) {
        return onePlayerItemRank(ItemsHandler.getCommonItems(), summonerName);
    }

    private static List<Map.Entry<String, Double>> onePlayerItemRank(HashMap<String, ItemFormula> items, String summonerName) {
        List<Map.Entry<String, Double>> itemRank = new LinkedList<>();
        items.keySet().forEach(item -> {
            double averagePoints = ItemsHandler.getAverageItemPoints(item, summonerName);
            itemRank.add(new AbstractMap.SimpleEntry<>(item, averagePoints));
        });
        return itemRank.stream().sorted(Map.Entry.<String, Double>comparingByValue().reversed()).collect(Collectors.toList());
    }
}
