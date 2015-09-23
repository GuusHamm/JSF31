import calculate.KochFractal;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by linux on 23-9-15.
 */
public class Main implements Observer{
    public static void main(String[] args){
        KochFractal kochFractal = new KochFractal();

        kochFractal.setLevel(1);

        kochFractal.generateLeftEdge();
        kochFractal.generateBottomEdge();
        kochFractal.generateRightEdge();




    }

    public void update(Observable o, Object arg) {

    }
}
