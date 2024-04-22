package com.example.day4cw2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class BarathsakiJob {
    @Id
    private int jobId;
    private String jobTitle;
    private int minSalary;
    private String jobDescription;
    private int maxSalary;
    public BarathsakiJob() {
    }
    public BarathsakiJob(int jobId, String jobTitle, int minSalary, String jobDescription, int maxSalary) {
        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.minSalary = minSalary;
        this.jobDescription = jobDescription;
        this.maxSalary = maxSalary;
    }
    public int getJobId() {
        return jobId;
    }
    public void setJobId(int jobId) {
        this.jobId = jobId;
    }
    public String getJobTitle() {
        return jobTitle;
    }
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
    public int getMinSalary() {
        return minSalary;
    }
    public void setMinSalary(int minSalary) {
        this.minSalary = minSalary;
    }
    public String getJobDescription() {
        return jobDescription;
    }
    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }
    public int getMaxSalary() {
        return maxSalary;
    }
    public void setMaxSalary(int maxSalary) {
        this.maxSalary = maxSalary;
    }
    
}
