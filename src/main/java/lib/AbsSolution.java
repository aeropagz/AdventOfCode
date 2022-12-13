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

public abstract class AbsSolution<T1, T2> {

    protected Logger log = LoggerFactory.getLogger(this.getClass());

    public abstract T1 part1(BufferedReader reader);
    public abstract T2 part2(BufferedReader reader);

    public void run(){
        T1 x = part1(bufferedReader());
        T2 y = part2(bufferedReader());

        log.info("Part 1 Result: {}", x);
        log.info("Part 2 Result: {}", y);

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
