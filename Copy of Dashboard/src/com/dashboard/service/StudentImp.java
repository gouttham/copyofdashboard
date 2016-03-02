package com.dashboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dashboard.beans.ScheduleBean;
import com.dashboard.dao.StudentDAO;


@Service("studentService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class StudentImp implements Student {
	@Autowired
	StudentDAO studentDAO;
	
	@Override
	public String addEvent(ScheduleBean sb) {
		return studentDAO.addSchedule(sb);
	}

}
