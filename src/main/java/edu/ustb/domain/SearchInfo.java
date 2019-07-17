package edu.ustb.domain;
/**
 *
 * @author xuwenrui
 * @version 0.1
 * @serial 搜索条件实体类：载入最小金额，最大金额，路线名称，路线介绍（可设置分别搜索id=1/2和模糊同时搜索id=3（在DAO中实现）
 *
 * */
public class SearchInfo {

    public SearchInfo() {
       // searchStatus = -1;
    }

    @Override
    public String toString() {
        return "SearchInfo{" +
                "routeName='" + routeName + '\'' +
                ", routeMinPrice=" + routeMinPrice +
                ", routeMaxPrice=" + routeMaxPrice +
                ", routeIntroduction='" + routeIntroduction + //'\'' +
               // ", searchStatus=" + searchStatus +
                '}';
    }

    public SearchInfo(String routeName, int routeMinPrice, int routeMaxPrice, String routeIntroduction) {
        this.routeName = routeName;
        this.routeMinPrice = routeMinPrice;
        this.routeMaxPrice = routeMaxPrice;
        this.routeIntroduction = routeIntroduction;
      //  this.searchStatus = searchStatus;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public Integer getRouteMinPrice() {
        return routeMinPrice;
    }

    public void setRouteMinPrice(int routeMinPrice) {
        this.routeMinPrice = routeMinPrice;
    }

    public Integer getRouteMaxPrice() {
        return routeMaxPrice;
    }

    public void setRouteMaxPrice(int routeMaxPrice) {
        this.routeMaxPrice = routeMaxPrice;
    }

    public String getRouteIntroduction() {
        return routeIntroduction;
    }

    public void setRouteIntroduction(String routeIntroduction) {
        this.routeIntroduction = routeIntroduction;
    }

    String routeName;
    Integer routeMinPrice;
    Integer routeMaxPrice;
    String routeIntroduction;
    //int searchStatus;

//    public int getSearchStatus() {
//        return searchStatus;
//    }
//
//    public void setSearchStatus(int searchStatus) {
//        this.searchStatus = searchStatus;
//    }
}
