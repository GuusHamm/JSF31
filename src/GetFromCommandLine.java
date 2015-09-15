import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

/**
 * Created by linux on 15-9-15.
 */
public class GetFromCommandLine {
    public static void main (String[] args) throws IOException {
        Properties props = new Properties();

        props.setProperty("VAR", System.getenv("VAR"));


        File f = new File(System.getenv("HOME") + "/" + "env.properties");
        OutputStream out = new FileOutputStream(f);
        props.store(out, "Variable VAR");

    }
}
