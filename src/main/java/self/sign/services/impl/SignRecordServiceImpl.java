package self.sign.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import self.sign.entity.SignRecord;
import self.sign.entity.User;
import self.sign.exceptions.BusiException;
import self.sign.services.SignRecordService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by yangwanhong on 2021/4/26.
 */
@Service
public class SignRecordServiceImpl extends ServiceImpl<BaseMapper<SignRecord>,SignRecord> implements SignRecordService {
    @Override
    public Boolean sign(Long courseId, User currentUser) {
        SignRecord record = new SignRecord();
        record.setCourseId(courseId);
        record.setUserId(currentUser.getId());

        QueryWrapper<SignRecord> signRecordQueryWrapper = new QueryWrapper<>(record);
        List<SignRecord> signRecordList = this.list(signRecordQueryWrapper);
        if(!CollectionUtils.isEmpty(signRecordList)){
            throw new BusiException("请不要重复签到");
        }

        record.setSignTime(new Date());
        this.save(record);
        return true;
    }
}
