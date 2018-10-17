package com.accp.biz.lt;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accp.dao.lt.IUserDao;
import com.accp.vo.lt.UserVo;
import com.accp.vo.lt.VipVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class UserBiz {
	
	@Autowired
	private IUserDao dao;

	public PageInfo<UserVo> findUserListByPage(Integer pageNum, Integer pageSize,String username) {
		PageHelper.startPage(pageNum, pageSize);
		return new PageInfo<UserVo>(dao.queryUser(username));
	}
	
	public PageInfo<UserVo> findShopListByPage(Integer pageNum, Integer pageSize,String userName,String shopName,String merchantType) {
		PageHelper.startPage(pageNum, pageSize);
		return new PageInfo<UserVo>(dao.queryShop(userName,shopName,merchantType));
	}
	
	public VipVo queryUserid(int userid) {
		return dao.queryUserId(userid);
	}
	
	public boolean updateVipVo(VipVo vo) {
		return dao.updateVip(vo);
	}
	
	public boolean updateVipVo2(VipVo vo) {
		return dao.updateVip2(vo);
	}
	
	
	
	

}
