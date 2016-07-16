package com.crce.hibernate;
import com.crce.interns.dto.*;
import java.awt.Choice;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class UserTest {
    private static int choice;
    public static void main(String[] args) {
        UserDAOImpl userOperations = new UserDAOImpl();
        User e1 = new User();
        Qualification q1=new Qualification();
        do {
            System.out.println("1. Insert ");
            System.out.println("2. User Details");
            System.out.println("3.Details according to role id");
            System.out.println("4.Details about qualification of the user");
            System.out.println("5. Exit ");
            System.out.println("Enter your choice ");
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter username ");
                    Scanner sc3 = new Scanner(System.in);
                    String username = sc3.nextLine();
                    System.out.println("Enter password ");
                    Scanner sc5 = new Scanner(System.in);
                    String user_password = sc5.nextLine();
                 
                    System.out.println("Enter role id ");
                    Scanner sc4 = new Scanner(System.in);
                    String role_id = sc4.nextLine();
                     System.out.println("Enter the current state");
                    
                    Scanner sc2 = new Scanner(System.in);
                    String current_state = sc2.nextLine();
                    System.out.println("Enter the no of kts");
                    
                    Scanner sc7 = new Scanner(System.in);
                    String no_of_kts = sc2.nextLine();
                    System.out.println("Enter percentage");
                    
                    Scanner sc8 = new Scanner(System.in);
                    String percentage = sc2.nextLine();
                    System.out.println("Enter the gpa");
                    
                    Scanner sc9 = new Scanner(System.in);
                    String gpa = sc2.nextLine();
                    System.out.println("Enter the marks obtained");
                    
                    Scanner sc10 = new Scanner(System.in);
                    String marks_obtained = sc2.nextLine();
                    System.out.println("Enter the total marks ");
                    
                    Scanner sc11 = new Scanner(System.in);
                    String total_marks = sc2.nextLine();
                    
                    
                    
                    
                   
                    e1.setCurrent_state(current_state);
                    e1.setUsername(username);
                    e1.setRole_id(role_id);
                    e1.setUser_password(user_password);
                    
                    
                    q1.setUsername(username);
                    q1.setNo_of_kts(no_of_kts);
                    q1.setPercentage(percentage);
                    q1.setGpa(gpa);
                    q1.setMarks_obtained(marks_obtained);
                    q1.setTotal_marks(total_marks);
                    
                    userOperations.insertUser(e1,q1);
                    break;
                case 2:
                     userOperations.findUsers();
                    break;
                case 3:
                    System.out.println("Enter the role id");
                    
                    Scanner sc6 = new Scanner(System.in);
                    String role = sc6.nextLine();
                    
                	userOperations.findUP(role);
                	break;
                case 4:
                    userOperations.findQualification();
                   break;
              
            }
        } while (choice != 5);
    }
}