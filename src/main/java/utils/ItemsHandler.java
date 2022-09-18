package utils;

import items.ItemFormula;
import items.common.*;
import items.epic.*;
import items.legendary.*;
import items.rare.*;
import models.Game;
import models.player.Player;

import java.util.HashMap;

public class ItemsHandler {

    private static final HashMap<String, ItemFormula> legendaryItems = new HashMap<>() {{
       put("Divine Ascent", DivineAscent::getPoints);
       put("Guardian Totem", GuardianTotem::getPoints);
       put("Incapacitor", Incapacitor::getPoints);
       put("Legend Aura", Scythe::getPoints);
       put("Scythe", Scythe::getPoints);
       put("Sharp Blade", SharpBlade::getPoints);
       put("Spirit Of The Squire", SpiritOfTheSquire::getPoints);
       put("The Stalker", TheStalker::getPoints);
       put("Thirsty Scythes", ThirstyScythes::getPoints);
       put("Wild Claw", WildClaw::getPoints);
    }};

    private static final HashMap<String, ItemFormula> epicItems = new HashMap<>() {{
        put("Beast Hunter", BeastHunter::getPoints);
        put("Berseker Ax", BersekerAx::getPoints);
        put("Bloody Instinct", BloodyInstinct::getPoints);
        put("Conquering Staff", ConqueringStaff::getPoints);
        put("Fast Furious Blade", FastFuriousBlade::getPoints);
        put("Heavenly Vision", HeavenlyVision::getPoints);
        put("Obsidian Battle Plate", ObsidianBattlePlate::getPoints);
        put("Omnipresent Spirit", OmnipresentSpirit::getPoints);
        put("Rampage Momentum", RampageMomentum::getPoints);
        put("Sacred Help", SacredHelp::getPoints);
        put("Secret Scroll", SecretScroll::getPoints);
        put("Steel Aura", SteelAura::getPoints);
        put("The Puppeteer", ThePuppeteer::getPoints);
        put("The Visionary", TheVisionary::getPoints);
        put("Treasurer's Wisdom", TreasurersWisdom::getPoints);
    }};

    private static final HashMap<String, ItemFormula> rareItems = new HashMap<>() {{
        put("Accurate Sword", AccurateSword::getPoints);
        put("Arcane Adrenaline", ArcaneAdrenaline::getPoints);
        put("Arcane Explosive", ArcaneExplosive::getPoints);
        put("Being Of Light", BeingOfLight::getPoints);
        put("Dance Of Death", DanceOfDeath::getPoints);
        put("Death Helper", DeathHelper::getPoints);
        put("Demon Claws", DemonClaws::getPoints);
        put("Elemental Discharge", ElementalDischarge::getPoints);
        put("Huntress Of Souls", HuntressOfSouls::getPoints);
        put("Immortal Breastplate", ImmortalBreastplate::getPoints);
        put("Large Sword Of Hate", LargeSwordOfHate::getPoints);
        put("Precise Hammer", PreciseHammer::getPoints);
        put("Rock Tomb", RockTomb::getPoints);
        put("Savage Looter", SavageLooter::getPoints);
        put("Soul Hunter", SoulHunter::getPoints);
        put("Spirit Of The Warrior", SpiritOfTheWarrior::getPoints);
        put("Swords Of Darkness", SwordsOfDarkness::getPoints);
        put("The Undertaker", TheUndertaker::getPoints);
        put("Twin Swords", TwinSwords::getPoints);
        put("Unstoppable Lightning", UnstoppableLightning::getPoints);
        put("Versatil Saber", VersatilSaber::getPoints);
    }};

    private static final HashMap<String, ItemFormula> commonItems = new HashMap<>() {{
        put("Colossal Mace", ColossalMace::getPoints);
        put("Crown Of The Dwarf King", CrownOfTheDwarfKing::getPoints);
        put("Divine Impetu", DivineImpetu::getPoints);
        put("Dual Spear", DualSpear::getPoints);
        put("Earthly Staff", EarthlyStaff::getPoints);
        put("Evasive Protection", EvasiveProtection::getPoints);
        put("Final Asteroid", FinalAsteroid::getPoints);
        put("Hawk's Eye", HawksEye::getPoints);
        put("Holy Sword", HolySword::getPoints);
        put("Magnetic Disintegrator", MagneticDisintegrator::getPoints);
        put("Meteorites", Meteorites::getPoints);
        put("Omnipresent Amulet", OmnipresentAmulet::getPoints);
        put("Royal Destroyer", RoyalDestroyer::getPoints);
        put("Siege Mace", SiegeMace::getPoints);
        put("Staff Of Conquered Worlds", StaffOfConqueredWorlds::getPoints);
        put("Thirsty Dagger", ThirstyDagger::getPoints);
        put("Trimeteor", Trimeteor::getPoints);
        put("Triple Spear", TripleSpear::getPoints);
        put("Wild Spirit", WildSpirit::getPoints);
    }};

    public static HashMap<String, ItemFormula> getLegendaryItems() {
        return legendaryItems;
    }

    public static HashMap<String, ItemFormula> getEpicItems() {
        return epicItems;
    }

    public static HashMap<String, ItemFormula> getRareItems() {
        return rareItems;
    }

    public static HashMap<String, ItemFormula> getCommonItems() {
        return commonItems;
    }

    public static double getItemPoints(String itemName, String summonerName) {
        double itemPoints = 0;
        ItemFormula itemFormula = getItemFormula(itemName);
        for (Game game : GamesHandler.getInstance().getGames()) {
            if (game.hasPlayer(summonerName)) {
                Player player = game.getPlayer(summonerName);
                itemPoints += itemFormula.getPoints(game, player);
            }
        }
        return itemPoints;
    }

    public static double getAverageItemPoints(String itemName, String summonerName) {
        double itemPoints = ItemsHandler.getItemPoints(itemName, summonerName);
        double gamesPlayed = GamesHandler.getInstance().countPlayerGames(summonerName);
        return itemPoints / gamesPlayed;
    }

    private static ItemFormula getItemFormula(String itemName) {
        HashMap<String, ItemFormula> tmpMap = new HashMap<>();
        tmpMap.putAll(legendaryItems);
        tmpMap.putAll(epicItems);
        tmpMap.putAll(rareItems);
        tmpMap.putAll(commonItems);
        return tmpMap.get(itemName);
    }

}

