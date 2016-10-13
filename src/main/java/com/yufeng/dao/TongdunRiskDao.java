package com.yufeng.dao;

import java.util.List;

import com.yufeng.entity.TongdunRiskReport;

/**
 * 风险dao层
 * @author dh
 */
public interface TongdunRiskDao {
    
    public int insertTongdunRiskReport(TongdunRiskReport tongdunRiskReport);
    
    public List<TongdunRiskReport> getTongdunRiskReportByInternalCode(String internalCode);

}
