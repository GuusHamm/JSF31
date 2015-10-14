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

                Thread.sleep(ball.getSpeed());
                
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
