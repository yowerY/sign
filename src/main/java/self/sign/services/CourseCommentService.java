package self.sign.services;

import com.baomidou.mybatisplus.extension.service.IService;
import self.sign.entity.CourseComment;
import self.sign.entity.User;

import java.util.List;

/**
 * Created by yangwanhong on 2021/4/26.
 */
public interface CourseCommentService extends IService<CourseComment> {
    void addComment(Long courseId, String comment, Integer level, User currentUser);

    List<CourseComment> listByCourseId(Long courseId);
}
