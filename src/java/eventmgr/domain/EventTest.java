/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eventmgr.domain;

import static java.lang.System.out;
import java.util.Calendar;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;
public class EventTest {
	/** save some events to database */
	public static void saveEvents( ) {
		Event event = new Event( );
		event.setName("Java Days");
		event.setStartDate(new java.util.Date(108,Calendar.JULY,1) );
		
		          Session session = HibernateUtil.openSession();
		          Transaction tx = session.beginTransaction();
		          Query query = session.createQuery(
				"from Location where name=:name");
		query.setParameter("name", "Kasetsart University");
		          List list = query.list();
		event.setLocation( (Location)list.get(0) );
		out.printf("Saving event: %s\nLocation: %s\n",
					event, event.getLocation() );
		session.save( event );
		tx.commit();
                session.close();
		out.println("Event saved");
	}
        public static void testUpdate( String name, Location newLoc ) {
		out.println("Updating "+name +"...");
		Session session = HibernateUtil.openSession( );
		Transaction tx = session.beginTransaction();
                Query query = session.createQuery("from Event where name=:name");
                query.setParameter( "name", name );
                List list = query.list();
                if ( list.size() == 0 ) out.println("Event not found");
                else
                {
                    Event e=new Event();
                    e.setLocation( newLoc );
                }
		tx.commit();
		session.close( );
	}
        public static void main(String[] args) {
		LocationTest.saveLocations( );
		saveEvents();
               // Location l=new
               // testUpdate("Java Days",);
		LocationTest.testRetrieve();
	}
}


