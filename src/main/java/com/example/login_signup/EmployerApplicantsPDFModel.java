package com.example.login_signup;

public class EmployerApplicantsPDFModel {
    public EmployerApplicantsPDFModel(String job_seeker_id, String job_seeker_name, String cv_file_name, String filename, String sendEmail) {
        this.job_seeker_id = Integer.valueOf(job_seeker_id);
        this.job_seeker_name = job_seeker_name;
        this.cv_file_name = cv_file_name;
        this.sendEmail = sendEmail;
    }

    public Integer getJob_seeker_id() {
        return job_seeker_id;
    }

    public void setJob_seeker_id(Integer job_seeker_id) {
        this.job_seeker_id = job_seeker_id;
    }

    public String getJob_seeker_name() {
        return job_seeker_name;
    }

    public void setJob_seeker_name(String job_seeker_name) {
        this.job_seeker_name = job_seeker_name;
    }

    public String getCv_file_name() {
        return cv_file_name;
    }

    public void setCv_file_name(String cv_file_name) {
        this.cv_file_name = cv_file_name;
    }

    Integer job_seeker_id;
    String job_seeker_name;
    String cv_file_name;

    public String getSendEmail() {
        return sendEmail;
    }

    public void setSendEmail(String sendEmail) {
        this.sendEmail = sendEmail;
    }

    String sendEmail;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    String filename;

}
