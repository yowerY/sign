package self.sign.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

public class PasswordMatcher extends SimpleCredentialsMatcher{
	
	@Override   
    public boolean doCredentialsMatch(AuthenticationToken authcToken, AuthenticationInfo info) {    
             
	    UsernamePasswordToken token = (UsernamePasswordToken) authcToken;   
	    Object accountCredentials = getCredentials(info);  
	    if(String.valueOf(token.getPassword()).equals(accountCredentials.toString())){
	    	
	    	return true;
	    }else{
	    	return false;
	    }
    }  
}
