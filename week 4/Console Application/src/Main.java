import calculate.KochFractal;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by linux on 23-9-15.
 */
public class Main {
    public static void main(String[] args){
        KochFractal kochFractal = new KochFractal();

        KochFractalObserver kochFractalObserver = new KochFractalObserver();
        kochFractal.addObserver(kochFractalObserver);

        kochFractal.setLevel(2);

        kochFractal.generateLeftEdge();
        kochFractal.generateBottomEdge();
        kochFractal.generateRightEdge();
        kochFractal.notifyObservers();





    }
}
