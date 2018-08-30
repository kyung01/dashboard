package com.ctl.smartsignage.dao.jpa;

import java.util.List;

import javax.mail.Session;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;

import com.ctl.smartsignage.dao.UserDao;
import com.ctl.smartsignage.domain.User;

/**
 * @author Arun Kumar Tiwari
 */
public class UserDaoJpa extends BaseDaoJpa<User> implements UserDao {

    public UserDaoJpa() {
        super(User.class, "UserDao");
    }

	@Override
	public User getUserInfo(String strUName, String strUPass) {
		User tblUser=null;
		try
		{	
			Query query = getEntityManager().createQuery("SELECT tbl FROM User tbl where tbl.userName =:userName and tbl.password =:password ");
	        query.setParameter("userName",strUName);
	        query.setParameter("password",strUPass);
	        tblUser = (User)query.getSingleResult();
	        System.out.println("Success Login");
		}
		catch(Exception e)
		{
			//tblUser=new User();
			//e.printStackTrace();
			System.out.println(e);
		}
		return tblUser;
	}

	@Override
	public User getUserByName(String strUName) {
		User tblUser=null;
		try
		{
			Query query = getEntityManager().createQuery("SELECT tbu FROM User tbu where tbu.userName =:userName");
	        query.setParameter("userName",strUName);
	        //query.setParameter("isActive",true);
	        tblUser = (User)query.getSingleResult();
		}
		catch(Exception e)
		{
			//e.printStackTrace();
		}
		return tblUser;
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<User> listMembers(Integer lngUserId) {
		Query query = null;
		query = getEntityManager().createQuery("SELECT tbu FROM User tbu where tbu.teamId =:teamId and tbu.isActive =:isActive");
		query.setParameter("teamId",lngUserId);
		query.setParameter("enabled",true);
		return query.getResultList();
	}

	@Override
	public User getUserById(Integer lngUserId) {
		User tblUser=null;
		try
		{
			Query query = getEntityManager().createQuery("SELECT tbu FROM User tbu where tbu.id =:id and tbu.enabled =:enabled");
	        query.setParameter("id",lngUserId);
	        query.setParameter("enabled",true);
	        tblUser = (User)query.getSingleResult();
		}
		catch(Exception e)
		{
			//e.printStackTrace();
		}
		return tblUser;
	}

	@Override
	public User getUserByEmail(String destinationAddress, HttpSession session ) {
		User tblUser=null;
		try
		{	
			System.out.println("Before query for email check:======================= ");
			Query query = getEntityManager().createQuery("SELECT tbl FROM User tbl where tbl.email =:email");
	        query.setParameter("email",destinationAddress);
	        tblUser = (User)query.getSingleResult();
	        session.setAttribute("CheckEmail", "Check your email for username and password!");
	        System.out.println("email match ");
		}
		catch(Exception e)
		{	
			session.setAttribute("CheckEmail", "This email id donot exist!");
			e.printStackTrace();
			System.out.println(e);
		}
		return tblUser;
	}
}
