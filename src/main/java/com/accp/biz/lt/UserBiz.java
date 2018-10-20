package com.accp.biz.lt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accp.dao.lt.IUserDao;
import com.accp.pojo.User;
import com.accp.vo.lt.AppraisalVo;
import com.accp.vo.lt.UserVo;
import com.accp.vo.lt.VipVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class UserBiz {

	@Autowired
	private IUserDao dao;

	public PageInfo<UserVo> findUserListByPage(Integer pageNum, Integer pageSize,String userNickName) {
		PageHelper.startPage(pageNum, pageSize);
		return new PageInfo<UserVo>(dao.queryUser(userNickName));
	}
	
	public PageInfo<UserVo> queryShop(Integer pageNum, Integer pageSize,String userName,String shopName,String merchantType) {
		PageHelper.startPage(pageNum, pageSize);
		return new PageInfo<UserVo>(dao.queryShop(userName, shopName, merchantType));
	}
	
	public VipVo queryVipById(int userID) {
		return dao.qeuryByUserId(userID);
	}
	
	public boolean updateVip(VipVo vo) {
		return dao.updateVip(vo);
	}
	
	public PageInfo<AppraisalVo> queryAppra(Integer pageNum, Integer pageSize,String userName,String auditStatus) {
		PageHelper.startPage(pageNum, pageSize);
		return new PageInfo<AppraisalVo>(dao.queryAppra(userName,auditStatus));
	}
	
	public AppraisalVo qeuryAppByID(int userID) {
		return dao.queryAppraByID(userID);
	}
	
	public boolean updateAppra(AppraisalVo av) {
		return dao.updateAppra(av);
	}
	
	public User queryVipByID(int userID) {
		return dao.queryVipByID(userID);
	}
	
	public boolean updateShopVip(User u) {
		return dao.updateShopVip(u);
	}
	
	public boolean delMoney(int money,int userID) {
		return dao.delMoney(money, userID);
	}
	
	public PageInfo<User> queryAllShop(Integer pageNum, Integer pageSize,String userName,String merchantType,String auditStatus) {
		PageHelper.startPage(pageNum, pageSize);
		return new PageInfo<User>(dao.queryAllShop(userName, auditStatus, merchantType));
	}
	
	public User queryShopUserByID(int userID) {
		return dao.queryShopUserByID(userID);
	}
	
	public boolean updateShopUser(User u) {
		return dao.updateShopUser(u);
	}
}
