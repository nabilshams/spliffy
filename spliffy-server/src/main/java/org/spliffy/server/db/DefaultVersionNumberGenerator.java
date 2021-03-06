package org.spliffy.server.db;

import java.util.HashMap;
import java.util.Map;

/**
 * Just uses locking. Only useful for single server - will not work in a cluster!
 * 
 * And its syncronized, so will not scale well with a large number of transactions
 * 
 * Just a piece of crap, really...
 *
 * @author brad
 */
public class DefaultVersionNumberGenerator implements VersionNumberGenerator{

    private Map<Long,Long> mapOfCounters = new HashMap<>();
    
    @Override
    public synchronized long nextVersionNumber(Repository r) {
        Long l = mapOfCounters.get(r.getId());
        if( l == null ) {
            RepoVersion rv = r.latestVersion();
            if( rv != null ) {
                l = rv.getVersionNum();
            } else {
                l = 0l;
            }
        }
        l = l+1;
        mapOfCounters.put(r.getId(), l);
        return l;
    }

}
