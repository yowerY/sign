package self.sign.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by yangwanhong on 2021/4/26.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("department")
@Builder(toBuilder = true)
public class Department implements Serializable{


    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String name;

    private String code;
}
