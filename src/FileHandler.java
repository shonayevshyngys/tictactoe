import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.stream.Stream;

public class FileHandler {
    public FileHandler() {
    }

    public static void write(Path path, String s){
        try{
            String s1 = s+"\n";
            Files.write(path, s1.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String[] getAllContent(Path path){
        try {

            Stream<String> lines = Files.lines(path);
            String[] s = lines.toArray(String[]::new);
            return s;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
