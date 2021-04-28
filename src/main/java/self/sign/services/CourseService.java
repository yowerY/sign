package self.sign.services;

import com.baomidou.mybatisplus.extension.service.IService;
import self.sign.entity.Course;
import self.sign.vo.PageVO;

import java.util.List;

/**
 * Created by yangwanhong on 2021/4/26.
 */
public interface CourseService extends IService<Course> {
    List<Course> getCourseListByUserId(Long id);

    PageVO<Course> queryPage(PageVO pageParam, Course dtoParam);
}
