/**
 * 
 */
package com.dblistener.oraclechangemonitor.notifications;

import com.dblistener.oraclechangemonitor.Monitor;

import oracle.jdbc.dcn.DatabaseChangeEvent;
import oracle.jdbc.dcn.DatabaseChangeListener;

/**
 * @author vamsiravi
 *
 */
public class DatabaseListener implements DatabaseChangeListener{


	  Monitor demo;
	  public DatabaseListener(Monitor dem)
	  {
	    demo = dem;
	  }
	  public void onDatabaseChangeNotification(DatabaseChangeEvent e)
	  {
	    Thread t = Thread.currentThread();
	    System.out.println("DatabaseListener: got an event ("+this+" running on thread "+t+")");
	    System.out.println(e.toString());
	    synchronized( demo ){ demo.notify();}
	  }


}
