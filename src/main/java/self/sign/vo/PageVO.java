package self.sign.vo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageVO<T> implements IPage<T>{

    private long current ;

    private long size;

    private List<T> rows = new ArrayList<T>();
    //数据总条数
    private long total;

    private List<T> records;

    @Override
    public List<T> getRecords() {
        return this.records;
    }

    @Override
    public IPage<T> setRecords(List<T> list) {
        this.records = records;
        return this;
    }

    @Override
    public IPage<T> setTotal(Long aLong) {
        this.total = aLong.longValue();
        return this;
    }

    @Override
    public IPage<T> setSize(long l) {
        this.size = l;
        return this;
    }

    @Override
    public IPage<T> setCurrent(long l) {
        this.current = l;
        return this;
    }

    public static PageVO transfer(IPage page){
        PageVO pageVO = new PageVO();
        BeanUtils.copyProperties(page,pageVO);
        pageVO.setRows(page.getRecords());
        return pageVO;
    }
}
