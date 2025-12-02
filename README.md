# JobQueueProject

A simple Java Job Queue simulation demonstrating background task processing, concurrency, job priorities, retries, and object-oriented design.  
This project mimics a backend system where jobs are submitted to a queue and processed asynchronously by multiple worker threads.

---

## Features

- Asynchronous job processing with multiple worker threads  
- Thread-safe **priority queue** (HIGH > MEDIUM > LOW) using `PriorityBlockingQueue`  
- **Job state tracking**: `CREATED`, `PROCESSING`, `COMPLETED`, `FAILED`  
- **Retry logic**: failed jobs are automatically retried up to a configurable maximum  
- Job result storage after processing  
- Fully implemented in **pure Java** (no external libraries required)  
- Easy to extend with scheduled jobs, multiple queues, or REST API integration  

---

## Project Structure

JobQueueProject/
├─ src/main/java/com/duncan/jobs/model/ # Job, JobStatus, JobPriority classes
├─ src/main/java/com/duncan/jobs/queue/ # JobQueue class (priority queue)
├─ src/main/java/com/duncan/jobs/worker/ # JobWorker class (concurrent workers + retries)
├─ src/main/java/com/duncan/jobs/service/ # JobService class
├─ src/main/java/com/duncan/jobs/App.java # Main demo class
└─ src/test/java/com/duncan/jobs/ # Optional test classes

yaml
Copy code

---

## How to Run

### 1. Compile all Java files

```bash
# Navigate to project root
cd JobQueueProject

# Compile all Java files into 'out' directory
find src/main/java -name "*.java" > sources.txt
javac -d out @sources.txt
2. Run the demo
bash
Copy code
java -cp out com.duncan.jobs.App
Expected Output Example:

csharp
Copy code
Submitted job: <UUID>, priority=HIGH
Submitted job: <UUID>, priority=MEDIUM
Submitted job: <UUID>, priority=LOW
[Worker-1] started job: <UUID> (UrgentCacheClear), priority=HIGH, attempt=1
[Worker-2] started job: <UUID> (SendEmail), priority=MEDIUM, attempt=1
[Worker-3] started job: <UUID> (CleanupTask), priority=LOW, attempt=1
[Worker-1] completed job: <UUID>
[Worker-2] completed job: <UUID>
[Worker-3] completed job: <UUID>
...
All jobs:
Job{id='...', name='UrgentCacheClear', payload='Clear cache for critical service', status=COMPLETED, priority=HIGH, attempt=1, result='Processed: Clear cache for critical service'}
...
Demo finished.
Example Usage
java
Copy code
JobService jobService = new JobService(3, 3); // 3 workers, 3 max retries

jobService.submitJob(new Job("SendEmail", "Welcome email to user1", JobPriority.MEDIUM));
jobService.submitJob(new Job("GenerateReport", "Monthly sales report", JobPriority.LOW));
jobService.submitJob(new Job("UrgentCacheClear", "Clear cache for critical service", JobPriority.HIGH));

// Check job statuses
jobService.getAllJobs().values().forEach(System.out::println);

// Shutdown service after work is done
jobService.shutdown();
Stretch Goals / Future Improvements
Scheduled or delayed jobs

Multiple queues with worker pools

Integration with a REST API to submit and query jobs

Metrics tracking: throughput, retries, failures, average processing time

Persisting job results to a database

Tools Used
Java 17+

## What I Learned / Why This Is Cool

This project taught me how to handle multiple tasks simultaneously using Java threads and priority queues, manage job states, and implement retry logic for robustness. It’s a small-scale version of real backend systems used in large tech companies to process tasks efficiently and reliably. Working on this project strengthened my skills in concurrency, object-oriented design, and system thinking—core skills for backend engineering roles.


Google Cloud Shell

Author
Duncan Bakare

GitHub
https://github.com/duncan-bakare/JobQueueProject

Showcases: backend engineering fundamentals, concurrency, object-oriented design, priority queues, and retry logic. Great for recruiters evaluating Java backend skills.
