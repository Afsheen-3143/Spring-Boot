package com.batchprocessing.user.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BatchJobSchedular {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job userJob;

    @Scheduled(cron = "*/5 * * * * *")
    public void runJob() {

        System.out.println("Scheduler Triggered at: " + new java.util.Date());

        JobParameters params = new JobParametersBuilder()
                .addLong("time", System.currentTimeMillis())  // Unique parameter
                .toJobParameters();

        try {
            System.out.println("Running Batch Job...");
            jobLauncher.run(userJob, params);
            System.out.println("Batch Job Completed.\n");
        } catch (Exception e) {
            System.out.println("Error while running batch job:");
            e.printStackTrace();
        }
    }
}
