package eu.mschuette.psx.rommanager;

import eu.mschuette.psx.rommanager.config.RunConfgiuration;
import eu.mschuette.psx.rommanager.io.GameListReader;
import eu.mschuette.psx.rommanager.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);
    public static void main(String... args) throws IOException {
        Main main = new Main();


        RunConfgiuration runConfgiuration = new RunConfgiuration(ClassLoader.getSystemClassLoader().getResource("gamelist.xml").getFile(), "test", "test");
        main.run(runConfgiuration);
    }

    public void run(RunConfgiuration runConfgiuration) throws IOException {
        GameListReader gameListReader = new GameListReader();
        SbiFiles sbiFiles = new SbiFiles("/home/schuette/work/private/es-rom-prep/src/main/resources/sbi/");

        GameList gamelist = gameListReader.read(runConfgiuration.getGamelist());
        List<Game> games = gamelist.getGames();

        int found = 0;
        int notfound = 0;
        int foundsbi = 0;

        for(Game game : games) {
            DiscId discId = game.getRom().getDiscId();
            if (discId.getPretty().equals("UNKNN001")) {
                notfound += 1;
                log.info("Loaded {} : {}  -  {}", game.getTitle(), discId.getId(), discId.getPretty());

            }
            else {
                found += 1;
                SbiFile sbi = sbiFiles.getSbi(discId);
                if (sbi != null) {
                    foundsbi++;
                    log.info("Loaded {} : {}  -  {} / SBI {}", game.getTitle(), discId.getId(), discId.getPretty(), sbi.getPath().toString());
                } else {
                    log.info("Loaded {} : {}  -  {}", game.getTitle(), discId.getId(), discId.getPretty());
                }
            }
        }

        log.info("--------------");
        log.info("Finished");
        log.info("Found {}/{}", found, found + notfound);
        log.info("Found Sbis {}/{}", foundsbi, sbiFiles.getCount());

//        System.out.println("Huhu");
//        Rom rom = new Rom("/home/schuette/Downloads/Bin2Pbp/testroms/Firestorm - Thunderhawk 2 (Europe) (En,Fr) (Track 01).bin");
//        System.out.println(String.format("Rom: '%s'", rom.getDiscId().getId()));
//        System.out.println(String.format("Rom Pretty: '%s'", rom.getDiscId().getPretty()));
//        System.out.println(String.format("%d", 10 << 20));

//        Gamelist gamelist = parseGamelist(gamelistFile);
//        List<Rom> roms = gamelist.findRoms();
//        roms.forEach(rom -> {
//            compressToChd(rom);
//            createOutputDir(rom);
//            copy(rom);
//            copySbi(rom);
//        });
//        generateGamelist();
//
//        GameList gameList = new GameList();
//        Game game = new Game();
//        game.setName("FF8");
//        game.setPath("/roms/FF8.cue");
//        gameList.add(game);
//
//        XStream xStream = new XStream();
//        xStream.alias("game", Game.class);
//        xStream.alias("gameList", GameList.class);
//
//        String s = xStream.toXML(gameList);
//        System.out.println(s);
    }
}
