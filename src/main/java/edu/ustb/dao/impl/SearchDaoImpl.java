package edu.ustb.dao.impl;

import edu.ustb.dao.SearchDao;
import edu.ustb.domain.Route;
import edu.ustb.domain.SearchInfo;
import edu.ustb.util.JDBCUtils;
import org.apache.commons.beanutils.BeanUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SearchDaoImpl implements SearchDao {

    private List paramList = new ArrayList();

    public List getParamList() {
        return paramList;
    }

//    public void setParamList(List paramList) {
//        this.paramList = paramList;
//    }

    /**
     * @param searchInfo(Constraints)
     * @return a middle function with no interface.
     * */
    String findWhere(SearchInfo searchInfo){
        String sql="";
        if (searchInfo.getRouteMinPrice()!=null){
            sql+=" and price >= ?";
            paramList.add(searchInfo.getRouteMinPrice()+"");

        }
        if(searchInfo.getRouteMaxPrice()!=null){
            sql+=" and price <= ?";
            paramList.add(searchInfo.getRouteMaxPrice()+"");
        }
        if (searchInfo.getRouteIntroduction()!=null&&searchInfo.getRouteName()!=null){
            sql+=" and (rname like ? or routeIntroduce like ? )";//TODO: MAY HAVE TO MODIFIED
            paramList.add("%"+searchInfo.getRouteName()+"%");
            paramList.add("%"+searchInfo.getRouteIntroduction()+"%");
        }else if(searchInfo.getRouteIntroduction()!=null){
            sql+="";
            paramList.add("%"+searchInfo.getRouteIntroduction()+"%");
        }else if(searchInfo.getRouteName()!=null){
            paramList.add("%"+searchInfo.getRouteName()+"%");
        }else{ }
        return sql;
    }//Add constraints


    public Route getByID(int rid) {
        String sql = "select * from tab_route where rid= ?";
        ResultSet rs = null;//EXE??
        List paramlist = new ArrayList();
        paramlist.add(rid);
        try {
            if(rs.next()){

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new Route();//TODO
    }

    public int findRowsAll(SearchInfo searchInfo) {
        return 0;
    }

    public List<Route> findByCondition(SearchInfo searchInfo) {
        List<Route> list = new ArrayList();
       // List paramList = new ArrayList();
        String sql = "select rname, routeIntroduce, price, rimage "+//"from tab_route left join tab_route_img"
                "form tab_route"
                //+ "on goods_type=type_id"
                +"where 1=1 ";
//TODO: CHECK WHETHER BIG_IMG and SMALL_IMG is Necessary?

        sql+=this.findWhere(searchInfo);
        ResultSet resultSet;
        //TODO:DBUTILS
        //TO EXECUTE
        return list;
    }
}
