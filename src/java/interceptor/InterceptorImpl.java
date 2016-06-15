/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interceptor;

import java.io.Serializable;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 *
 * @author michael
 */

@Interceptor
@LoggerM
public class InterceptorImpl implements Serializable {

    private static final Logger LOG = Logger.getLogger(InterceptorImpl.class.getName());
    
     

//    @AroundConstruct
//    private void init(InvocationContext ic) throws Exception {
//        //logger.fine("Entering constructor");
//        try {
//            ic.proceed();
//        } finally {
//          //  logger.fine("Exiting constructor");
//        }
//    }

    @AroundInvoke
    public Object logMethod(InvocationContext ic) throws Exception {
        LOG.entering(ic.getTarget().toString(), ic.getMethod().getName());
        
        try {
            
            LOG.info("Entering method: "
            + ic.getMethod().getName() + " in class "
            + ic.getMethod().getDeclaringClass().getName());
            
            return ic.proceed();
        } finally {
            LOG.exiting(ic.getTarget().toString(), ic.getMethod().getName());
        }
    }

}
