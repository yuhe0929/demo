import java.util.Date;
import java.util.List;

/**
 * Created by yuhea on 15:14 2017/10/10
 */
public class ComfortLevelRequestModel {
    private String userName;
    private String password;
    private String clientId;
    private String requestGuid;
    private String DCity;
    private String ACity;
    private Date startDate;
    private Date endDate;
    private List<String> flightNos;
    private List<String> subClassList;
    /**
     * param: 0:返回航班和舱等所有舒适度,1:只返回航班舒适度
     */
    private int searchType;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getRequestGuid() {
        return requestGuid;
    }

    public void setRequestGuid(String requestGuid) {
        this.requestGuid = requestGuid;
    }

    public String getDCity() {
        return DCity;
    }

    public void setDCity(String DCity) {
        this.DCity = DCity;
    }

    public String getACity() {
        return ACity;
    }

    public void setACity(String ACity) {
        this.ACity = ACity;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<String> getFlightNos() {
        return flightNos;
    }

    public void setFlightNos(List<String> flightNos) {
        this.flightNos = flightNos;
    }

    public List<String> getSubClassList() {
        return subClassList;
    }

    public void setSubClassList(List<String> subClassList) {
        this.subClassList = subClassList;
    }

    public int getSearchType() {
        return searchType;
    }

    public void setSearchType(int searchType) {
        this.searchType = searchType;
    }
}
