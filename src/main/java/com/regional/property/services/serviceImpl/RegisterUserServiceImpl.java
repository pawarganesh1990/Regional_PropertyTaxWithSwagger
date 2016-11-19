package com.regional.property.services.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.regional.property.dao.RegisterUserDao;
import com.regional.property.model.RegUsers;
import com.regional.property.model.Role;
import com.regional.property.model.Status;
import com.regional.property.services.RegisterUserService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Service("registerUserSerivce")
@Transactional
public class RegisterUserServiceImpl implements RegisterUserService {
	static final Logger logger = Logger.getLogger(RegisterUserServiceImpl.class);
	private static final String EMAIL_PATTERN =
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
					+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static Pattern pattern;
	private static Matcher matcher;
	@Autowired
	private RegisterUserDao userDao;

	public RegisterUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(RegisterUserDao userDao) {
		this.userDao = userDao;
	}

	@Transactional
	@Override
	public RegUsers createUser(RegUsers user) throws Exception {

		return userDao.createUser(user);
	}

	@Override
	public RegUsers getUserById(long id)  throws Exception{
		return userDao.getUserById(id);
	}

	@Override
	public List<RegUsers> getUserList()  throws Exception{
		// TODO Auto-generated method stub
		return userDao.getUserList();
	}

	@Override
	public Status deleteUser(long id)  throws Exception{
		return userDao.deleteUser(id);

	}
	/**
	 * Validate hex with regular expression
	 *
	 * @param hex
	 *            hex for validation
	 * @return true valid hex, false invalid hex
	 */
	@Override
	public boolean validateEmailAddress(String emailAddress) throws Exception {
		pattern = Pattern.compile(EMAIL_PATTERN);
		matcher = pattern.matcher(emailAddress);
		return matcher.matches();
	}
	/*	public static boolean validateEmailAddress1(String emailAddress) throws Exception {

		pattern = Pattern.compile(EMAIL_PATTERN);
		matcher = pattern.matcher(emailAddress);
		return matcher.matches();
	}
	public static void main(String a[]) {
		try {
			System.out.println(validateEmailAddress1("mkyong@.com.my"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/

	
	@Override
	public List<Role> getRoleAssignedToUser(long userId) {
		// TODO Auto-generated method stub
		return userDao.getRoleAssignedToUser(userId);
	}

	@Override
	public boolean isUserValid(long userId) throws Exception {
		// TODO Auto-generated method stub
		return userDao.isUserValid(userId);
	}

}
