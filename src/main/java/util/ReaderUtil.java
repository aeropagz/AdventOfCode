package util;

import java.io.BufferedReader;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class ReaderUtil {
    public static Stream<Stream<String>> groupLines(BufferedReader reader, Predicate<String> endOfGroup) {
        var iterator = reader.lines().iterator();
        return Stream.generate(() -> {
            if (!iterator.hasNext())
                return null;

            Stream.Builder<String> accu = Stream.builder();
            String line;
            while (iterator.hasNext() && !endOfGroup.test(line = iterator.next())) {
                accu.accept(line);
            }
            return accu.build();
        }).takeWhile(Objects::nonNull);
    }
}
