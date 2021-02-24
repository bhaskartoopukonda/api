package com.idexcel.termloanservice.modules;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * @author Shivaraj.Budeppa
 *
 */
public class Userinformation {

@SerializedName("id")
@Expose
private Integer id;
@SerializedName("login")
@Expose
private String login;
@SerializedName("user_name")
@Expose
private String userName;
@SerializedName("email")
@Expose
private String email;
@SerializedName("role_id")
@Expose
private Integer roleId;
@SerializedName("role_name")
@Expose
private String roleName;
@SerializedName("role_type")
@Expose
private String roleType;
@SerializedName("theme")
@Expose
private Object theme;
@SerializedName("currency")
@Expose
private String currency;
@SerializedName("time_zone")
@Expose
private String timeZone;

public Integer getId() {
return id;
}

public void setId(Integer id) {
this.id = id;
}

public String getLogin() {
return login;
}

public void setLogin(String login) {
this.login = login;
}

public String getUserName() {
return userName;
}

public void setUserName(String userName) {
this.userName = userName;
}

public String getEmail() {
return email;
}

public void setEmail(String email) {
this.email = email;
}

public Integer getRoleId() {
return roleId;
}

public void setRoleId(Integer roleId) {
this.roleId = roleId;
}

public String getRoleName() {
return roleName;
}

public void setRoleName(String roleName) {
this.roleName = roleName;
}

public String getRoleType() {
return roleType;
}

public void setRoleType(String roleType) {
this.roleType = roleType;
}

public Object getTheme() {
return theme;
}

public void setTheme(Object theme) {
this.theme = theme;
}

public String getCurrency() {
return currency;
}

public void setCurrency(String currency) {
this.currency = currency;
}

public String getTimeZone() {
return timeZone;
}

public void setTimeZone(String timeZone) {
this.timeZone = timeZone;
}

}