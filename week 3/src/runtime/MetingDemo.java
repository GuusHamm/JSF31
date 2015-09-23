/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package runtime;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author erik
 */
public class MetingDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args, TimeStamp t) {
        try {
            Runtime r = Runtime.getRuntime();
            //3
            System.out.println("Available proccesors : " + r.availableProcessors());
            System.out.println("Available memory : " + r.maxMemory());
            System.out.println("Max memory : " + r.maxMemory());
            System.out.println("Available memory right now : " + r.freeMemory());
            System.out.println("Current memory in use: " + (r.maxMemory() - r.freeMemory()));

            //4
            System.out.println("Free memory before loop : " + r.freeMemory());
            String s;
            for(int i=0; i<100000; i++)
            {
                s = "Hello" +i;
            }
            System.out.println("Free memory after loop  : " + r.freeMemory());
            r.gc();
            System.out.println("Free memory after gc    : " + r.freeMemory());
            //5
            try {
                t.setEndBegin("begin van gnome-terminal");
                Process p = r.exec(new String[]{"gnome-terminal"});
                t.setEnd("gnome-calculator");

                ProcessBuilder pb = new ProcessBuilder("gnome-calculator");
                Process p2 = pb.start();
                t.setEnd();
                Thread.sleep(2000);
                //p.destroy();
                //p2.destroy();


                //6
                InputStream is = p.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);

                String line;
                while ( (line = br.readLine()) != null )
                {
                    System.out.println(line);
                }
                br.close();
                p.destroy();
                p2.destroy();
            }catch(Exception e){ System.out.println(e.toString());}
            


        } catch (Exception ex) {
            Logger.getLogger(MetingDemo.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("sleep was interrupted. run programma opnieuw");
        }
    }
}
