package com.ctl.smartsignage.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectRetrievalFailureException;

import com.ctl.smartsignage.domain.User;
/**
 *  @author Shivansh Bhatnagar
 *	
 */
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session openSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public User save(User entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User loadById(Long entityId) throws ObjectRetrievalFailureException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> loadAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(User entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getUserInfo(String strUName, String strUPass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByName(String strUName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserById(Integer lngUserId) {
		// TODO Auto-generated method stub
		User user = (User) openSession().load(
				User.class, lngUserId);
		return user;
	}

	@Override
	public List<User> listMembers(Integer lngUserId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByEmail(String destinationAddress, HttpSession session) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
