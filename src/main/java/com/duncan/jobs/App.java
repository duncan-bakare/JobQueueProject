package com.duncan.jobs;

import com.duncan.jobs.model.Job;
import com.duncan.jobs.service.JobService;

public class App {
    public static void main(String[] args) throws InterruptedException {
        JobService jobService = new JobService(2);

        jobService.submitJob(new Job("SendEmail", "Welcome email to user1"));
        jobService.submitJob(new Job("GenerateReport", "Monthly sales report"));
        jobService.submitJob(new Job("BackupDB", "Database backup task"));

        Thread.sleep(1500);
        jobService.getAllJobs().values().forEach(System.out::println);
    }
}
