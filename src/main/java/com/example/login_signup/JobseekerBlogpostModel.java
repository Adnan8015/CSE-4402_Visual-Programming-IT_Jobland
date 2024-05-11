package com.example.login_signup;

public class JobseekerBlogpostModel {
    public JobseekerBlogpostModel(String employeeName, String title, String content) {
        this.employeeName = employeeName;
        this.title = title;
        this.content = content;
    }


    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    String employeeName;
    String title;
    String content;


}
