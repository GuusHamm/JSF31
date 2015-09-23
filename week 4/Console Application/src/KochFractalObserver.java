import calculate.Edge;

import java.util.Observable;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by linux on 23-9-15.
 */
public class KochFractalObserver implements Observer {

    public void update(Observable o, Object arg) {
        Edge e = (Edge)arg;
        System.out.print("" + e.X1 );
        System.out.print("-" + e.Y1);
        System.out.print("-" + e.X2);
        System.out.println("-" + e.Y2);
    }
}
