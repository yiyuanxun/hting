package com.accp.action.lt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.accp.biz.lt.UserBiz;
import com.accp.vo.lt.UserVo;
import com.accp.vo.lt.VipVo;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/lt")
public class UserAction {

	@Autowired
	private UserBiz biz;

	@GetMapping("getList")
	public String getUserList(Integer p, Integer s, Model model, String username) {
		if (username.equals("0")||username=="") {
			username = null;
		}
		PageInfo<UserVo> pageInfo = biz.findUserListByPage(p, s, username);
		model.addAttribute("PAGE_INFO", pageInfo);
		model.addAttribute("username", username);
		return "lt/Member-audit";
	}
	
	
	@GetMapping("getuserid")
	public String getUserList(Model model,int userid) {
		 biz.queryUserid(userid);
		model.addAttribute("data",biz.queryUserid(userid));
		return "lt/Modification-audit";
	}
	
	
	@PostMapping("updateVip")
	public String updateVipVo(Model model,VipVo vo) {
		biz.updateVipVo(vo);
		biz.updateVipVo2(vo);
		return "redirect:/lt/getList?p=1&s=2&username=0";
	}
	
	
	@GetMapping("getuserid1")
	public String getuserid1(Model model,VipVo vo) {		
		return "lt/Merchant-modification";
	}
	
	@GetMapping("getShopList")
	public String getUserList(Integer p, Integer s, Model model, String userName,String shopName,String merchantType) {
		if (userName.equals("0")||userName.equals("")) {
			userName = null;
		}
		if (shopName.equals("0")||shopName.equals("")) {
			shopName = null;
		}
		if (merchantType.equals("0")||merchantType.equals("")) {
			merchantType = null;
		}
		
		PageInfo<UserVo> pageInfo = biz.findShopListByPage(p, s, userName, shopName, merchantType);
		model.addAttribute("PAGE_INFO", pageInfo);
		model.addAttribute("userName", userName);
		model.addAttribute("shopName",shopName);
		model.addAttribute("merchantType",merchantType);
		return "lt/Merchant-management";
	}
	
	@GetMapping("getjd")
	public String getjd(Model model,VipVo vo) {		
		return "lt/Appraisal-application.html";
	}
	
	@GetMapping("gettx")
	public String gettx(Model model,VipVo vo) {		
		return "lt/Cash-management";
	}

}