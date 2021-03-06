package org.spliffy.server.web.sync;

import com.bradmcevoy.http.Auth;
import com.bradmcevoy.http.Request;
import com.bradmcevoy.http.Request.Method;
import com.bradmcevoy.http.Resource;
import java.util.Date;
import org.spliffy.server.web.SpliffySecurityManager;

/**
 * Base class for other hashing related resources
 *
 * @author brad
 */
public abstract class BaseResource implements Resource{

    protected final SpliffySecurityManager securityManager;

    public BaseResource(SpliffySecurityManager securityManager) {
        this.securityManager = securityManager;
    }
    
    

    @Override
    public String getUniqueId() {
        return getName(); // all our resources are immutable
    }

    @Override
    public Object authenticate(String user, String password) {
        return securityManager.authenticate(user, password);
    }

    @Override
    public boolean authorise(Request rqst, Method method, Auth auth) {
        return securityManager.authorise(rqst, method, auth, this);
    }

    @Override
    public String getRealm() {
        return securityManager.getRealm();
    }

    @Override
    public Date getModifiedDate() {
        return SpliffySyncResourceFactory.LONG_LONG_AGO;
    }

    @Override
    public String checkRedirect(Request rqst) {
        return null;
    }

}
