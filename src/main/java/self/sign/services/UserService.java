package self.sign.services;

import com.baomidou.mybatisplus.extension.service.IService;
import self.sign.entity.User;


public interface UserService extends IService<User> {

    /**
     * 获取一个用户
     * @param userName  用户名
     * @return          用户
     */
    User getOne(String userName);
    User getOne(Integer id);
    User getUserByLoginName(String loginName);

    /**
     * 修改米啊
     * @param userId        用户id
     * @param newPassword   新密码
     * @return              是否修改成功！
     */
    boolean updatePassword(Integer userId, String newPassword);



    User saveUser(User user);
}
