package compare.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 地区model
 *
 * @author yuhea
 * @date 17:21 2018/6/29
 */
public class AreaServiceModel {
    private String areaCode;
    private Integer areaType;
    private String areaName;
    private String imageUrl;
    List<CityServiceModel> cities;

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public Integer getAreaType() {
        return areaType;
    }

    public void setAreaType(Integer areaType) {
        this.areaType = areaType;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<CityServiceModel> getCities() {
        return cities;
    }

    public void setCities(List<CityServiceModel> cities) {
        this.cities = cities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AreaServiceModel model = (AreaServiceModel) o;
        return Objects.equals(areaCode, model.areaCode) &&
                Objects.equals(areaType, model.areaType) &&
                Objects.equals(areaName, model.areaName) &&
                Objects.equals(imageUrl, model.imageUrl) &&
                Objects.equals(cities, model.cities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(areaCode, areaType, areaName, imageUrl, cities);
    }
}
