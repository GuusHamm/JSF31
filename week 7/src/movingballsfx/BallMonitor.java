package movingballsfx;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by xubuntu on 14-10-15.
 */
public class BallMonitor extends ReentrantLock{
    private Lock lock;
    private int readersActive = 0;
    private int writersActive = 0;
    private int readersWaiting = 0;
    private int writersWaiting = 0;

    private Condition readyToRead;
    private Condition readyToWrite;

    public BallMonitor(){
        lock = new ReentrantLock();

        readyToRead = lock.newCondition();
        readyToWrite = lock.newCondition();
    }
    public void enterReader(){
        lock.lock();
        try {
            while (writersActive > 0){
                readersWaiting++;
                readyToRead.await();

            }
            readersWaiting--;
            readersActive ++;

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    
    public void exitReader(){
        lock.lock();
        readersActive --;
        try {
            if ( readersActive == 0) {
                readyToWrite.signal();
            }
            if(writersActive==0)
            {
                readyToRead.signalAll();
            }
        }
        finally {
            lock.unlock();
        }

    }

    public void enterWriter(){
        lock.lock();
        try {
            while (writersActive > 0 || readersActive > 0){
                writersWaiting ++;
                readyToWrite.await();
                writersWaiting --;
            }
            writersActive++;

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void exitWriter() {
        lock.lock();
        try {
            writersActive--;
            if(writersWaiting > 0){
                readyToWrite.signal();
            }
            else {
                readyToRead.signalAll();
            }
        }
        finally {
            lock.unlock();
        }
    }


}
