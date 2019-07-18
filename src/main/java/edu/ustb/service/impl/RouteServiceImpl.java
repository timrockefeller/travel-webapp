package edu.ustb.service.impl;

import java.util.List;

import edu.ustb.dao.FavoriteDao;
import edu.ustb.dao.RouteDao;
import edu.ustb.dao.RouteImgDao;
import edu.ustb.dao.SellerDao;
import edu.ustb.dao.impl.FavoriteDaoImpl;
import edu.ustb.dao.impl.RouteDaoImpl;
import edu.ustb.dao.impl.RouteImgDaoImpl;
import edu.ustb.dao.impl.SellerDaoImpl;
import edu.ustb.domain.Route;
import edu.ustb.domain.RouteImg;
import edu.ustb.domain.Seller;
import edu.ustb.service.RouteService;
import edu.ustb.vo.PageBean;

/**
 * RouteServiceImpl
 */
public class RouteServiceImpl implements RouteService {
    private RouteDao routeDao = new RouteDaoImpl();
    private RouteImgDao routeImgDao = new RouteImgDaoImpl();
    private SellerDao sellerDao = new SellerDaoImpl();
    private FavoriteDao favoriteDao = new FavoriteDaoImpl();

    public Route getRouteByRid(int rid) {
        Route route = routeDao.getRouteByRid(rid);

        List<RouteImg> routeImgList = routeImgDao.getRouteImgByRid(route.getRid());
        route.setRouteImgList(routeImgList);

        Seller seller = sellerDao.getSellerBySid(route.getSid());
        route.setSeller(seller);

        int count = favoriteDao.findCountByRid(route.getRid());
        route.setCount(count);

        return route;
    }
    public PageBean<Route> pageQuery(int cid,int currentPage,int pageSize,String rname){
        PageBean<Route> pageBean = new PageBean<Route>();
        pageBean.setCurrentPage(currentPage);
        pageBean.setPageSize(pageSize);
        int total = routeDao.findTotalCount(cid, rname);
        pageBean.setTotalCount(total);

        int start = (currentPage - 1) * pageSize;
        List<Route> list = routeDao.findByPage(cid, start, pageSize, rname);
        pageBean.setList(list);

        int totalPage = total % pageSize == 0 ? total / pageSize : total / pageSize + 1;
        pageBean.setTotalPage(totalPage);

        return pageBean;
    }


}
