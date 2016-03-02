package com.dashboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dashboard.beans.ScheduleBean;
import com.dashboard.utill.DBUtill;

public class StudentDAOImpl implements StudentDAO {
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public String addSchedule(ScheduleBean sb) {
		
		Connection Conn;
		try 
		{
			Conn = DBUtill.getDBConnection();
			System.out.println("before insertaion into the db........");
			System.out.println(sb.getCompletionStatus());
			System.out.println(sb.getCourseId());
			System.out.println(sb.getScheduleId());
			System.out.println(sb.getStudentId());
			
			PreparedStatement pre = Conn
					.prepareStatement("INSERT INTO dd.db_schedule ( scheduleId, completionStatus,courseId,studentId) VALUES (?,?,?,?);");
			pre.setInt(1, sb.getScheduleId());
			pre.setInt(2, sb.getCompletionStatus());
			pre.setInt(3, sb.getCourseId());
			pre.setString(4, sb.getStudentId());
			pre.execute();
			pre.close();
			Conn.close();
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Session s=sessionFactory.getCurrentSession();
		

		int scheduleId = (int) s.save(sb);
		if(scheduleId==0){
			return "failure";
		}
		else{
		return "Success";
		}
	}

}
