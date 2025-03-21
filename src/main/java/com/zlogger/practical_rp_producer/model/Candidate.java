package com.zlogger.practical_rp_producer.model;


import org.springframework.data.annotation.Id;


public class Candidate{


    @Id
    private Integer id;
    private String name;
    private String forname;
    private String email;
    private String jobTitle;
    private String jobDescription;

    /*
    *  TODO Add static factory method for further use
    * */
    public static Candidate populateCandidate(String name,String forename){

        return new Candidate(null,name,forename,null,null);
    };

    public Candidate(String name, String forname, String email, String jobTitle, String jobDescription) {

        this.name = name;
        this.forname = forname;
        this.email = email;
        this.jobTitle = jobTitle;
        this.jobDescription = jobDescription;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getForname() {
        return forname;
    }

    public void setForname(String forname) {
        this.forname = forname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    @Override
    public String toString() {
        return "Candidates{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", forname='" + forname + '\'' +
                ", email='" + email + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", jobDescription='" + jobDescription + '\'' +
                '}';
    }
}
