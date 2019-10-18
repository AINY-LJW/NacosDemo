package com.comment.bean;

import java.util.Date;

public class Comment {
    private String id;

    private String reviewerid;

    private String asin;

    private String reviewername;

    private String helpful;

    private String reviewtext;

    private String overall;

    private String summary;

    private Date unixreviewtime;

    private Date reviewtime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getReviewerid() {
        return reviewerid;
    }

    public void setReviewerid(String reviewerid) {
        this.reviewerid = reviewerid == null ? null : reviewerid.trim();
    }

    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin == null ? null : asin.trim();
    }

    public String getReviewername() {
        return reviewername;
    }

    public void setReviewername(String reviewername) {
        this.reviewername = reviewername == null ? null : reviewername.trim();
    }

    public String getHelpful() {
        return helpful;
    }

    public void setHelpful(String helpful) {
        this.helpful = helpful == null ? null : helpful.trim();
    }

    public String getReviewtext() {
        return reviewtext;
    }

    public void setReviewtext(String reviewtext) {
        this.reviewtext = reviewtext == null ? null : reviewtext.trim();
    }

    public String getOverall() {
        return overall;
    }

    public void setOverall(String overall) {
        this.overall = overall == null ? null : overall.trim();
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public Date getUnixreviewtime() {
        return unixreviewtime;
    }

    public void setUnixreviewtime(Date unixreviewtime) {
        this.unixreviewtime = unixreviewtime;
    }

    public Date getReviewtime() {
        return reviewtime;
    }

    public void setReviewtime(Date reviewtime) {
        this.reviewtime = reviewtime;
    }
}