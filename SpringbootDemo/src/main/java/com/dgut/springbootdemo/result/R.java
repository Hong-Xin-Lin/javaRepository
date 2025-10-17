package com.dgut.springbootdemo.result;

import com.dgut.springbootdemo.enums.CodeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 统一的web层返回数据，统一格式，降低前后端沟通成本
 * @param <T>
 */

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class R<T> {

    private int code;

    private String msg;

    private T data;

    //响应成功的消息，不携带数据
    public static <T> R<T> OK(){
        return R.<T>builder()
                .code(CodeEnum.OK.getCode())
                .msg(CodeEnum.OK.getMessage())
                .build();
    }

    //响应成功的消息，携带数据
    public static <T> R<T> OK(T data){
        return R.<T>builder()
                .code(CodeEnum.OK.getCode())
                .msg(CodeEnum.OK.getMessage())
                .data(data)
                .build();
    }

    //响应失败的消息，不携带数据
    public static <T> R<T> FAIL(){
        return R.<T>builder()
                .code(CodeEnum.FAIL.getCode())
                .msg(CodeEnum.FAIL.getMessage())
                .build();
    }

    //响应失败的消息，controller层的程序员可以通过此方法指定特定的code和特定的message
    public static <T> R<T> FAIL(CodeEnum codeEnum){
        return R.<T>builder()
                .code(codeEnum.getCode())
                .msg(codeEnum.getMessage())
                .build();
    }
}
