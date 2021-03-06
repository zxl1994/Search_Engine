package com.zxl.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.zxl.dao.SearchDAO;
import com.zxl.dao.DAO;
import com.zxl.javaBean.UrlData;

public class SearchDAOJdbcImpl extends DAO<UrlData> implements SearchDAO {


	@Override
	public void save(UrlData urlData) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO Search_Engine_Test_ZXL(URL,HTML,TYPE,URLList,TIME) VALUES (?,?,?,?,?)";
		update(sql, urlData.getUrl(),urlData.getHtml(),urlData.getSource(),urlData.getUrl_link(),new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
	}
	
	@Override
	public void save(UrlData urlData,String table) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO "+table +"(URL,HTML,TYPE,URLList,TIME) VALUES (?,?,?,?,?)";
		update(sql, urlData.getUrl(),urlData.getHtml(),urlData.getSource(),urlData.getUrl_link(),new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
	}
	
	/**
	 * 加入新闻title
	 * @param urlData
	 * @param table
	 */
	public void save1(UrlData urlData,String table) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO "+table +"(URL,HTML,TITLE,TYPE,URLList,TIME) VALUES (?,?,?,?,?,?)";
		update(sql, urlData.getUrl(),urlData.getHtml(),urlData.getTitle(),urlData.getSource(),urlData.getUrl_link(),new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
	}
	
	/**
	 * 提取网页类型
	 */
	public void update1(String url,String classified,String table) {
		// TODO Auto-generated method stub
		String sql = "UPDATE "+table +" SET CLASSIFIED=? WHERE URL=?";
		update(sql,classified,url);
	}

	@Override
	public List<UrlData> getAll() {
		return getForList("SELECT URL,HTML,TITLE,RANK FROM Search_Engine_Test_ZXL_2");
	}


}
