package com.accp.dao.lt;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.vo.lt.UserVo;
import com.accp.vo.lt.VipVo;

public interface IUserDao {
	
	
	public List<UserVo> queryUser(@Param("username")String username);
	
	public List<UserVo> queryShop(@Param("userName")String userName,@Param("shopName")String shopName,@Param("merchantType")String merchantType);
	
	public VipVo queryUserId(@Param("userid")int userid);
	
	public boolean updateVip(@Param("vo") VipVo vo);
	
	public boolean updateVip2(@Param("vo") VipVo vo);

}
