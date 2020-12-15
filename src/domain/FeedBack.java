package domain;

import java.util.Date;

public class FeedBack {
    private int id;
    private String feedfack_name;
    private Date feedfack_time;
    private String feedback_content;
    private int feedback_shopid;
    private String feedback_isslove;
    public void setId(int id) {
        this.id = id;
    }
    public void setFeedfack_name(String feedfack_name) {
        this.feedfack_name = feedfack_name;
    }
    public void setFeedfack_time(Date feedfack_time) {
        this.feedfack_time = feedfack_time;
    }
    public void setFeedback_content(String feedback_content) {
        this.feedback_content = feedback_content;
    }
    public void setFeedback_shopid(int feedback_shopid) {
        this.feedback_shopid = feedback_shopid;
    }
    public void setFeedback_isslove(String feedback_isslove) {
        this.feedback_isslove = feedback_isslove;
    }
    public int getId() {
        return id;
    }
    public String getFeedfack_name() {
        return feedfack_name;
    }
    public Date getFeedfack_time() {
        return feedfack_time;
    }
    public String getFeedback_content() {
        return feedback_content;
    }
    public int getFeedback_shopid() {
        return feedback_shopid;
    }
    public String getFeedback_isslove() {
        return feedback_isslove;
    }

    public FeedBack(String feedfack_name, Date feedfack_time, String feedback_content, int feedback_shopid, String feedback_isslove) {
        this.feedfack_name = feedfack_name;
        this.feedfack_time = feedfack_time;
        this.feedback_content = feedback_content;
        this.feedback_shopid = feedback_shopid;
        this.feedback_isslove = feedback_isslove;
    }

    @Override
    public String toString() {
        return "FeedBack{" +
                "id=" + id +
                ", feedfack_name='" + feedfack_name + '\'' +
                ", feedfack_time=" + feedfack_time +
                ", feedback_content='" + feedback_content + '\'' +
                ", feedback_shopid=" + feedback_shopid +
                ", feedback_isslove='" + feedback_isslove + '\'' +
                '}';
    }

    public FeedBack() {
    }
}
