package utils;

import models.items.Item;
import models.items.common.*;
import models.items.epic.*;
import models.items.legendary.*;
import models.items.rare.*;
import models.Game;
import models.player.Player;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

import static java.lang.System.exit;

public class ItemsHandler {

    public static final String[] itemTypes = { "common", "rare", "epic", "legendary"};

    private static final HashMap<String, ? extends Item> commonItems = new HashMap<>() {{
        try {
            put("Colossal Mace", ColossalMace.class.getConstructor().newInstance());
            put("Crown Of The Dwarf King", CrownOfTheDwarfKing.class.getConstructor().newInstance());
            put("Divine Impetu", DivineImpetu.class.getConstructor().newInstance());
            put("Dual Spear", DualSpear.class.getConstructor().newInstance());
            put("Earthly Staff", EarthlyStaff.class.getConstructor().newInstance());
            put("Evasive Protection", EvasiveProtection.class.getConstructor().newInstance());
            put("Final Asteroid", FinalAsteroid.class.getConstructor().newInstance());
            put("Hawk's Eye", HawksEye.class.getConstructor().newInstance());
            put("Holy Sword", HolySword.class.getConstructor().newInstance());
            put("Magnetic Disintegrator", MagneticDisintegrator.class.getConstructor().newInstance());
            put("Meteorites", Meteorites.class.getConstructor().newInstance());
            put("Omnipresent Amulet", OmnipresentAmulet.class.getConstructor().newInstance());
            put("Royal Destroyer", RoyalDestroyer.class.getConstructor().newInstance());
            put("Siege Mace", SiegeMace.class.getConstructor().newInstance());
            put("Staff Of Conquered Worlds", StaffOfConqueredWorlds.class.getConstructor().newInstance());
            put("Thirsty Dagger", ThirstyDagger.class.getConstructor().newInstance());
            put("Trimeteor", Trimeteor.class.getConstructor().newInstance());
            put("Triple Spear", TripleSpear.class.getConstructor().newInstance());
            put("Wild Spirit", WildSpirit.class.getConstructor().newInstance());
        } catch (Exception e) {
            e.printStackTrace();
            exit(-1);
        }
    }};

    private static final HashMap<String, ? extends Item> rareItems = new HashMap<>() {{
        try {
            put("Accurate Sword", AccurateSword.class.getConstructor().newInstance());
            put("Arcane Adrenaline", ArcaneAdrenaline.class.getConstructor().newInstance());
            put("Arcane Explosive", ArcaneExplosive.class.getConstructor().newInstance());
            put("Being Of Light", BeingOfLight.class.getConstructor().newInstance());
            put("Dance Of Death", DanceOfDeath.class.getConstructor().newInstance());
            put("Death Helper", DeathHelper.class.getConstructor().newInstance());
            put("Demon Claws", DemonClaws.class.getConstructor().newInstance());
            put("Elemental Discharge", ElementalDischarge.class.getConstructor().newInstance());
            put("Huntress Of Souls", HuntressOfSouls.class.getConstructor().newInstance());
            put("Immortal Breastplate", ImmortalBreastplate.class.getConstructor().newInstance());
            put("Large Sword Of Hate", LargeSwordOfHate.class.getConstructor().newInstance());
            put("Precise Hammer", PreciseHammer.class.getConstructor().newInstance());
            put("Rock Tomb", RockTomb.class.getConstructor().newInstance());
            put("Savage Looter", SavageLooter.class.getConstructor().newInstance());
            put("Soul Hunter", SoulHunter.class.getConstructor().newInstance());
            put("Spirit Of The Warrior", SpiritOfTheWarrior.class.getConstructor().newInstance());
            put("Swords Of Darkness", SwordsOfDarkness.class.getConstructor().newInstance());
            put("The Undertaker", TheUndertaker.class.getConstructor().newInstance());
            put("Twin Swords", TwinSwords.class.getConstructor().newInstance());
            put("Unstoppable Lightning", UnstoppableLightning.class.getConstructor().newInstance());
            put("Versatil Saber", VersatilSaber.class.getConstructor().newInstance());
        } catch (Exception e) {
            e.printStackTrace();
            exit(-1);
        }
    }};

