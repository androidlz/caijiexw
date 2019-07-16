package com.seventeenok.caijie.model.bean.hometab;

import java.util.List;

/**
 * Created by root on 2018/5/22.
 */

public class HomeTabBean {
    
    /**
     * code : 0
     * msg : ok
     */
    
    private HeaderEntity header;
    /**
     * navnum : 14
     * nav : [{"cate_id":"101","cate_name":"财经"},{"cate_id":"104","cate_name":"艺术"},{"cate_id":"112","cate_name":"文体"},{"cate_id":"113","cate_name":"芳华"},{"cate_id":"785","cate_name":"中华经典"},{"cate_id":"400","cate_name":"南方基金"},{"cate_id":"225","cate_name":"民生证券"},{"cate_id":"110","cate_name":"中国航天"},{"cate_id":"105","cate_name":"一带一路"},{"cate_id":"109","cate_name":"城市"}]
     */
    
    private BodyEntity body;
    
    public HeaderEntity getHeader() {
        return header;
    }
    
    public void setHeader(HeaderEntity header) {
        this.header = header;
    }
    
    public BodyEntity getBody() {
        return body;
    }
    
    public void setBody(BodyEntity body) {
        this.body = body;
    }
    
    public static class HeaderEntity {
        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("HeaderEntity{");
            sb.append("code=").append(code);
            sb.append(", msg='").append(msg).append('\'');
            sb.append('}');
            return sb.toString();
        }
    
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
    
    public static class BodyEntity {
        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("BodyEntity{");
            sb.append("navnum=").append(navnum);
            sb.append(", nav=").append(nav);
            sb.append('}');
            return sb.toString();
        }
    
        private int navnum;
        /**
         * cate_id : 101
         * cate_name : 财经
         */
        
        private List<NavEntity> nav;
        
        public int getNavnum() {
            return navnum;
        }
        
        public void setNavnum(int navnum) {
            this.navnum = navnum;
        }
        
        public List<NavEntity> getNav() {
            return nav;
        }
        
        public void setNav(List<NavEntity> nav) {
            this.nav = nav;
        }
        
        public static class NavEntity {
            private String cate_id;
            private String cate_name;
            
            public String getCate_id() {
                return cate_id;
            }
            
            public void setCate_id(String cate_id) {
                this.cate_id = cate_id;
            }
            
            public String getCate_name() {
                return cate_name;
            }
            
            public void setCate_name(String cate_name) {
                this.cate_name = cate_name;
            }
        }
    }
    
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("HomeTabBean{");
        sb.append("header=").append(header);
        sb.append(", body=").append(body);
        sb.append('}');
        return sb.toString();
    }
}
