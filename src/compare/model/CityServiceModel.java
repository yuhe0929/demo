package compare.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;
import java.util.Objects;

/**
 * @author yuhea
 * @date 17:14 2018/6/29
 */
public class CityServiceModel {
    private String cityCode;
    private double latitude;
    private double longitude;
    @JsonIgnore
    private String cityImg;
    @JsonIgnore
    private String cityName;
    @JsonIgnore
    private List<HolidayModel> holidayInfoList;
    @JsonIgnore
    private List<ScenicModel> scenicInfoList;
    @JsonIgnore
    private List<TopicModel> topicModelList;

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @JsonIgnore
    public String getCityImg() {
        return cityImg;
    }

    @JsonIgnore
    public void setCityImg(String cityImg) {
        this.cityImg = cityImg;
    }

    @JsonIgnore
    public List<HolidayModel> getHolidayInfoList() {
        return holidayInfoList;
    }

    @JsonIgnore
    public void setHolidayInfoList(List<HolidayModel> holidayInfoList) {
        this.holidayInfoList = holidayInfoList;
    }

    @JsonIgnore
    public List<ScenicModel> getScenicInfoList() {
        return scenicInfoList;
    }

    @JsonIgnore
    public void setScenicInfoList(List<ScenicModel> scenicInfoList) {
        this.scenicInfoList = scenicInfoList;
    }

    @JsonIgnore
    public List<TopicModel> getTopicModelList() {
        return topicModelList;
    }

    @JsonIgnore
    public void setTopicModelList(List<TopicModel> topicModelList) {
        this.topicModelList = topicModelList;
    }

    @JsonIgnore
    public String getCityName() {
        return cityName;
    }

    @JsonIgnore
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CityServiceModel that = (CityServiceModel) o;
        return Double.compare(that.latitude, latitude) == 0 &&
                Double.compare(that.longitude, longitude) == 0 &&
                Objects.equals(cityCode, that.cityCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityCode, latitude, longitude);
    }
}
