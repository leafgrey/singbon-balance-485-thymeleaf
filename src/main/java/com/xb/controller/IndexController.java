package com.xb.controller;
import com.alibaba.druid.support.json.JSONUtils;
import com.xb.services.HcConsumeClctGrpService;
import com.xb.utils.MySysStringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
/***
 * @class IndexController
 * @description TODO
 * @author zch
 * @date 2019/7/17
 * @version V0.0.1.201907171514.01
 * @function
 * @modfiyDate
 * @createDate
 * @package
 */
@Controller
public class IndexController {
	@Resource
	HcConsumeClctGrpService hcConsumeClctGrpService;
	/**
	 * 首页
	 */
	@RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
	public String index(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "index";
	}
	/**
	 * 图表
	 */
	@RequestMapping(value = "/echartStaticData", method = {RequestMethod.GET, RequestMethod.POST})
	public String welcome1(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "chart/echartStaticData";
	}
	/**
	 * 主信息页面
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @param model Model
	 * @return String
	 */
	@RequestMapping(value = "/welcome", method = {RequestMethod.GET, RequestMethod.POST})
	public String welcome(HttpServletRequest request, HttpServletResponse response, Model model) {
		//		for (String s : request.getParameterMap().keySet()) {
		//			System.out.println(s + ":" + request.getParameter(s));
		//		}
		String bgDate = request.getParameter("bgDate");
		String edDate = request.getParameter("edDate");
		String deptName = request.getParameter("deptName");
		if(StringUtils.isEmpty(bgDate)) {
			bgDate = MySysStringUtil.getMonthFirstDay();
		}
		if(StringUtils.isEmpty(edDate)) {
			edDate = MySysStringUtil.getMonthLastDay();
		}
		if(StringUtils.isEmpty(deptName)) {
			deptName = null;
		}
		List<Map<String, String>> deptDayTurnoverSummaryList = hcConsumeClctGrpService.selectDeptDayTurnoverSummary(bgDate, edDate, deptName);
		List<Map<String, String>> deptDayTurnoverList = hcConsumeClctGrpService.selectDeptDayTurnover(bgDate, edDate, deptName);
		List<Map<String, String>> maxMinBusinessVolumeList = hcConsumeClctGrpService.selectMaxMinBusinessVolume(bgDate, edDate, deptName);
		model.addAttribute("deptDayTurnoverList", deptDayTurnoverList);
		model.addAttribute("deptDayTurnoverSummaryList", deptDayTurnoverSummaryList);
		model.addAttribute("maxMinBusinessVolumeList", maxMinBusinessVolumeList);
		model.addAttribute("bgDate", bgDate);
		model.addAttribute("edDate", edDate);
		return "welcome/welcome";
	}
	/**
	 * 暂未使用 备份的welcome页面
	 */
	@RequestMapping(value = "/back/welcome", method = {RequestMethod.GET, RequestMethod.POST})
	public String backWelcome(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "back/welcome/welcome";
	}
	/**
	 * 暂未使用 memberList1
	 */
	@RequestMapping(value = "/memberList1", method = {RequestMethod.GET, RequestMethod.POST})
	public String memberList1(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "member/member-list1";
	}
}
