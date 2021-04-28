package self.sign.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by yangwanhong on 2021/4/26.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sign_record")
@Builder(toBuilder = true)
public class SignRecord {

    private Long id;

    private Long userId;

    private Long courseId;

    private Date signTime;
}
