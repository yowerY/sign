package self.sign.vo;

public class AlertVO {


    public static String alert(int code, String msg){
        if (code >= 0){
            return "<script>alert('" + msg + "');location.href=history.back(-1);</script>";
        }else {
            return "<script>alert('" + msg + "');location.href=history.go(-1);</script>";
        }
    }

    /**
     * 成功跳转到指定地址，失败go -1
     * @param code
     * @param msg
     * @param goToPath
     * @return
     */
    public static String alertAndSuccessGoToPath(int code, String msg, String goToPath){
        if (code >= 0){
            return "<script>alert('" + msg + "');location.href='"+goToPath+"';</script>";
        }else {
            return "<script>alert('" + msg + "');location.href=history.go(-1);</script>";
        }
    }
    public static String alertAndRunJs(String msg, String js){
        return "<script>alert('" + msg + "');" + js + ";</script>";
    }

}
