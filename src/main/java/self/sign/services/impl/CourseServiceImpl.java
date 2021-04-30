package self.sign.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import self.sign.entity.Course;
import self.sign.entity.Department;
import self.sign.entity.User;
import self.sign.mapper.CourseMapper;
import self.sign.services.CourseService;
import self.sign.services.DepartmentService;
import self.sign.services.UserService;
import self.sign.vo.PageVO;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by yangwanhong on 2021/4/26.
 */
@Service
public class CourseServiceImpl extends ServiceImpl<BaseMapper<Course>,Course> implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private DepartmentService departmentService;

    @Override
    public List<Course> getCourseListByUserId(Long id) {
        User user = userService.getById(id);

        QueryWrapper<Course> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("department_id",user.getDepartmentId());
        queryWrapper.gt("end_time",new Date());
        queryWrapper.last("limit 0,10");

        queryWrapper.orderByAsc("start_time");

        List<Course> courseList = this.list(queryWrapper);

        dealData(courseList);

        return courseList;
    }

    @Override
    public PageVO<Course> queryPage(PageVO pageParam, Course dtoParam) {
        Page<Course> page = new Page<>();
        page.setCurrent(pageParam.getCurrent());
        page.setSize(pageParam.getSize());
        page.setAsc("start_time");

        IPage<Course> pageResult = this.page(page,new QueryWrapper<>(dtoParam));

        dealData(pageResult.getRecords());
        return PageVO.transfer(pageResult);
    }

    private void dealData(List<Course> courseList){
        if(!CollectionUtils.isEmpty(courseList)) {

            List<Long> userIdList = courseList.stream().map(Course::getUserId).collect(Collectors.toList());
            QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
            userQueryWrapper.in("id",userIdList);

            List<User> userList = userService.list(userQueryWrapper);
            Map<Long,User> userMap = userList.stream().collect(Collectors.toMap(User::getId, v->v));


            List<Long> departmentIdList = courseList.stream().map(Course::getDepartmentId).collect(Collectors.toList());
            QueryWrapper<Department> departmentQueryWrapper = new QueryWrapper<>();
            departmentQueryWrapper.in("id",departmentIdList);

            List<Department> departmentList = departmentService.list(departmentQueryWrapper);
            Map<Long,Department> departmentMap = departmentList.stream().collect(Collectors.toMap(Department::getId, v->v));

            courseList.forEach(course -> {
                course.setCourseUserName(userMap.get(course.getUserId()).getUsername());
                course.setDepartmentName(departmentMap.get(course.getDepartmentId()).getName());

                Date date = new Date();
                if(date.compareTo(course.getStartTime()) >=0 && date.compareTo(course.getEndTime())<=0){
                    course.setStatus(2);
                }
                if(date.compareTo(course.getStartTime())<0){
                    course.setStatus(1);
                }
                if(date.compareTo(course.getEndTime())>0){
                    course.setStatus(3);
                }
            });
        }
    }
}
