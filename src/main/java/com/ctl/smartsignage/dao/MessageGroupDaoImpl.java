package com.ctl.smartsignage.dao;

import java.util.List;

import javax.mail.event.MessageCountEvent;
import javax.mail.event.MessageCountListener;

import com.ctl.smartsignage.domain.MessageGroup;
/**
 *  @author Shivansh Bhatnagar
 *	
 */
public class MessageGroupDaoImpl implements MessageGroupDao, MessageCountListener {

	@Override
	public void messagesAdded(MessageCountEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void messagesRemoved(MessageCountEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public Integer addGrp(MessageGroup msgGrp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateGrp(MessageGroup msgGrp) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<MessageGroup> getMsgGrps() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteGrp(Integer grpID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<MessageGroup> getGroupsByClientId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MessageGroup getGroupsById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
