import java.io.*;
import java.util.Properties;

/**
 * Created by linux on 15-9-15.
 */
public class Writer {
    public static void main (String[] args) throws IOException {
        Properties properties = new Properties();

        //Load the properties on a os specific folder
        if (System.getProperty("os.name").equals("Linux"))
        {
            properties.load(new FileInputStream(System.getenv("HOME") + "/env.properties"));
        }
        else
        {
            properties.load(new FileInputStream("C:/Program Files/env.properties"));
        }

        //Read the arguments
        for (String s : args)
        {
            properties.setProperty(s.substring(0,s.indexOf("=")),s.substring(s.indexOf("=")+1));
        }

        //Write the properties to a file in a specific folder
        File f;
        if (System.getProperty("os.name").equals("Linux"))
        {d
            f = new File(System.getenv("HOME") + "/env.properties");
        }
        else
        {
            f = new File("C:/Program Files/env.properties");
        }

        OutputStream out = new FileOutputStream(f);
        properties.store(out, "Variable VAR");

    }
}
