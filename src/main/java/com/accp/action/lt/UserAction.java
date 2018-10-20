package com.accp.action.lt;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.biz.lt.UserBiz;
import com.accp.pojo.User;
import com.accp.vo.lt.AppraisalVo;
import com.accp.vo.lt.UserVo;
import com.accp.vo.lt.VipVo;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/lt")
public class UserAction {

	@Autowired
	private UserBiz biz;

	@GetMapping("getList")
	public String getUserList(Integer p, Integer s, Model model, String userName) {
		if (userName.equals("0")) {
			userName = null;
		}
		PageInfo<UserVo> pageInfo = biz.findUserListByPage(p, s, userName);

		model.addAttribute("PAGE_INFO", pageInfo);
		model.addAttribute("userName", userName);
		return "lt/Member-audit";
	}
	
	@GetMapping("getVipById")
	public String queryVip(int userID, Model model) {
		VipVo vip=biz.queryVipById(userID);
		model.addAttribute("data",vip);
		return "lt/Modification-audit";
	}
	
	@PostMapping("updateVip")
	public String updateVip(VipVo vo,Model model) {
		biz.updateVip(vo);
		return "redirect:/lt/getList?p=1&s=10&userName=0";
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
		
		PageInfo<UserVo> pageInfo = biz.queryShop(p, s, userName, shopName, merchantType);

		model.addAttribute("PAGE_INFO", pageInfo);
		model.addAttribute("userName", userName);
		model.addAttribute("shopName",shopName);
		model.addAttribute("merchantType",merchantType);
		return "lt/Merchant-management";
	}
	
	@GetMapping("getAppraisal")
	public String getAppraisal(Integer p, Integer s, Model model, String userName,String auditStatus) {
		if (userName.equals("0")||userName.equals("")) {
			userName = null;
		}
		if (auditStatus.equals("0")||auditStatus.equals("")) {
			auditStatus = null;
		}
		PageInfo<AppraisalVo> pageInfo = biz.queryAppra(p, s, userName, auditStatus);

		model.addAttribute("PAGE_INFO", pageInfo);
		model.addAttribute("userName", userName);
		model.addAttribute("auditStatus",auditStatus);
		return "lt/Appraisal-audit";
	}
	
	@GetMapping("queryAppByID")
	public String queryAppByID(int userID, Model model) {
		AppraisalVo appra=biz.qeuryAppByID(userID);
		model.addAttribute("data",appra);
		return "lt/Appraisal-application";
	}
	
	@PostMapping("updateAppra")
	public String updateAppra(AppraisalVo av,Model model) {
		biz.updateAppra(av);
		return "redirect:/lt/getAppraisal?p=1&s=10&userName=0&auditStatus=0";
	}
	
	@GetMapping("queryVipByID")
	public String queryVipByID(int userID,Model model) {
		User data=biz.queryVipByID(userID);
		model.addAttribute("data",data);
		return "lt/Merchant-modification";
	}
	
	@PostMapping("updateShopVip")
	public String updateShopVip(User u,Model model) {
		biz.updateShopVip(u);
		return "redirect:/lt/getShopList?p=1&s=10&userName=0&shopName=0&merchantType=0";
	}
	
	@PostMapping("delMoney")
	@ResponseBody
	public Map<String,String> delMoney(int money,int userID){
		Map<String,String> messg=new HashMap<String,String>();
		try {
			biz.delMoney(money, userID);
			messg.put("code", "200");
			messg.put("msg", "扣除成功");
		} catch (Exception e) {
			messg.put("code", "500");
		}
		return messg;
	}
	
	@GetMapping("getAllShop")
	public String getAllShop(Integer p, Integer s, Model model, String userName,String merchantType,String auditStatus) {
		if (userName.equals("0")||userName.equals("")) {
			userName = null;
		}
		if (auditStatus.equals("0")||auditStatus.equals("")) {
			auditStatus = null;
		}
		if (merchantType.equals("0")||merchantType.equals("")) {
			merchantType = null;
		}
		PageInfo<User> pageInfo = biz.queryAllShop(p, s, userName, merchantType, auditStatus);

		model.addAttribute("PAGE_INFO", pageInfo);
		model.addAttribute("userName", userName);
		model.addAttribute("merchantType", merchantType);
		model.addAttribute("auditStatus",auditStatus);
		return "lt/Merchants-move-in";
	}
	
	@GetMapping("queryShopUserByID")
	public String queryShopUserByID(int userID,Model model) {
		 User u=biz.queryShopUserByID(userID);
		 model.addAttribute("data",u);
		return "lt/Merchant-entry-modification";
	}
	
	@PostMapping("updateShopUser")
	public String updateShopUser(User u,Model model) {
		 biz.updateShopUser(u);
		return "redirect:/lt/getAllShop?p=1&s=10&userName=0&merchantType=0&auditStatus=0";
	}
}
