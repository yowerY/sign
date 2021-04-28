package self.sign.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import self.sign.entity.Department;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DepartmentMapper extends BaseMapper<Department> {
  
}
