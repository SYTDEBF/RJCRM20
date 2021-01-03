package dto;

public class StaffAchievementDto {
    private Integer staffOrderCon;
    private Integer staffSalesVolume;

    public Integer getStaffOrderCon() {
        return staffOrderCon;
    }

    public void setStaffOrderCon(Integer staffOrderCon) {
        this.staffOrderCon = staffOrderCon;
    }

    public Integer getStaffSalesVolume() {
        return staffSalesVolume;
    }

    public void setStaffSalesVolume(Integer staffSalesVolume) {
        this.staffSalesVolume = staffSalesVolume;
    }

    public StaffAchievementDto() {
    }

    public StaffAchievementDto(Integer staffOrderCon, Integer staffSalesVolume) {
        this.staffOrderCon = staffOrderCon;
        this.staffSalesVolume = staffSalesVolume;
    }
}
