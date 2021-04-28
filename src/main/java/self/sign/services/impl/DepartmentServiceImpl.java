package self.sign.services.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import self.sign.entity.Department;
import self.sign.services.DepartmentService;
import org.springframework.stereotype.Service;

/**
 * Created by yangwanhong on 2021/4/26.
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<BaseMapper<Department>,Department> implements DepartmentService {
}
