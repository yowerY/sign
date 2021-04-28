package self.sign.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import self.sign.entity.User;
import self.sign.mapper.UserMapper;
import self.sign.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lhr
 * @create 2018/2/3
 */
@Service
public class UserServiceImpl extends ServiceImpl<BaseMapper<User>,User> implements UserService  {


   @Autowired
   private UserMapper userMapper;

    @Override
    public User getOne(String userName) {
        return getOne(new QueryWrapper<>(User.builder().username(userName).build()));
    }

    @Override
    public User getOne(Integer id) {
        return getById(id);
    }

    @Override
    public boolean updatePassword(Integer userId, String newPassword) {
        User user = this.getOne(userId);
        user.setPassword(newPassword);
        this.saveOrUpdate(user);
        return true;
    }

    @Override
    public User saveUser(User user) {
        this.save(user);
        return user;
    }


    @Override
    public User getUserByLoginName(String loginName) {
        return getOne(new QueryWrapper<>(User.builder().loginName(loginName).build()));
    }

}
