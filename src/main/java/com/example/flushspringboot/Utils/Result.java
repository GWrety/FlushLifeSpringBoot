package com.example.flushspringboot.Utils;

import lombok.Data;

@Data
public class Result {
    public int code;
    public Object data;


    public Result(int x){
        this.code=x;
    }


}
