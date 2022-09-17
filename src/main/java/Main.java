import utils.StatisticsHandler;

public class Main {

    public static void main(String[] args) {
        StatisticsHandler.legendaryItemsRank("G2 Jankos").forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
        System.out.println("\n");
        StatisticsHandler.epicItemsRank("G2 Jankos").forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
    }
}
