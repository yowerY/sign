package self.sign.util;

import self.sign.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

/**
 * Created by yangwanhong on 2021/4/26.
 */
public class ShiroWebUtil {

    public ShiroWebUtil() {
    }

    public static User getCurrentUser() {
       Subject subject = SecurityUtils.getSubject();
       if(null == subject){
           return null;
       }

       return (User)subject.getPrincipal();
    }
}

