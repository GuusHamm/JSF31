import java.io.*;
import java.util.Properties;

public class Main {
    public static void main (String[] args) throws IOException {
        GetFromCommandLine commandLine = new GetFromCommandLine();
        commandLine.main(args);
        Writer w = new Writer();
        w.main(args);
        Reader r = new Reader();
        r.main(args);


    }
}