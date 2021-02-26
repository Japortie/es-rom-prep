package eu.mschuette.psx.rommanager.model;

import lombok.Data;

import java.nio.file.Path;

@Data
public class SbiFile {
    private Path path;
    private DiscId id;

    public SbiFile(Path path) {
        this.path = path;
        this.id = new DiscId(path.toFile().getName().replace(".sbi", ""));
    }
}
