package self.sign.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
@TableName("course_comment")
@Builder(toBuilder = true)
public class CourseComment implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String comment;

    private Integer level;

    private Long courseId;

    private Long userId;

    private Date createTime;

    private Date updateTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date commentTime;
}
