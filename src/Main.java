import java.io.*;
import java.util.Properties;

public class Main {
    public static void main (String[] args) throws IOException {
                System.out.println(System.getenv("VAR"));

        //http://crunchify.com/java-properties-file-how-to-read-config-properties-values-in-java/

        Properties props = new Properties();

        props.setProperty("VAR", System.getenv("VAR"));
        OutputStream os ;
        File f = new File("server.properties");
        OutputStream out = new FileOutputStream( f );
        props.store(out,"Variable VAR");

    }
}