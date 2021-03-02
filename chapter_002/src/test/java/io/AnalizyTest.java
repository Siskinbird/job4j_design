package io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import java.io.File;
import java.io.IOException;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import java.io.*;

public class AnalizyTest {
    String separator = System.lineSeparator();
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void whenReadFile() throws IOException {
        StringBuilder buildString = new StringBuilder();
        File target = folder.newFile("target");
        Analizy.unavailable("./data/server.txt", target.getAbsolutePath());
        try (BufferedReader read = new BufferedReader(new FileReader(target.getAbsolutePath()))) {
            for (String line = read.readLine(); line != null; line = read.readLine()) {
                buildString.append(line).append(separator);
            }
        }
        assertThat(buildString.toString(), is("10:57:01 server down"
                + separator
                + "10:59:01 server up"
                + separator
                + "11:01:02 server down"
                + separator
                + "11:02:02 server up"
                + separator));
    }
}
