package com.dashboard.controller;

import com.dashboard.utill.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dashboard.beans.TrainerBean;
import com.dashboard.service.Trainer;
//import com.google.gson.Gson;
import com.dashboard.utill.*;



@Controller

public class controller1 
{
	@Autowired
	Trainer trainer;
	
	/*@RequestMapping(method=RequestMethod.GET)
	public String getvalues()
	{
		System.out.println("controller...");
		return "calendar";
	}
	*/
	@RequestMapping(value="/addEvent",method=RequestMethod.GET)
	public String addEvent(Model model,HttpServletRequest request)
	{
		System.out.println("addevent");
		TrainerBean trainerBean=new TrainerBean();
	//	ArrayList<TrainerBean> trainerBeans=new ArrayList<TrainerBean>();
		System.out.println("size..");
		//System.out.println(trainer.viewAllSchedule("111").size());
		//request.setAttribute("trainerbeans",trainer.viewAllSchedule("111"));
		model.addAttribute("addEvent",trainerBean);
		System.out.println("controller...");
		
		
		return "calendar1";
	}
	
	
	@RequestMapping(value = "/getVacation", method = RequestMethod.GET)
    public
    @ResponseBody
    String getVacation(HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
        ArrayList<TrainerBean> trainerBeans=new ArrayList<TrainerBean>();
		//sessionId
        int i=0;
		//trainerBeans=trainer.viewAllSchedule("111");
		
	//	for(TrainerBean t:trainerBeans){
		
		
       map.put("title", "fh");
//        map.put("start", "23/");
//       map.put("end", t.getEndDate());
        map.put("url", "http://yahoo.com/");
      // String json = new Gson().toJson(map);
        
	//	}
        // Convert to JSON string.
        

        // Write JSON string.
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
		return null;

     //   return json;
    }
	
	
	
	
	
	@RequestMapping(value="/addEvent1",method=RequestMethod.POST)
	public @ResponseBody String addEvent1(@ModelAttribute TrainerBean tb,HttpServletRequest request)
	{
		Date stdt1=new Date();
		Date edt1=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
		String stdt=request.getParameter("startDate");
		String edt=request.getParameter("endDate");
		try {
			stdt1=sdf.parse(stdt);
			edt1=sdf.parse(edt);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tb.setStartDate(new java.sql.Date(stdt1.getTime()));
		tb.setEndDate(new java.sql.Date(edt1.getTime()));
		tb.setSkillId(201);
		tb.setCourseId("3031");
		tb.setTrainerId("111");
		String event=(String) request.getParameter("eventName");
		System.out.println(event);
		tb.setTitle(event);
		System.out.println("aftersubmission");
		
		if(trainer.addEvent(tb).equalsIgnoreCase("success")){
		
		return "success";
		
		}
		else{
			
			return "fail";}
		}
	
	@RequestMapping(value="/topopulate",method=RequestMethod.POST)
	public @ResponseBody String getResponse(HttpServletRequest request,HttpServletResponse response) throws Exception{
		System.out.println("in ajax");
        String result = "";
        result = result  + "<script>";
        result = result  + "$(document).ready(function() {";
        result = result  + "$('#calendar').fullCalendar({";
        result = result  + "header: {";
        result = result  + "left: 'prev,next today',";
        result = result  + "center: 'title',";
        result = result  + "right: 'month,basicWeek,basicDay'";
        result = result  + "},";
        result = result  + "defaultDate: '2016-01-12',";
        result = result  + "editable: false,";
        result = result  + "eventLimit: true,";
        result = result  + "selectable: true,";
        
        result = result  + "events: [";
		Connection Conn = DBUtill.getDBConnection();
		PreparedStatement pre = Conn
				.prepareStatement("SELECT * FROM dd.db_trainer");
		ResultSet res = pre.executeQuery();
		while (res.next()) {
			
			result = result  + "{title:'"+res.getString(6)+"',start: '"+res.getDate(5)+"',end:'"+res.getDate(2)+"'},";
		}
		 result = result  + "]";
		 result = result  + "});";
	     result = result  + "});";
		result = result  + "</script> ";
		return result;
		
	}
	
	
	@RequestMapping(value="/calendar",method=RequestMethod.GET)
	public String calendar(Model model,HttpServletRequest request)
	{
	
		return "calendar";
	}
}
