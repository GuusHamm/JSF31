package runtime;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.System.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args)
    {
        TimeStamp total = new TimeStamp();
        total.setBegin("Start of the program");
        TimeStamp t = new TimeStamp();
        t.init();
        t.setBegin();
        MetingDemo.main(args, t);
        t.setEnd();
        System.out.println(t.toString());
        System.out.println("=======================================================");
        for(int i=0 ; i< args.length;i+=2)
        {
            TimeStamp ts = new TimeStamp();
            try {
                new Thread(new Command(args[i] + " " + args[i+1])).start();

            } catch (Exception    e) {
                e.printStackTrace();
            }
            t.setEnd();
            System.out.println(ts.toString());
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        total.setEnd("Ending of the program");
        System.out.println("=======================================================");
        System.out.println(total.toString());
    }
}
