package jsf31kochfractalfx;

import calculate.Edge;
import calculate.KochFractal;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import timeutil.TimeStamp;

/**
 * Created by linux on 23-9-15.
 */
public class KochManager implements Observer {
    private jsf31kochfractalfx.JSF31KochFractalFX application;
    private KochFractal koch;
    private ArrayList<Edge> edges = new ArrayList<>();

    public KochManager(jsf31kochfractalfx.JSF31KochFractalFX application) {
        this.application = application;
        koch = new KochFractal();

        koch.addObserver(this);


    }

    public void changeLevel(int nxt) {
        koch.setLevel(nxt);
        drawEdges();
    }


    public void drawEdges() {
        TimeStamp time = new TimeStamp();
        time.setBegin();
        edges.clear();
        application.clearKochPanel();
        koch.generateLeftEdge();
        koch.generateBottomEdge();
        koch.generateRightEdge();
        for(Edge e : edges)
        {
            application.drawEdge(e);
        }
        time.setEnd();
        application.setTextCalc(time.toString().substring(20));
        application.setTextNrEdges(edges.size() + "");
    }


    public void update(Observable o, Object arg) {

        application.drawEdge((Edge) arg);
        edges.add((Edge) arg);
    }
}
