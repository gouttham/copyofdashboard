package com.dashboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dashboard.beans.CredentialBean;
import com.dashboard.beans.ScheduleBean;
import com.dashboard.utill.DBUtill;

public class StudentDAOImpl implements StudentDAO {
	@Autowired
	SessionFactory sessionFactory;
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)

	@Override
	public String addSchedule(String studentId,ScheduleBean sb) {
		
		Connection Conn;
		try 
		{
			Conn = DBUtill.getDBConnection();
			String pId = studentId;
			System.out.println("before insertaion into the db........");
			System.out.println(sb.getCompletionStatus());
			System.out.println(sb.getCourseId());
			System.out.println(sb.getScheduleId());
			System.out.println(pId);
			Session session = sessionFactory.getCurrentSession();
			CredentialBean cb = (CredentialBean) session.get(CredentialBean.class, pId);
			System.out.println(cb.getPassword());
			System.out.println(cb.getpId());
			System.out.println(cb.getStatus());
			System.out.println(cb.getType());
			sb.setStudentId(cb);
			int scheduleId=(int) session.save(sb);

			if(scheduleId==0){
				return "failure";
			}
			else{
			return "Success";
			}
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "failure";

		
		

	}

}
