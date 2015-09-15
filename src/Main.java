import com.oracle.webservices.internal.api.message.PropertySet;
import javafx.beans.property.SetProperty;

import java.io.IOException;
import java.io.*;
import java.util.Properties;

public class Main {
    public static void main (String[] args) throws IOException {
                System.out.println(System.getenv("VAR"));
        // create and load default properties
        Properties defaultProps = new Properties();
        FileInputStream in = new FileInputStream("defaultProperties");
        defaultProps.load(in);
        in.close();

// create application properties with default
        Properties applicationProps = new Properties(defaultProps);



        
    }
}