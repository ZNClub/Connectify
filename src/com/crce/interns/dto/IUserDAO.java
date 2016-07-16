package com.crce.interns.dto;

import java.util.List;
public interface IUserDAO {
    	public void findUsers();
   	public void insertUser(User e,Qualification q);
   	 public void findQualification();
       }