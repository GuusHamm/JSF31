package runtime;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by wouter on 9/22/15.
 */
public class Command implements Runnable {
    @Override
    public void run() {

    }
    public Command(String command) throws Exception {

        StringBuilder sb=new StringBuilder();
        Process p = Runtime.getRuntime().exec(command);
        p.waitFor();

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(p.getInputStream()));

        String line = "";
        while ((line = reader.readLine())!= null) {
            sb.append(line + "\n");
        }
        System.out.println(sb.toString());
        System.out.println(command + " has ended.");
        System.out.println("=======================================================");
    }
}
