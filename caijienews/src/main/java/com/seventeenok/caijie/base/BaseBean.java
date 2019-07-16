package com.seventeenok.caijie.base;

import com.google.gson.Gson;

public abstract class BaseBean<T> {

    public  Header header;
    public  Body body;

    public Header getHeader() {
        return header;
    }

    public BaseBean<T> setHeader(Header header) {
        this.header = header;
        return this;
    }

    public Body getBody() {
        return body;
    }

    public BaseBean<T> setBody(Body body) {
        this.body = body;
        return this;
    }

    public static class Header {
        public Header(String userid, String token) {
            userid = userid;
            token = token;
        }

        public String userid;
        public String token;

        public String getUserid() {
            return userid;
        }

        public Header setUserid(String userid) {
            userid = userid;
            return this;
        }

        public String getToken() {
            return token;
        }

        public Header setToken(String token) {
            token = token;
            return this;
        }
    }

    public  class Body {

    }

    public  String toJsonParams(T t) {
        Gson gson=new Gson();
        String s = gson.toJson(t);
        return s;
    }
}
