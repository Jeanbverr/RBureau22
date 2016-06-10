package counter;

import javax.ejb.Singleton;
import javax.ejb.ConcurrencyManagement;
import static javax.ejb.ConcurrencyManagementType.CONTAINER;
import javax.ejb.Lock;
import javax.ejb.LockType;

/**
 * CounterBean is a simple singleton session bean that records the number
 * of hits to a web page.
 */
@Singleton
@ConcurrencyManagement(CONTAINER)
public class websiteVisits {
    private int hits = 1;

    // Increment and return the number of hits
    @Lock(LockType.WRITE)
    public int getHits() {
        return hits++;
    }
}