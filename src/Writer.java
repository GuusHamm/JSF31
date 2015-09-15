import java.io.*;
import java.util.Properties;

/**
 * Created by linux on 15-9-15.
 */
public class Writer {
    public static void main (String[] args) throws IOException {
        Properties properties = new Properties();

        properties.load(new FileInputStream(System.getenv("HOME") + "/env.properties"));

        for (String s : args)
        {
            properties.setProperty(s.substring(0,s.indexOf("=")),s.substring(s.indexOf("=")+1));
        }
        File f;
        if (System.getProperty("os.name").equals("Linux"))
        {
            f = new File(System.getenv("HOME") + "/env.properties");
        }
        else
        {
            f = new File("C:/env.properties");
        }

        OutputStream out = new FileOutputStream(f);
        properties.store(out, "Variable VAR");

    }
}
