package com.seventeenok.caijie.model.bean;

/**
 * Created by WGKJ_0010 on 2017/6/16.
 */

public class LoginBean {

    /**
     * body : {"token":"lkjfwouehfkjshfkjewhfwkjehfjk","userid":"341742","result":0}
     * header : {"code":0,"msg":"ok"}
     */

    private BodyBean body;
    private HeaderBean header;

    public BodyBean getBody() {
        return body;
    }

    public void setBody(BodyBean body) {
        this.body = body;
    }

    public HeaderBean getHeader() {
        return header;
    }

    public void setHeader(HeaderBean header) {
        this.header = header;
    }

    public static class BodyBean {
        /**
         * token : lkjfwouehfkjshfkjewhfwkjehfjk
         * userid : 341742
         * result : 0
         */

        private String token;
        private String userid;
        private int result;
        private String identifier;
        private String usersig;

        public String getIdentifier() {
            return identifier;
        }
    
        public void setIdentifier(String identifier) {
            this.identifier = identifier;
        }
    
        public String getUsersig() {
            return usersig;
        }
    
        public void setUsersig(String usersig) {
            this.usersig = usersig;
        }
    
        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getUserid() {
            return userid;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        public int getResult() {
            return result;
        }

        public void setResult(int result) {
            this.result = result;
        }
    }

    public static class HeaderBean {
        /**
         * code : 0
         * msg : ok
         */

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
}
