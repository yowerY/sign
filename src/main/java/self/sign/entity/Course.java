package self.sign.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by yangwanhong on 2021/4/26.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("course")
@Builder(toBuilder = true)
public class Course implements Serializable{

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date startTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date endTime;

    private Long departmentId;

    private Long userId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    @TableField(exist = false)
    private String courseUserName;

    /**
     * 1.未开始 2.进行中 3.已结束
     */
    @TableField(exist = false)
    private Integer status;

    @TableField(exist = false)
    private String departmentName;
}
