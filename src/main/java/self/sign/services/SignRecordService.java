package self.sign.services;

import com.baomidou.mybatisplus.extension.service.IService;
import self.sign.entity.SignRecord;
import self.sign.entity.User;

/**
 * Created by yangwanhong on 2021/4/26.
 */
public interface SignRecordService extends IService<SignRecord> {
    Boolean sign(Long courseId, User currentUser);
}
