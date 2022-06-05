package com.example.hellojsf;

import com.example.hellojsf.model.User;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class UserBean {
    /*
    private String name;
    private String surname;
    private int age;
     */
    private User user;
    private List<User> userList;

    /*
    public UserBean(){
        user = new User();
        userList = new ArrayList<>();
    }
     */

    @PostConstruct
    public void init(){
        user = new User();
        userList = new ArrayList<>();
    }

    public void addUser(){
        userList.add(user);
        user = new User();
    }

    public void clearUser(){
        user = new User();
    }

    public void editUser(){
        /*User editUser = new User();
        for(int i=0;i<userList.size();i++){
            if(userList.get(i).getId()== user.getId()){
                editUser = userList.get(i);
            }
        }*/
        /*User editUser = userList.stream()
                .filter(user1 -> user1.getId()==user.getId())
                .findFirst().get();
        userList.remove(editUser);
        userList.add(user);
         */
        user = new User();
    }

    public void selectForEdit(User editUser){
        user = editUser;
    }

    public void deleteUser(User deleteUser){
        userList.remove(deleteUser);
    }
    /*
    public void addUser2(){
        User user = new User();
        user.setAge(age);
        user.setName(name);
        user.setSurname(surname);
        userList.add(user);
        age =0;
        name="";
        surname="";
    }*/

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
