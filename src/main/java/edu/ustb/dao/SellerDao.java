package edu.ustb.dao;

import edu.ustb.domain.Seller;

/**
 * SellerDao
 */
public interface SellerDao {
    /**
     * 根据sid查询商户
     * @param sid
     * @return
     */
    public Seller getSellerBySid(int sid);
    
}
