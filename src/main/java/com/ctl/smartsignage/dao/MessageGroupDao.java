package com.ctl.smartsignage.dao;

import java.util.List;

import com.ctl.smartsignage.domain.MessageGroup;



/**
 *  @author Shivansh Bhatnagar
 *	
 */
public interface MessageGroupDao {
	public Integer addGrp(MessageGroup msgGrp);	
	public boolean updateGrp(MessageGroup msgGrp);	
	public List<MessageGroup> getMsgGrps();
	public boolean deleteGrp(Integer grpID);
	public List<MessageGroup> getGroupsByClientId(int id);
	public MessageGroup getGroupsById(int id);
}
