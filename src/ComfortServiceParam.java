import java.util.List;

/**
 * Created by yuhea on 15:10 2017/10/10
 */
public class ComfortServiceParam {
    private boolean isInternational;
    private String memKey;
    private List<ComfortLevelRequestModel> soaRequest;
    private String flightNo;
    private String operatingFlightNumber;
    private String departCityCode;
    private String ArrivedCityCode;
    private String  departDateTime;
    private String cabinClass;
    private String equipmentCode;
    private String planeModelName;
    private int userLevel;
    private String CraftName;
    private int mealType;

    public boolean isInternational() {
        return isInternational;
    }

    public void setInternational(boolean international) {
        isInternational = international;
    }

    public String getMemKey() {
        return memKey;
    }

    public void setMemKey(String memKey) {
        this.memKey = memKey;
    }

    public List<ComfortLevelRequestModel> getSoaRequest() {
        return soaRequest;
    }

    public void setSoaRequest(List<ComfortLevelRequestModel> soaRequest) {
        this.soaRequest = soaRequest;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public String getOperatingFlightNumber() {
        return operatingFlightNumber;
    }

    public void setOperatingFlightNumber(String operatingFlightNumber) {
        this.operatingFlightNumber = operatingFlightNumber;
    }

    public String getDepartCityCode() {
        return departCityCode;
    }

    public void setDepartCityCode(String departCityCode) {
        this.departCityCode = departCityCode;
    }

    public String getArrivedCityCode() {
        return ArrivedCityCode;
    }

    public void setArrivedCityCode(String arrivedCityCode) {
        ArrivedCityCode = arrivedCityCode;
    }

    public String getDepartDateTime() {
        return departDateTime;
    }

    public void setDepartDateTime(String departDateTime) {
        this.departDateTime = departDateTime;
    }

    public String getCabinClass() {
        return cabinClass;
    }

    public void setCabinClass(String cabinClass) {
        this.cabinClass = cabinClass;
    }

    public String getEquipmentCode() {
        return equipmentCode;
    }

    public void setEquipmentCode(String equipmentCode) {
        this.equipmentCode = equipmentCode;
    }

    public String getPlaneModelName() {
        return planeModelName;
    }

    public void setPlaneModelName(String planeModelName) {
        this.planeModelName = planeModelName;
    }

    public int getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(int userLevel) {
        this.userLevel = userLevel;
    }

    public String getCraftName() {
        return CraftName;
    }

    public void setCraftName(String craftName) {
        CraftName = craftName;
    }

    public int getMealType() {
        return mealType;
    }

    public void setMealType(int mealType) {
        this.mealType = mealType;
    }
}
