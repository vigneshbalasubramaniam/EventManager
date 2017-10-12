/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eventmgr.domain;

import static java.lang.System.out;
import java.util.Calendar;
import java.util.Iterator;
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
        public static void addSpeakers(String name,Speaker speaker)
        {
            out.println("Updating "+name +"..."+speaker.getName()+"...."+speaker.getTelephone());
		Session session = HibernateUtil.openSession( );
		Transaction tx = session.beginTransaction();
                Query query = session.createQuery("from Event where name=:name");
                query.setParameter( "name", name );
                List list = query.list();
                if ( list.size() == 0 ) out.println("Event not found");
                else
                {
                    Event e=(Event)list.get(0);
                    e.addSpeaker(speaker);
                }
		tx.commit();
		session.close( );
        }
        public static void testUpdate( String Eventname, Location newLoc ) {
		out.println("Updating "+Eventname +"...");
		Session session = HibernateUtil.openSession( );
		Transaction tx = session.beginTransaction();
                Query query = session.createQuery("from Event where name=:name");
                query.setParameter( "name", Eventname );
                List list = query.list();
                if ( list.size() == 0 ) out.println("Event not found");
                else
                {
                    Event e=(Event)list.get(0);
                    e.setLocation( newLoc);
                }
		tx.commit();
		session.close( );
	}
        public static void testRetrieve( ) {
	System.out.println("Retrieving events...");
	
	Session session = HibernateUtil.openSession( );
	Transaction tx = session.beginTransaction();
	Query query = session.createQuery( "from Event" );
	List<Event> list = (List<Event>)query.list( );
	tx.commit();session.close( );
	for(Event e : list ) {
		out.printf("%s on %tD\n", e.toString(), e.getStartDate() );
		out.printf("  Location: %s\n", e.getLocation() );
		out.print( "  Speakers:");
		for(Speaker s : e.getSpeakers() ) out.print(" "+s.getName() );
		out.println();
	}
	
}

        public static void main(String[] args) {
		//LocationTest.saveLocations( );
		//saveEvents();
             /*  Session session = HibernateUtil.openSession( );
		Transaction tx = session.beginTransaction();
                Query query = session.createQuery("from Location where address=:address");
                query.setParameter( "address","Rama IV Rd, Bangkok");
                List list = query.list();
                if(list.size()==0)System.out.println("not found");
                else
                    testUpdate("Java Days",(Location)list.get(0));
                tx.commit();
                session.close();
                LocationTest.testRetrieve();*/
           // addSpeakers("Java Days",new Speaker("vignesh","999999") );
            testRetrieve();
            
	}
}