    private static final HashMap<String, ? extends Item> epicItems = new HashMap<>() {{
        try {
            put("Beast Hunter", BeastHunter.class.getConstructor().newInstance());
            put("Berseker Ax", BersekerAx.class.getConstructor().newInstance());
            put("Bloody Instinct", BloodyInstinct.class.getConstructor().newInstance());
            put("Conquering Staff", ConqueringStaff.class.getConstructor().newInstance());
            put("Fast Furious Blade", FastFuriousBlade.class.getConstructor().newInstance());
            put("Heavenly Vision", HeavenlyVision.class.getConstructor().newInstance());
            put("Obsidian Battle Plate", ObsidianBattlePlate.class.getConstructor().newInstance());
            put("Omnipresent Spirit", OmnipresentSpirit.class.getConstructor().newInstance());
            put("Rampage Momentum", RampageMomentum.class.getConstructor().newInstance());
            put("Sacred Help", SacredHelp.class.getConstructor().newInstance());
            put("Secret Scroll", SecretScroll.class.getConstructor().newInstance());
            put("Steel Aura", SteelAura.class.getConstructor().newInstance());
            put("The Puppeteer", ThePuppeteer.class.getConstructor().newInstance());
            put("The Visionary", TheVisionary.class.getConstructor().newInstance());
            put("Treasurer's Wisdom", TreasurersWisdom.class.getConstructor().newInstance());
        } catch (Exception e) {
            e.printStackTrace();
            exit(-1);
        }
    }};

    private static final HashMap<String, ? extends Item> legendaryItems = new HashMap<>() {{
        try {
           put("Divine Ascent", DivineAscent.class.getConstructor().newInstance());
           put("Guardian Totem", GuardianTotem.class.getConstructor().newInstance());
           put("Incapacitor", Incapacitor.class.getConstructor().newInstance());
           put("Legend Aura", LegendAura.class.getConstructor().newInstance());
           put("Scythe", Scythe.class.getConstructor().newInstance());
           put("Sharp Blade", SharpBlade.class.getConstructor().newInstance());
           put("Spirit Of The Squire", SpiritOfTheSquire.class.getConstructor().newInstance());
           put("The Stalker", TheStalker.class.getConstructor().newInstance());
           put("Thirsty Scythes", ThirstyScythes.class.getConstructor().newInstance());
           put("Wild Claw", WildClaw.class.getConstructor().newInstance());
        } catch (Exception e) {
            e.printStackTrace();
            exit(-1);
        }
    }};

    private static final HashMap<String, Item> allItems = new HashMap<>();

    static {
        allItems.putAll(commonItems);
        allItems.putAll(rareItems);
        allItems.putAll(epicItems);
        allItems.putAll(legendaryItems);
    }

    public static HashMap<String, ? extends Item> getCommonItems() {
        return commonItems;
    }

    public static HashMap<String, ? extends Item> getRareItems() {
        return rareItems;
    }

    public static HashMap<String, ? extends Item> getEpicItems() {
        return epicItems;
    }

    public static HashMap<String, ? extends Item> getLegendaryItems() {
        return legendaryItems;
    }

    public static HashMap<String, ? extends Item> getItems(int cost) {
        switch (cost) {
            case 0 -> { return getCommonItems(); }
            case 1 -> { return getRareItems(); }
            case 2 -> { return getEpicItems(); }
            case 3 -> { return getLegendaryItems(); }
        }
        return new HashMap<>();
    }

    public static HashMap<String, ? extends Item> getItems(String itemType) {
        switch (itemType) {
            case "common" -> { return getCommonItems(); }
            case "rare" -> { return getRareItems(); }
            case "epic" -> { return getEpicItems(); }
            case "legendary" -> { return getLegendaryItems(); }
        }
        return new HashMap<>();
    }

    public static HashMap<String, ? extends Item> getAllItems() {
        return allItems;
    }

    public static int getItemPointsFromGame(String itemName, String summonerName, Game game) {
        Player player = game.getPlayer(summonerName);
        Item item = allItems.get(itemName);
        return (int) item.getPoints(game, player);
    }

    public static double getItemPointsFromAllGames(String itemName, String summonerName) {
        double itemPoints = 0;
        Item item = allItems.get(itemName);
        for (Game game : AllGamesHandler.getInstance().getGames()) {
            if (game.hasPlayer(summonerName)) {
                Player player = game.getPlayer(summonerName);
                itemPoints += item.getPoints(game, player);
            }
        }
        return itemPoints;
    }

    public static double getAverageItemPointsFromAllGames(String itemName, String summonerName) {
        double itemPoints = ItemsHandler.getItemPointsFromAllGames(itemName, summonerName);
        double gamesPlayed = AllGamesHandler.getInstance().countPlayerGames(summonerName);
        return itemPoints / gamesPlayed;
    }

    private static JSONArray serializeItems(HashMap<String, ? extends Item> items) {
        var jsonArray = new JSONArray();
        items.keySet().forEach(jsonArray::put);
        return jsonArray;
    }

    public static JSONObject serialize() {
        var jsonObject = new JSONObject();
        jsonObject.put("common", serializeItems(commonItems));
        jsonObject.put("rare", serializeItems(rareItems));
        jsonObject.put("epic", serializeItems(epicItems));
        jsonObject.put("legendary", serializeItems(legendaryItems));
        return jsonObject;
    }
}
