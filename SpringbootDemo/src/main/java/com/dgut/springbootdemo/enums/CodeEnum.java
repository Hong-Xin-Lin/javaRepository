package com.dgut.springbootdemo.enums;

import com.dgut.springbootdemo.result.R;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
public enum CodeEnum {

    OK(200,"成功"),
    FAIL(400,"失败"),
    BAD_REQUEST(400,"请求错误"),
    NOT_FOUND(404,"未找到"),
    INTERNAL_ERROR(500,"内部服务器错误"),
    MODIFICATION_FAILED(400,"修改失败"),
    DELETION_FAILED(400,"删除失败"),
    CREATION_FAILED(400,"创建失败");

    @Setter
    @Getter
    private int code;

    @Setter
    @Getter
    private String message;

}
