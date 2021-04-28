package self.sign.conf;

import self.sign.exceptions.BusiException;
import self.sign.vo.ResultDto;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yangwanhong on 2021/4/26.
 */
@ControllerAdvice
public class CommonExceptionHandler {


    @ExceptionHandler(value = BusiException.class)
    @ResponseBody
    public ResultDto busiExceptionHandler(Exception e){
        ResultDto result = new ResultDto();
        result.setMessage(e.getMessage());
        result.setCode("666");
        return result;
    }

    @ExceptionHandler(value = Exception.class)
    public String exceptionHandler(Exception e){
        System.out.println(e.getMessage());
        return "exception";
    }
}
