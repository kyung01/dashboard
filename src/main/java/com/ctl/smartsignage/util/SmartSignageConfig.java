package com.ctl.smartsignage.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Component;
/**
 * @author Arun Kumar Tiwari
 */
@Component
public class SmartSignageConfig 
{
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	@Resource(name="myProperties")
	  private Properties myProperties;
	
	  @PostConstruct
	  public void init() {
	    // do whatever you need with properties
		  myProperties.getProperty("");
	  }
	  public SmartSignageData getData()
	  {
		  SmartSignageData mparkData = new SmartSignageData();
		  Date syncDatetime=null;
		  String strName = (myProperties.getProperty("ParkingLotName")!=null) ? myProperties.getProperty("ParkingLotName") : "N/A";
		  String strId = (myProperties.getProperty("ParkingLotId")!=null) ? myProperties.getProperty("ParkingLotId") : "0";
		  String strRelays = (myProperties.getProperty("Relays")!=null) ? myProperties.getProperty("Relays") : "0";
		  String strSyncDate = (myProperties.getProperty("SyncDate")!=null) ? myProperties.getProperty("SyncDate") : "0";
		  String strSyncWaitingTime = (myProperties.getProperty("SyncWaitingTime")!=null) ? myProperties.getProperty("SyncWaitingTime") : "0";
		  if(strSyncDate.trim().equalsIgnoreCase("0"))
		  {
			  syncDatetime=new Date();
		  }
		  else
		  {
			  try {
				syncDatetime=sdf.parse(strSyncDate);
				} catch (ParseException e) {
					syncDatetime=new Date();
					e.printStackTrace();
				}
		  }
		  mparkData.setParkingId(Long.parseLong(strId.trim()));
		  mparkData.setParkingName(strName);
		  mparkData.setRelays(Integer.parseInt(strRelays));
		  mparkData.setSyncDatetime(syncDatetime);
		  mparkData.setSyncWaitingTime(Long.parseLong(strSyncWaitingTime.trim()));
		  return mparkData;
	  }
	  
	  public boolean setSyncDateTime(String strDate)
	  {
		  boolean blnResult=false;
		  if(myProperties.getProperty("SyncDate")!=null)
		  {
			  myProperties.setProperty("SyncDate", strDate);
			  blnResult=true;
		  }
		  else
		  {
			  blnResult=false;
		  }
		  return blnResult;
	  }
}
