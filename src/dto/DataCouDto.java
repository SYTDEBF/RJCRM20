package dto;

public class DataCouDto {
   private String coufield;
   private Integer con;

   public String getCoufield() {
      return coufield;
   }

   public void setCoufield(String coufield) {
      this.coufield = coufield;
   }

   public Integer getCon() {
      return con;
   }

   public void setCon(Integer con) {
      this.con = con;
   }

   public DataCouDto(String coufield, Integer con) {
      this.coufield = coufield;
      this.con = con;
   }

   @Override
   public String toString() {
      return "DataCouDto{" +
              "coufield=" + coufield +
              ", con=" + con +
              '}';
   }

   public DataCouDto() {
   }
}
