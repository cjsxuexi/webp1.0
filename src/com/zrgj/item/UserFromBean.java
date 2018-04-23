package com.zrgj.item;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import com.zrgj.util.EmptyUtil;

public class UserFromBean {
	
	private String username;

	private String password;

	private String sex;

	private String birthday;

	private String[] hobby;

	private String education;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String[] getHobby() {
		return hobby;
	}

	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}
	
	// errorrsMap����ǰ�����е��û������ݵô�����Ϣ
	private Map<String, String> errorsMap = new HashMap<String, String>();

	public Map<String, String> getErrorsMap() {
		
		boolean result = true;

		// У���û���
		if (EmptyUtil.isEmpty(this.username)) {
			result = false;
			errorsMap.put("userNameError", "�û�������Ϊ��");
		}else{ 
		if (username.length()>5) {
			result = false;
			errorsMap.put("userNameError", "�û���̫��");
		}}

		// У������
		if (EmptyUtil.isEmpty(this.password)) {
			result = false;
			errorsMap.put("passwordError", "�û����벻��Ϊ��");
		} else {
			if (this.password.length() < 4) {
				result = false;
				errorsMap.put("passwordError", "�û�����̫��");
			}
		}
		
		// У���Ա�
		if (EmptyUtil.isEmpty(this.sex)) {
			result = false;
			errorsMap.put("sexError", "�û��Ա���Ϊ��");
		}

		// У������
		if (EmptyUtil.isEmpty(this.birthday)) {
			result = false;
			errorsMap.put("birthdayError", "�û����ղ���Ϊ��");
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				sdf.parse(birthday);
			} catch (ParseException e) {
				result = false;
				errorsMap.put("birthday", "���ո�ʽ����");
			}
		}
		
		
		return errorsMap;
	}
	
	
}
