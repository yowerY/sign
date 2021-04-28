package self.sign.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import self.sign.entity.CourseComment;
import self.sign.entity.User;
import self.sign.exceptions.BusiException;
import self.sign.services.CourseCommentService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by yangwanhong on 2021/4/26.
 */
@Service
public class CourseCommentServiceImpl extends ServiceImpl<BaseMapper<CourseComment>,CourseComment> implements CourseCommentService {
    @Override
    public void addComment(Long courseId, String comment, Integer level, User currentUser) {
        CourseComment courseComment = new CourseComment();
        courseComment.setCourseId(courseId);
        courseComment.setUserId(currentUser.getId());

        QueryWrapper<CourseComment> courseCommentQueryWrapper = new QueryWrapper<>(courseComment);
        List<CourseComment> signRecordList = this.list(courseCommentQueryWrapper);
        if(!CollectionUtils.isEmpty(signRecordList)){
            throw new BusiException("你已经评论过了");
        }

        courseComment.setCommentTime(new Date());
        courseComment.setLevel(level);
        courseComment.setComment(comment);

        this.save(courseComment);
    }

    @Override
    public List<CourseComment> listByCourseId(Long courseId) {
        return this.list(new QueryWrapper<>(CourseComment.builder().courseId(courseId).build()));
    }
}
