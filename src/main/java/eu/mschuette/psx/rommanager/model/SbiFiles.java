package eu.mschuette.psx.rommanager.model;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public class SbiFiles {
    private Map<String, SbiFile> filesById;

    public SbiFiles(String dirname) throws IOException {
        this.filesById = Files.walk(Paths.get(dirname))
                .filter(Files::isRegularFile)
                .filter(x -> x.toFile().getName().contains(".sbi"))
                .map(SbiFile::new)
                .collect(Collectors.toMap(x -> x.getId().getPretty(), x -> x));
    }

    public SbiFile getSbi(DiscId discId) {
        return filesById.get(discId.getPretty());
    }

    public int getCount() {
        return filesById.size();
    }
}
