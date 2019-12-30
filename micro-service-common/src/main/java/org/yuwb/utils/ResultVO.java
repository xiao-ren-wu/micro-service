package org.yuwb.utils;

import lombok.Data;
import org.yuwb.ResultEnum;

/**
 * @author WbYu
 * e-mail 18629015421@163.com
 * github https://github.com/xiao-ren-wu
 * <p>
 * </p>
 * @version v1.0.0
 * @date 2019/12/27 8:15 上午
 * @since java 11
 */
@Data
public class ResultVO<T> {
    private String message;
    private String code;
    private T data;

    private ResultVO(){}

    public  static <E> ResultVO<E> create(){
        return new ResultVO<>();
    }

    public ResultVO<T> data(T data){
        this.data = data;
        return this;
    }

    public ResultVO<T> message(String message){
        this.message = message;
        return this;
    }

    public ResultVO<T> code(String code){
        this.code = code;
        return this;
    }

    public static <E> ResultVO<E> create(ResultEnum resultEnum){
        ResultVO<E> resultVO = new ResultVO<>();
        resultVO.code = resultEnum.getCode();
        resultVO.message = resultEnum.getMessage();
        return resultVO;
    }

    public static <E> ResultVO<E> createBySuccess(E data){
        ResultVO<E> resultVO = create(ResultEnum.SUCCESS);
        resultVO.data = data;
        return resultVO;
    }

}
