package self.sign.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import self.sign.consts.UserStatusConst;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user_info")
@Builder(toBuilder = true)
public class User implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;


    private String loginName;

    /** 用户 */
    private String username;

    /** 密码 */
    private String password;

    private Date createTime;

    /** 更新时间 */
    private Date updateTime;

    /** 状态 */
    private Integer status = UserStatusConst.USE;

    /** 账号类型 */
    private Integer type;

    private Long departmentId;
	
}
