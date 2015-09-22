import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;
import java.io.FileInputStream;

/**
 * Created by linux on 15-9-15.
 */
public class Reader {
    public void main(String[] args) throws IOException {

        Properties properties = new Properties();

        if (System.getProperty("os.name").equals("Linux"))
        {
            properties.load(new FileInputStream(System.getenv("HOME") + "/env.properties"));
        }
        if (System.getProperty("os.name").equals("Windows"))
        {
            properties.load(new FileInputStream("C:/env.properties"));
        }

//        Enumeration e = properties.propertyNames();
//
//        while (e.hasMoreElements())
//        {
//            String next = e.nextElement().toString();
//            System.out.println(next + "="+properties.getProperty(next));
//        }
        System.out.println();
        properties.list(System.out);
    }
}

