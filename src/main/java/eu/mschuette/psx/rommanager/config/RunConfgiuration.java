package eu.mschuette.psx.rommanager.config;

import lombok.Data;


@Data
public class RunConfgiuration {
    private String gamelist;
    private String romTargetDir;
    private String gamelistTargetDir;

    public RunConfgiuration(String gamelist, String romTargetDir, String gamelistTargetDir) {
        this.gamelist = gamelist;
        this.romTargetDir = romTargetDir;
        this.gamelistTargetDir = gamelistTargetDir;
    }
}
