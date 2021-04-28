package self.sign.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import self.sign.entity.User;

@Mapper
public interface UserMapper extends BaseMapper<User> {
  
}
