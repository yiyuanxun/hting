package com.accp.dao.lt;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.pojo.User;
import com.accp.vo.lt.AppraisalVo;
import com.accp.vo.lt.UserVo;
import com.accp.vo.lt.VipVo;


public interface IUserDao {
	public List<UserVo> queryUser(@Param("userName")String userNickName);
	
	public VipVo qeuryByUserId(@Param("userid")int userID);
	
	public boolean updateVip(@Param("vo") VipVo vo);
	
	public List<UserVo> queryShop(@Param("userName")String userName,@Param("shopName")String shopName,@Param("merchantType")String merchantType);
	
	public List<AppraisalVo>queryAppra(@Param("userName")String userName,@Param("auditStatus")String auditStatus);
	
	public AppraisalVo queryAppraByID(@Param("userid")int userID);
	
	public boolean updateAppra(@Param("av")AppraisalVo av);
	
	public User queryVipByID(@Param("userid")int userID);
	
	public boolean updateShopVip(@Param("u")User u);
	
	public boolean delMoney(@Param("money")int money,@Param("userID")int userID) ;
	
	public List<User> queryAllShop(@Param("userName")String userName,@Param("auditStatus")String auditStatus,@Param("merchantType")String merchantType);
	
	public User queryShopUserByID(@Param("userID")int userID);
	
	public boolean updateShopUser(@Param("u")User u);
}
