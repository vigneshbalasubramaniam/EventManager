/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eventmgr.domain;

/**
 *
 * @author vi391762
 */
import static java.lang.System.out;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;
public class LocationTest {
    private static SessionFactory factory = HibernateUtil.getSessionFactory();
	
	/** save some locations */
	public static void saveLocations() {
		          Session session = factory.openSession( );
		Location loc1 = new Location();
		loc1.setName("Kasetsart University");
		loc1.setAddress("Pahonyotin Rd, Bangkok");
		Location loc2 = new Location();
		loc2.setName("Mahidol University");
		loc2.setAddress("Salaya, Nakorn Pathom");

		out.println("Saving locations...");
		out.println( loc1 );
		out.println( loc2 );
		
		          Transaction tx = session.beginTransaction();
		session.save( loc1 );
		session.save( loc2 );
		tx.commit();
		session.close();	
		out.println("Locations saved");
	}
	/** retrieve some events from the database */
	public static void testRetrieve() {
		out.println("Retrieving locations...");
		Session session = factory.openSession();
		          Query query = session.createQuery("from Location");
		Transaction tx = session.beginTransaction();
		          List list = query.list( );
		// print the locations
		for( Object loc : list ) out.println( loc );
		tx.commit();
		session.close();
		out.println("Done retrieving");
	}
	
	public static void main(String[] args) {
		//testSave();
            saveLocations();
		testRetrieve();
		//testUpdate("Kasetsart University", "Kampaengsaen");
		testRetrieve();
	}


}
