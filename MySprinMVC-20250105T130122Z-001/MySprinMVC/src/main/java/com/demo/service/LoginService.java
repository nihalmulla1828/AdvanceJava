package com.demo.service;

import com.demo.beans.MyUser;

public interface LoginService {

	MyUser findUser(String unm, String passwd);

}
