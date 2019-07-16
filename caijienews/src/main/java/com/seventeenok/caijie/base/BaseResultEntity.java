package com.seventeenok.caijie.base;

public class BaseResultEntity<T> {
    //    {"header":{"code":0,"msg":"ok"},"body":{"res":"ok"}}
    public class Header {
        private int code;
        private String msg;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }

    public class Body {
        private T data;
    }
}
