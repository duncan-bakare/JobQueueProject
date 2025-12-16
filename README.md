
# JobQueueProject

**A Java-based job processing system demonstrating concurrency, priority queues, and robust backend design.**

---

## Overview

This project simulates a backend job-processing system where tasks are submitted to a queue and processed asynchronously by multiple worker threads. High-priority tasks are handled first, and failed tasks can automatically retry. It demonstrates core backend skills like concurrency, object-oriented design, and queue management.

---

## Features

- Asynchronous job processing with multiple worker threads  
- Thread-safe **priority queue** (HIGH > MEDIUM > LOW)  
- **Job state tracking**: `CREATED`, `PROCESSING`, `COMPLETED`, `FAILED`  
- **Retry logic**: failed jobs are retried automatically up to a configurable limit  
- Job result storage after processing  
- Fully implemented in **pure Java** (no external libraries required)  
- Easy to extend: scheduled jobs, multiple queues, REST API integration  

---

## Project Structure

```

JobQueueProject/
├─ src/main/java/com/duncan/jobs/model/   # Job, JobStatus, JobPriority classes
├─ src/main/java/com/duncan/jobs/queue/   # JobQueue class (priority queue)
├─ src/main/java/com/duncan/jobs/worker/  # JobWorker class (concurrent workers + retries)
├─ src/main/java/com/duncan/jobs/service/ # JobService class
├─ src/main/java/com/duncan/jobs/App.java # Main demo class
└─ src/test/java/com/duncan/jobs/         # Optional test classes

````

---

## How to Run

### 1. Compile all Java files

```bash
# Navigate to project root
cd JobQueueProject

# Compile all Java files into 'out' directory
find src/main/java -name "*.java" > sources.txt
javac -d out @sources.txt
````

### 2. Run the demo

```bash
java -cp out com.duncan.jobs.App
```

**Expected Output Example:**

```
Submitted job: <UUID>, priority=HIGH
Submitted job: <UUID>, priority=MEDIUM
Submitted job: <UUID>, priority=LOW
[Worker-1] started job: <UUID> (UrgentCacheClear), priority=HIGH, attempt=1
[Worker-2] started job: <UUID> (SendEmail), priority=MEDIUM, attempt=1
[Worker-3] started job: <UUID> (CleanupTask), priority=LOW, attempt=1
[Worker-1] completed job: <UUID>
[Worker-2] completed job: <UUID>
[Worker-3] completed job: <UUID>
All jobs:
Job{id='...', name='UrgentCacheClear', payload='Clear cache for critical service', status=COMPLETED, priority=HIGH, attempt=1, result='Processed: Clear cache for critical service'}
```

---

## Example Usage

```java
JobService jobService = new JobService(3, 3); // 3 workers, 3 max retries

jobService.submitJob(new Job("SendEmail", "Welcome email to user1", JobPriority.MEDIUM));
jobService.submitJob(new Job("GenerateReport", "Monthly sales report", JobPriority.LOW));
jobService.submitJob(new Job("UrgentCacheClear", "Clear cache for critical service", JobPriority.HIGH));

// Check job statuses
jobService.getAllJobs().values().forEach(System.out::println);

// Shutdown service after work is done
jobService.shutdown();
```

---

## Stretch Goals / Future Improvements

* Scheduled or delayed jobs
* Multiple queues with worker pools
* Integration with a REST API to submit and query jobs
* Metrics tracking: throughput, retries, failures, average processing time
* Persisting job results to a database

---

## Tools Used

* Java 17+
* Google Cloud Shell

---

## What I Learned / Why This Is Cool

This project taught me how to handle multiple tasks simultaneously using Java threads and priority queues, manage job states, and implement retry logic for robustness. It’s a small-scale version of real backend systems used in large tech companies to process tasks efficiently and reliably. Working on this project strengthened my skills in concurrency, object-oriented design, and system thinking—core skills for backend engineering roles.

---

## Author

Duncan Bakare

---

## GitHub

[https://github.com/duncan-bakare/JobQueueProject](https://github.com/duncan-bakare/JobQueueProject)

**Showcases:** backend engineering fundamentals, concurrency, object-oriented design, priority queues, and retry logic.

````
````
uiters evaluating Java backend skills.
