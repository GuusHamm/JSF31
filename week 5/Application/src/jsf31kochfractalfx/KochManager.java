package jsf31kochfractalfx;

import calculate.Edge;
import calculate.EdgeEnum;
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
    private KochFractal koch1;
    private KochFractal koch2;
    private KochFractal koch3;
    
    private ArrayList<Edge> edges = new ArrayList<>();
    private int count1=0;
    private int count2=0;
    private int count3=0;


    public KochManager(jsf31kochfractalfx.JSF31KochFractalFX application) {
        this.application = application;
        koch1 = new KochFractal(EdgeEnum.LeftEdge);
        koch2 = new KochFractal(EdgeEnum.BottomEdge);
        koch3 = new KochFractal(EdgeEnum.RightEdge);
    
        koch1.addObserver(this);
        koch2.addObserver(this);
        koch3.addObserver(this);
    }

    public void changeLevel(int nxt)
    {

        koch1.setLevel(nxt);
        koch2.setLevel(nxt);
        koch3.setLevel(nxt);
        edges.clear();
        TimeStamp time = new TimeStamp();
        time.setBegin();

        Thread t1 = new Thread(koch1);
        t1.start();
        Thread t2 = new Thread(koch2);
        t2.start();
        Thread t3 = new Thread(koch3);
        t3.start();
        try
        {
            while(t1.getState() != Thread.State.TERMINATED|| t2.getState() != Thread.State.TERMINATED|| t3.getState() != Thread.State.TERMINATED) {
            Thread.sleep(40);
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        time.setEnd();
        application.setTextCalc(time.toString().substring(20));

        drawEdges();
    }


    public void drawEdges() {


        application.clearKochPanel();
        TimeStamp time = new TimeStamp();
        time.setBegin();

        for(Edge e : edges)
        {
            application.drawEdge(e);
        }
        time.setEnd();

        application.setTextDraw(time.toString().substring(20));
        application.setTextNrEdges(edges.size() + "");
    }


    public void update(Observable o, Object arg) {

        application.drawEdge((Edge) arg);
        edges.add((Edge) arg);
    }
}
