package ro.tuc.dsrl.ds.handson.assig.three.queue.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

import ro.tuc.dsrl.ds.handson.assig.three.producer.entities.DVD;

/**
 * @Author: Technical University of Cluj-Napoca, Romania
 *          Distributed Systems, http://dsrl.coned.utcluj.ro/
 * @Module: assignment-one-server
 * @Since: Sep 1, 2015
 * @Description:
 * 	Wrapper for a queue, which provides only 2 methods, put() and get()
 * 	to insert and retrieve elements from the queue (functions as push
 * 	and pop in a FIFO manner).
 *
 * 	Underlying queue is a BlockingQueue; this type of queue will block
 * 	and wait for elements on retrieve, if there are currently no elements
 * 	in the queue.
 */
public class Queue {
    private static Queue queueInstance;
    private BlockingQueue<DVD> queue;
    private BlockingQueue<DVD> clonedQueue;

    private Queue() {
        queue = new LinkedBlockingDeque<DVD>();
        clonedQueue = new LinkedBlockingDeque<DVD>();
    }

    public static Queue getInstance() {
        if (queueInstance==null) queueInstance=new Queue();
        return queueInstance;
    }

    public void put(DVD dvd) throws InterruptedException {
        queue.put(dvd);
        clonedQueue.put(dvd);
    }

    public DVD get() throws InterruptedException {
        return queue.take();
    }
    
    public DVD getFromClonedQueue() throws InterruptedException {
        return clonedQueue.take();
    }
}
