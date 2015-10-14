/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package movingballsfx;

import javafx.scene.paint.Color;

/**
 *
 * @author Peter Boots
 */
public class BallRunnable implements Runnable {

    private Ball ball;
    private BallMonitor ballMonitor;
    private boolean isInterrupted=false;
    private int minX = 100;
    private int maxX = 700;
    private int maxY = 400;
    private int radius = 10;
    private int minCsX = (maxX + minX) / 2 - 100;
    private int maxCsX = (maxX + minX) / 2 + 100;

    public void setIsInterrupted(boolean isInterrupted) {
        this.isInterrupted = isInterrupted;
    }

    public BallRunnable(Ball ball,BallMonitor ballMonitor) {
        this.ball = ball;
        this.ballMonitor = ballMonitor;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                ball.move();

                if (ball.isEnteringCs()) {
                    if (ball.getColor() == Color.RED){
                        ballMonitor.enterReader();
                    }
                    else {
                        ballMonitor.enterWriter();
                    }
                }
                if (ball.isLeavingCs()){
                    if (ball.getColor() == Color.RED){
                        ballMonitor.exitReader();
                    }
                    else {
                        ballMonitor.exitWriter();
                    }
                }
                if(isInterrupted) {
                    if (ball.getXPos()>= minCsX && ball.getXPos()<=maxCsX) {

                        if (ball.getColor() == Color.RED){
                            ballMonitor.exitReader();
                        }
                        else {
                            ballMonitor.exitWriter();
                        }
                    }
                    break;
                }
                Thread.sleep(ball.getSpeed());
                
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }

    }

}
