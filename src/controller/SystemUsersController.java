/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.ResultSet;
import model.BloodCategory;
import model.GenderCategory;
import model.MaritalStatus;
import model.SystemUser;
import model.UserGroup;


public class SystemUsersController extends SystemUser{
    private String sql;
    public SystemUsersController(){
        super();
    }
    public SystemUsersController(String user_id, String firstName, String lastName, GenderCategory gender, String email, 
            BloodCategory blood, String phone, int idNumber, String city, String state, String dob, MaritalStatus ms, String nationality,
            int departmentId, String designation, String speciality, char[] password,UserGroup ug,String user_Group){
        this.user_id = user_id;
        this.first_name = firstName;
        this.last_name = lastName;
        this.genderCategory = gender;
        this.email = email;
        this.bloodCategory = blood;
        this.phoneNumber = phone;
        this.id_number = idNumber;
        this.city = city;
        this.state = state;
        this.dateOfBirth = dob;
        this.maritalStatus = ms;
        this.nationality = nationality;
        this.password=password;
        this.user_Group=user_Group;
    }
    public boolean authenticate(String username, char []password){
        sql = "SELECT user_id, user_group, username, password FROM user_credentials WHERE username = ? AND password = PASSWORD(?)";
        try{
            connect();
            preparedstatement = connection.prepareStatement(sql);
            preparedstatement.setString(1, username);
            preparedstatement.setString(2, String.valueOf(password));
            
            results = preparedstatement.executeQuery();
            
              while(results.next()){
                userId = results.getString("user_id");
                user_Group = results.getString("user_group");
                username = results.getString("username");
                return true;
            }
            disconnect();
        }catch(Exception ex){
            ex.printStackTrace();
        }
      return false;
    }
    public ResultSet doctorsDepartments(){
        sql = "SELECT department_id, department_name FROM doctors_departments";
        try {
            connect();
            preparedstatement = connection.prepareStatement(sql);
            results = preparedstatement.executeQuery();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return results;
     }
    public void saveDoctor(){
        
    }
    public ResultSet find_doctors() throws Exception{
        sql = "SELECT * FROM `doctors`";
        connect();
        preparedstatement = connection.prepareStatement(sql);
        results = preparedstatement.executeQuery();
        return results;
    }
    public ResultSet find_doctors_by_id(String id){
        
        return null;
    }
    
}
