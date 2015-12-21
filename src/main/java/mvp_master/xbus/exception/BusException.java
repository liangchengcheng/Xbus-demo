package mvp_master.xbus.exception;

/**
 * Author:  梁铖城
 * Email:   1038127753@qq.com
 * Date:    2015年12月15日10:47:52
 * Description:  BusException
 */
public class BusException extends RuntimeException{

    public  BusException(final  String detailMessage){
        super(detailMessage);
    }

    public BusException(final String detailMessage,final Throwable throwable){
        super(detailMessage,throwable);
    }

    public  BusException(final Throwable throwable){
        super(throwable);
    }

    public BusException(){
        super();
    }
}
