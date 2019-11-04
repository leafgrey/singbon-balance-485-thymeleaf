package com.xb.controller;
import com.alibaba.druid.support.json.JSONUtils;
import com.xb.services.HcConsumeClctGrpService;
import com.xb.utils.MySysStringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
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
		String bgDate = request.getParameter("bgDate");
		String edDate = request.getParameter("edDate");
		String deptName = request.getParameter("deptName");
		if(StringUtils.isEmpty(bgDate)) {
			bgDate = MySysStringUtil.getMonthFirstDay();
			bgDate = "2019-09-01 00:00:00";
		}
		if(StringUtils.isEmpty(edDate)) {
			edDate = MySysStringUtil.getMonthLastDay();
		}
		if(StringUtils.isEmpty(deptName)) {
			deptName = null;
		}
		// 月最大最小
		List<Map<String, String>> groupNameList = hcConsumeClctGrpService.selectGroupList(bgDate, edDate, deptName);
		for (Map<String, String> m : groupNameList) {
			m.put("groupname",m.get("groupname").trim().replace(" ",""));
			m.put("jianpin",MySysStringUtil.getJianPin(m.get("groupname")));

		}
		// 月最大最小
		List<Map<String, String>> maxMinBusinessVolumeList = hcConsumeClctGrpService.selectMaxMinBusinessVolume(bgDate, edDate, deptName);
		// 月统计
		List<Map<String, String>> deptDayTurnoverSummaryList = hcConsumeClctGrpService.selectDeptDayTurnoverSummary(bgDate, edDate, deptName);
		// 月明细
		List<Map<String, String>> deptDayTurnoverList = hcConsumeClctGrpService.selectDeptDayTurnover(bgDate, edDate, deptName);
		String deptDayTurnoverJsonStr = JSONUtils.toJSONString(deptDayTurnoverList);
		System.out.println("deptDayTurnoverJsonStr:" + deptDayTurnoverJsonStr);
		model.addAttribute("deptDayTurnoverList", deptDayTurnoverList);
		model.addAttribute("deptDayTurnoverSummaryList", deptDayTurnoverSummaryList);
		model.addAttribute("maxMinBusinessVolumeList", maxMinBusinessVolumeList);
		model.addAttribute("deptDayTurnoverJsonStr", deptDayTurnoverJsonStr);
		model.addAttribute("groupNameList", groupNameList);
		System.out.println(groupNameList);
		model.addAttribute("bgDate", bgDate);
		model.addAttribute("edDate", edDate);
		return "welcome/welcome";
	}
	@ResponseBody
	@RequestMapping(value = "/welcomeListJson", method = {RequestMethod.GET, RequestMethod.POST})
	public void welcomeListJson(HttpServletRequest request, HttpServletResponse response, Model model) {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("application/json,charset=UTF-8");
			String bgDate = request.getParameter("bgDate");
			String edDate = request.getParameter("edDate");
			String deptName = request.getParameter("deptName");
			if(StringUtils.isEmpty(bgDate)) {
				// bgDate = MySysStringUtil.getMonthFirstDay()
				bgDate = "2019-09-01 00:00:00";
			}
			if(StringUtils.isEmpty(edDate)) {
				edDate = MySysStringUtil.getMonthLastDay();
			}
			if(StringUtils.isEmpty(deptName)) {
				deptName = null;
			}
			System.out.println(bgDate);
			System.out.println(edDate);
			System.out.println(deptName);
			// 月明细
			List<Map<String, String>> deptDayTurnoverList = hcConsumeClctGrpService.selectDeptDayTurnover(bgDate, edDate, deptName);
			System.out.println("deptDayTurnoverList:" + deptDayTurnoverList);
			//			BigDecimal allFare = new BigDecimal(0);
			//			for (Map m:deptDayTurnoverList){
			//				allFare = allFare.add(new BigDecimal(m.get("AmountAllDay").toString()));
			//			}
			//			System.out.println(allFare);
			//			Map<String,String> allFaremap = new HashMap<>();
			//			allFaremap.put("groupname","汇总");
			//			allFaremap.put("ADate","");
			//			allFaremap.put("AmountAllDay",allFare.toString());
			//			deptDayTurnoverList.add(allFaremap);
			System.out.println("shuju:" + deptDayTurnoverList.size());
			String deptDayTurnoverJsonStr = JSONUtils.toJSONString(deptDayTurnoverList);
			try {
				PrintWriter p = response.getWriter();
				System.out.println("deptDayTurnoverJsonStr::::" + deptDayTurnoverJsonStr);
				p.print(deptDayTurnoverJsonStr);
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	@ResponseBody
	@RequestMapping(value = "/welcomeSummaryJson", method = {RequestMethod.GET, RequestMethod.POST})
	public void welcomeSummaryJson(HttpServletRequest request, HttpServletResponse response, Model model) {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("application/json,charset=UTF-8");
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
			// 月明细
			List<Map<String, String>> deptDayTurnoverSummaryList = hcConsumeClctGrpService.selectDeptDayTurnoverSummary(bgDate, edDate, deptName);
			System.out.println("shuju:" + deptDayTurnoverSummaryList.size());
			String deptDayTurnoverJsonStr = JSONUtils.toJSONString(deptDayTurnoverSummaryList);
			try {
				PrintWriter p = response.getWriter();
				System.out.println("deptDayTurnoverSummaryList::::" + deptDayTurnoverSummaryList);
				p.print(deptDayTurnoverJsonStr);
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	/* ----------------------------------------- */
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
