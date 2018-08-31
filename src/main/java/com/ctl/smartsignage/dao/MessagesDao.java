package com.ctl.smartsignage.dao;

import java.util.List;

import com.ctl.smartsignage.domain.Messages;


/**
 *  @author Shivansh Bhatnagar
 *	
 */
public interface MessagesDao {
	  public Integer addCounts(Messages messages);
	    public void updateMessages(Messages messages);
	    public List<Messages> getAllMessages();
	    public void deleteMessages(Integer messagesId);
//		public List<MessagesGroupsAndAccountsEntity> getMgsAndGrps();
//		
//		public boolean updateAccount_toll_msgs();
//	    public boolean addAccount_toll_message(account_toll_messagesEntity acct_toll_msg);
//	    public boolean updateAccount_toll_message(account_toll_messagesEntity acct_toll_msg);
//	    public List<account_toll_messagesEntity> getAccount_toll_message();
//	    public boolean deleteAccount_toll_message(Integer acct_toll_msg_Id);
//		public List<Messages> getAllMessagesByTollPlazas(
//				List<TollPlazasEntity> tollPlazasList);
//		public List<MessagesEntity> getAllMessagesByTollPlaza(Integer tollPlazaId);
//		public List<MessageGroupCustMappingEntity> getMsgGroupCustMappingById(Integer groupId);
//		public void addMsgGroupCustMapping(MessageGroupCustMappingEntity messageGroupCustMapping);
//		public List<MessageGroupCustMappingEntity> getAllMsgGroupCustMappingByGroupId(Integer Id);
//		public MessageGroupCustMappingEntity checkMsgGroupCustMapping(Integer groupId, Integer accountId);
//		public Msg_groupEntity findGroups(String groupName, Integer clientId);
//		public void updateMsgGroupCustMapping(MessageGroupCustMappingEntity messageGroupCustMapping);
		public void deleteMsgGroupCustMapping(Integer Id);
		public void deleteMsgGroupCustMappingByGroupId(Integer groupId);
		
		
}
