package self.sign.shiro;

import self.sign.entity.User;
import self.sign.services.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

/**
 * MyShiroRealm
 */
public class MyShiroRealm extends AuthorizingRealm{

    private static final Logger logger = LoggerFactory.getLogger(MyShiroRealm.class);
    private static final int expireMS = 1000 * 3600*4;

    @Autowired
    @Lazy
    private UserService ccodeService;

 
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
     
        String loginName = (String)super.getAvailablePrincipal(principalCollection); 
        //到数据库查是否有此对象
        User user=ccodeService.getUserByLoginName(loginName);
        
        if(user!=null){        
        	SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
            return info;
        }
        return null;
    }

    /**
     * 登录认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token=(UsernamePasswordToken) authenticationToken;

        //查出是否有此用户
        User user=ccodeService.getUserByLoginName(token.getUsername());
        if(user!=null){              	
        	SecurityUtils.getSubject().getSession().setAttribute("user", user);
//        	SecurityUtils.getSubject().getSession().setTimeout(expireMS);
            return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
        }
        return null;
    }
}