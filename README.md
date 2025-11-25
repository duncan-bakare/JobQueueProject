# JobQueueProject

A simple **Java Job Queue** simulation demonstrating background task processing, concurrency, and object-oriented design. This project mimics a backend system where jobs are submitted to a queue and processed asynchronously by worker threads.

---

## Features

- **Asynchronous job processing** with multiple worker threads  
- **Thread-safe queue** using synchronized methods  
- **Job state tracking**: `CREATED`, `PROCESSING`, `COMPLETED`, `FAILED`  
- **Job result storage** after processing  
- Fully implemented in **pure Java** (no external libraries required)  
- Easy to extend with features like job priorities, scheduled jobs, and multiple queues  

---

## Project Structure

```

JobQueueProject/
├─ src/main/java/com/duncan/jobs/model/  # Job and JobStatus classes
├─ src/main/java/com/duncan/jobs/queue/  # JobQueue class
├─ src/main/java/com/duncan/jobs/worker/ # JobWorker class
├─ src/main/java/com/duncan/jobs/service/ # JobService class
├─ src/main/java/com/duncan/jobs/App.java # Main demo class
└─ src/test/java/com/duncan/jobs/        # Optional test classes

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

You should see output like:

```
Processing job: <UUID> - SendEmail
Processing job: <UUID> - GenerateReport
Completed job: <UUID>
Job{id='...', name='SendEmail', payload='Welcome email to user1', status=COMPLETED, result='Processed: Welcome email to user1'}
...
```

---

## Example Usage

```java
JobService jobService = new JobService(2);

jobService.submitJob(new Job("SendEmail", "Welcome email to user1"));
jobService.submitJob(new Job("GenerateReport", "Monthly sales report"));

// Check job statuses
jobService.getAllJobs().values().forEach(System.out::println);
```

---

## Stretch Goals / Future Improvements

* Add **job priority levels** (high, medium, low)
* Scheduled or delayed jobs
* Multiple queues with worker pools
* Integration with a **REST API** to submit and query jobs

---

## Tools used:

* Java 
* Google Cloud Shell

---

## Author

**Duncan Bakare**

* [GitHub](https://github.com/duncan-bakare)
* This project is a showcase of backend engineering fundamentals for potential recruiters.

```
Do you want me to do that next?
```
