package domain;

import java.time.LocalDateTime;
import java.util.Date;

public class Plan {
    private int id;
    private int staff_id;
    private int plan_profit;
    private LocalDateTime plan_time;
    private String plan_stand;
    private int plan_mark;
    public void setId(int id) {
        this.id = id;
    }
    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }
    public void setPlan_profit(int plan_profit) {
        this.plan_profit = plan_profit;
    }
    public void setPlan_time(LocalDateTime plan_time) {
        this.plan_time = plan_time;
    }
    public void setPlan_stand(String plan_stand) {
        this.plan_stand = plan_stand;
    }
    public void setPlan_mark(int plan_mark) {
        this.plan_mark = plan_mark;
    }
    public int getId() {
        return id;
    }
    public int getStaff_id() {
        return staff_id;
    }
    public int getPlan_profit() {
        return plan_profit;
    }
    public LocalDateTime getPlan_time() {
        return plan_time;
    }
    public String getPlan_stand() {
        return plan_stand;
    }
    public int getPlan_mark() {
        return plan_mark;
    }

    public Plan() {
    }

    public Plan(int id, int staff_id, int plan_profit, LocalDateTime plan_time, String plan_stand, int plan_mark) {
        this.id = id;
        this.staff_id = staff_id;
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
                ", plan_profit=" + plan_profit +
                ", plan_time=" + plan_time +
                ", plan_stand='" + plan_stand + '\'' +
                ", plan_mark='" + plan_mark + '\'' +
                '}';
    }
}
