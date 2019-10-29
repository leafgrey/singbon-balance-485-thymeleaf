package com.xb.controller;
import com.xb.services.HcConsumeClctGrpService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	 *
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
	public String index(HttpServletRequest request, HttpServletResponse response, Model model) {
		System.out.println(request.getRequestURI());
		System.out.println(request.getRemoteUser());
		return "index";
	}
	/**
	 *
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/echartStaticData", method = {RequestMethod.GET, RequestMethod.POST})
	public String welcome1(HttpServletRequest request, HttpServletResponse response, Model model) {
		System.out.println(request.getRequestURI());
		System.out.println(request.getRemoteUser());
		return "chart/echartStaticData";
	}
	/**
	 * 主信息页面
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/welcome", method = {RequestMethod.GET, RequestMethod.POST})
	public String welcome(HttpServletRequest request, HttpServletResponse response, Model model) {
		List<Map<String, String>> deptDayTurnoverSummaryList = hcConsumeClctGrpService.selectDeptDayTurnoverSummary("2019-08-01 00:00:00", "2019-10-31 23:59:59");
		List<Map<String, String>> deptDayTurnoverList = hcConsumeClctGrpService.selectDeptDayTurnover("2019-08-01 00:00:00", "2019-10-31 23:59:59");

		model.addAttribute("deptDayTurnoverList", deptDayTurnoverList);
		model.addAttribute("deptDayTurnoverSummaryList", deptDayTurnoverSummaryList);
		return "welcome/welcome";
	}
	/**
	 *
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/back/welcome", method = {RequestMethod.GET, RequestMethod.POST})
	public String backWelcome(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "back/welcome/welcome";
	}
	/**
	 *
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/memberList1", method = {RequestMethod.GET, RequestMethod.POST})
	public String memberList1(HttpServletRequest request, HttpServletResponse response, Model model) {
		System.out.println(request.getRequestURI());
		System.out.println(request.getRemoteUser());
		return "/member/member-list1";
	}
}
