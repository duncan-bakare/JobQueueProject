package com.duncan.jobs.worker;

import com.duncan.jobs.model.Job;
import com.duncan.jobs.model.JobStatus;
import com.duncan.jobs.queue.JobQueue;

public class JobWorker implements Runnable {
    private final JobQueue jobQueue;

    public JobWorker(JobQueue jobQueue) {
        this.jobQueue = jobQueue;
    }

    @Override
    public void run() {
        while (true) {
            Job job = jobQueue.getNextJob();
            if (job == null) continue;

            job.setStatus(JobStatus.PROCESSING);
            System.out.println("Processing job: " + job.getId() + " - " + job.getName());

            try {
                Thread.sleep(1000);
                job.setResult("Processed: " + job.getPayload());
                job.setStatus(JobStatus.COMPLETED);
            } catch (InterruptedException e) {
                job.setStatus(JobStatus.FAILED);
                Thread.currentThread().interrupt();
            }

            System.out.println("Completed job: " + job.getId());
        }
    }
}
