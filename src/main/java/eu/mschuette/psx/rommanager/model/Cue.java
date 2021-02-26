package eu.mschuette.psx.rommanager.model;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Cue {
    String file;
    public Cue(String file) {

        this.file = file;

    }

    public List<String> getBins() {
        try {
            String s = FileUtils.readFileToString(new File(file), StandardCharsets.UTF_8);
            String[] strings = StringUtils.substringsBetween(s, "FILE \"", "\" BINARY");
            return Arrays.asList(strings);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
