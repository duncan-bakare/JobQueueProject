package com.duncan.jobs.service;

import com.duncan.jobs.model.Job;
import com.duncan.jobs.queue.JobQueue;
import com.duncan.jobs.worker.JobWorker;
import java.util.HashMap;
import java.util.Map;

public class JobService {
    private final JobQueue jobQueue;
    private final Map<String, Job> jobMap = new HashMap<>();

    public JobService(int workerCount) {
        this.jobQueue = new JobQueue();
        for (int i = 0; i < workerCount; i++) {
            Thread worker = new Thread(new JobWorker(jobQueue));
            worker.setDaemon(true);
            worker.start();
        }
    }

    public void submitJob(Job job) {
        jobMap.put(job.getId(), job);
        jobQueue.addJob(job);
    }

    public Job getJob(String jobId) {
        return jobMap.get(jobId);
    }

    public Map<String, Job> getAllJobs() {
        return jobMap;
    }
}
