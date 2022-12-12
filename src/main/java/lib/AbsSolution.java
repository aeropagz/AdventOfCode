package lib;

import aoc2022.Day1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;

public abstract class AbsSolution {

    protected Logger log = LoggerFactory.getLogger(this.getClass());

    public abstract void part1(BufferedReader reader);
    public abstract void part2(BufferedReader reader);

    public void run(){
        part1(bufferedReader());
        part2(bufferedReader());

    };


    private BufferedReader bufferedReader() {
        var resourceName = this.getClass().getSimpleName().toLowerCase(Locale.ROOT);
        var resource = this.getClass().getResource(resourceName);

        if (resource == null) {
            throw new RuntimeException("Resource not found!");
        }

        try {
            return Files.newBufferedReader(Path.of(resource.toURI()));
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
