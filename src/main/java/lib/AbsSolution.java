package lib;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Locale;

public class Solution {
    public BufferedReader bufferedReader(){
        var name = this.getClass().getSimpleName().toLowerCase(Locale.ROOT);
        var resource = this.getClass()
                        .getResource(name);
        if(resource == null) {
            throw new RuntimeException("Resource not found!");
        }


        return resourceAsStream;
    }
}
