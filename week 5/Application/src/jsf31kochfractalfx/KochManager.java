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
    private int count =0;

    public KochManager(jsf31kochfractalfx.JSF31KochFractalFX application) {

        this.application = application;
        koch1 = new KochFractal(KochFractal.position.BOTTOM);
        koch2 = new KochFractal(KochFractal.position.LEFT);
        koch3 = new KochFractal(KochFractal.position.RIGHT);

        koch1.addObserver(this);
        koch2.addObserver(this);
        koch3.addObserver(this);

    }

    public void changeLevel(int nxt)
    {

        koch1.setLevel(nxt);
        koch2.setLevel(nxt);
        koch3.setLevel(nxt);
        count = 0;

        edges.clear();
        TimeStamp time = new TimeStamp();
        time.setBegin();

        Thread t1 = new Thread(koch1);
        Thread t2 = new Thread(koch2);
        Thread t3 = new Thread(koch3);

        t1.start();
        t2.start();
        t3.start();
        try
        {
            t1.join();
            t2.join();
            t3.join();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        time.setEnd();
        application.setTextCalc(time.toString().substring(20));

        application.requestDrawEdges();
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

        count++;
        //application.drawEdge((Edge) arg);
        addEdge((Edge) arg);
//        if(count>=3)
//        {
//            drawEdges();
//        }
    }
    public synchronized void addEdge(Edge e )
    {
        edges.add(e);
    }



}



