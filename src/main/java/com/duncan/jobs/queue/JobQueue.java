package com.duncan.jobs.queue;

import com.duncan.jobs.model.Job;
import java.util.LinkedList;
import java.util.Queue;

public class JobQueue {
    private final Queue<Job> queue = new LinkedList<>();

    public synchronized void addJob(Job job) {
        queue.add(job);
        notifyAll();
    }

    public synchronized Job getNextJob() {
        while (queue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return null;
            }
        }
        return queue.poll();
    }

    public synchronized int getQueueSize() {
        return queue.size();
    }
}
