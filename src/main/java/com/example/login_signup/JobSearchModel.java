package com.example.login_signup;

public class JobSearchModel {
    Integer job_postings_id, employer_id;
    String company_name, job_title, job_description, location, qualifications , posting_date;
    String salary_range;

    public Integer getJobPostID() {
        return jobPostID;
    }

    public void setJobPostID(Integer jobPostID) {
        this.jobPostID = jobPostID;
    }

    Integer jobPostID;

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    String employee_name;

    public JobSearchModel(Integer job_postings_id, Integer employer_id, String company_name, String job_title, String job_description, String location, String qualifications, String salary_range, String posting_date, String employee_name, String jobPostID) {
        this.job_postings_id = job_postings_id;
        this.employer_id = employer_id;
        this.company_name = company_name;
        this.job_title = job_title;
        this.job_description = job_description;
        this.location = location;
        this.qualifications = qualifications;
        this.salary_range = salary_range;
        this.posting_date = posting_date;
        this.employee_name = employee_name;
        this.jobPostID = Integer.valueOf(jobPostID);
    }

    public Integer getJob_postings_id() {
        return job_postings_id;
    }

    public Integer getEmployer_id() {
        return employer_id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public String getJob_title() {
        return job_title;
    }

    public String getJob_description() {
        return job_description;
    }

    public String getLocation() {
        return location;
    }

    public String getQualifications() {
        return qualifications;
    }

    public String getSalary_range() {
        return salary_range;
    }

    public String getPosting_date() {
        return posting_date;
    }

    public void setJob_postings_id(Integer job_postings_id) {
        this.job_postings_id = job_postings_id;
    }

    public void setEmployer_id(Integer employer_id) {
        this.employer_id = employer_id;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public void setJob_description(String job_description) {
        this.job_description = job_description;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

    public void setSalary_range(String salary_range) {
        this.salary_range = salary_range;
    }

    public void setPosting_date(String posting_date)
    {

        this.posting_date = posting_date;
    }


}
