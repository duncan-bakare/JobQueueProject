package com.duncan.jobs.model;

import java.util.UUID;
import java.util.UUID;
import com.duncan.jobs.model.JobPriority; 

public class Job {
    private final String id;
    private final String name;
    private final String payload;
    private JobStatus status;
    private String result;

    public Job(String name, String payload) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.payload = payload;
        this.status = JobStatus.CREATED;
        this.result = null;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getPayload() { return payload; }

    public synchronized JobStatus getStatus() { return status; }
    public synchronized void setStatus(JobStatus status) { this.status = status; }

    public synchronized String getResult() { return result; }
    public synchronized void setResult(String result) { this.result = result; }

    @Override
    public String toString() {
        return "Job{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", payload='" + payload + '\'' +
                ", status=" + status +
                ", result='" + result + '\'' +
                '}';
    }
}
