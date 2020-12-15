package domain;

import java.util.Date;

public class Plan {
    private int id;
    private int staff_id;
    private int plan_user_num;
    private int plan_profit;
    private Date plan_time;
    private String plan_stand;
    private String plan_mark;
    public void setId(int id) {
        this.id = id;
    }
    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }
    public void setPlan_user_num(int plan_user_num) {
        this.plan_user_num = plan_user_num;
    }
    public void setPlan_profit(int plan_profit) {
        this.plan_profit = plan_profit;
    }
    public void setPlan_time(Date plan_time) {
        this.plan_time = plan_time;
    }
    public void setPlan_stand(String plan_stand) {
        this.plan_stand = plan_stand;
    }
    public void setPlan_mark(String plan_mark) {
        this.plan_mark = plan_mark;
    }
    public int getId() {
        return id;
    }
    public int getStaff_id() {
        return staff_id;
    }
    public int getPlan_user_num() {
        return plan_user_num;
    }
    public int getPlan_profit() {
        return plan_profit;
    }
    public Date getPlan_time() {
        return plan_time;
    }
    public String getPlan_stand() {
        return plan_stand;
    }
    public String getPlan_mark() {
        return plan_mark;
    }

    public Plan() {
    }

    public Plan(int staff_id, int plan_user_num, int plan_profit, Date plan_time, String plan_stand, String plan_mark) {
        this.staff_id = staff_id;
        this.plan_user_num = plan_user_num;
        this.plan_profit = plan_profit;
        this.plan_time = plan_time;
        this.plan_stand = plan_stand;
        this.plan_mark = plan_mark;
    }

    @Override
    public String toString() {
        return "Plan{" +
                "id=" + id +
                ", staff_id=" + staff_id +
                ", plan_user_num=" + plan_user_num +
                ", plan_profit=" + plan_profit +
                ", plan_time=" + plan_time +
                ", plan_stand='" + plan_stand + '\'' +
                ", plan_mark='" + plan_mark + '\'' +
                '}';
    }
}
