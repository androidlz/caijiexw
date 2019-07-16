package com.seventeenok.caijie.model.bean.hometab;

import java.util.List;

/**
 * Created by root on 2018/5/22.
 */

public class TabFragmentBean {
    private HeaderEntity header;
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
            sb.append("focus=").append(focus.size());
            sb.append(", btn=").append(btn.size());
            sb.append(", listAllData=").append(listAllData.size());
            sb.append('}');
            return sb.toString();
        }
    
        private List<FocusEntity> focus;
        
        private List<BtnEntity> btn;
        
        private List<ListAllDataEntity> listAllData;
        
        public List<FocusEntity> getFocus() {
            return focus;
        }
        
        public void setFocus(List<FocusEntity> focus) {
            this.focus = focus;
        }
        
        public List<BtnEntity> getBtn() {
            return btn;
        }
        
        public void setBtn(List<BtnEntity> btn) {
            this.btn = btn;
        }
        
        public List<ListAllDataEntity> getListAllData() {
            return listAllData;
        }
        
        public void setListAllData(List<ListAllDataEntity> listAllData) {
            this.listAllData = listAllData;
        }
        
        public static class FocusEntity {
            private String title;
            private int vtype;
            private String vid;
            private String img;
            private String top_id;
            private String sort;
            
            public String getTitle() {
                return title;
            }
            
            public void setTitle(String title) {
                this.title = title;
            }
            
            public int getVtype() {
                return vtype;
            }
            
            public void setVtype(int vtype) {
                this.vtype = vtype;
            }
            
            public String getVid() {
                return vid;
            }
            
            public void setVid(String vid) {
                this.vid = vid;
            }
            
            public String getImg() {
                return img;
            }
            
            public void setImg(String img) {
                this.img = img;
            }
            
            public String getTop_id() {
                return top_id;
            }
            
            public void setTop_id(String top_id) {
                this.top_id = top_id;
            }
            
            public String getSort() {
                return sort;
            }
            
            public void setSort(String sort) {
                this.sort = sort;
            }
        }
        
        public static class BtnEntity {
            private String cate_id;
            private int type;
            private String cate_name;
            
            public String getCate_id() {
                return cate_id;
            }
            
            public void setCate_id(String cate_id) {
                this.cate_id = cate_id;
            }
            
            public int getType() {
                return type;
            }
            
            public void setType(int type) {
                this.type = type;
            }
            
            public String getCate_name() {
                return cate_name;
            }
            
            public void setCate_name(String cate_name) {
                this.cate_name = cate_name;
            }
        }
        
        public static class ListAllDataEntity {
            private String cate_name;
            private String forword_img;
            
            private List<VideoListEntity> video_list;
            
            public String getCate_name() {
                return cate_name;
            }
            
            public void setCate_name(String cate_name) {
                this.cate_name = cate_name;
            }
            
            public String getForword_img() {
                return forword_img;
            }
            
            public void setForword_img(String forword_img) {
                this.forword_img = forword_img;
            }
            
            public List<VideoListEntity> getVideo_list() {
                return video_list;
            }
            
            public void setVideo_list(List<VideoListEntity> video_list) {
                this.video_list = video_list;
            }
            
            public static class VideoListEntity {
                private String vid;
                private String cate_id;
                private String cateinfo;
                private String top_id;
                private String title;
                private String layout;
                private int pnum;
                private String hits;
                private String sub_time;
                private int time_length;
                private String filepath1;
                private String filepath2;
                private String hdpath;
                private String short_tag;
                private String isvip;
                private List<String> cover;
                
                private List<KwordListEntity> kword_list;
                
                public String getVid() {
                    return vid;
                }
                
                public void setVid(String vid) {
                    this.vid = vid;
                }
                
                public String getCate_id() {
                    return cate_id;
                }
                
                public void setCate_id(String cate_id) {
                    this.cate_id = cate_id;
                }
                
                public String getCateinfo() {
                    return cateinfo;
                }
                
                public void setCateinfo(String cateinfo) {
                    this.cateinfo = cateinfo;
                }
                
                public String getTop_id() {
                    return top_id;
                }
                
                public void setTop_id(String top_id) {
                    this.top_id = top_id;
                }
                
                public String getTitle() {
                    return title;
                }
                
                public void setTitle(String title) {
                    this.title = title;
                }
                
                public String getLayout() {
                    return layout;
                }
                
                public void setLayout(String layout) {
                    this.layout = layout;
                }
                
                public int getPnum() {
                    return pnum;
                }
                
                public void setPnum(int pnum) {
                    this.pnum = pnum;
                }
                
                public String getHits() {
                    return hits;
                }
                
                public void setHits(String hits) {
                    this.hits = hits;
                }
                
                public String getSub_time() {
                    return sub_time;
                }
                
                public void setSub_time(String sub_time) {
                    this.sub_time = sub_time;
                }
                
                public int getTime_length() {
                    return time_length;
                }
                
                public void setTime_length(int time_length) {
                    this.time_length = time_length;
                }
                
                public String getFilepath1() {
                    return filepath1;
                }
                
                public void setFilepath1(String filepath1) {
                    this.filepath1 = filepath1;
                }
                
                public String getFilepath2() {
                    return filepath2;
                }
                
                public void setFilepath2(String filepath2) {
                    this.filepath2 = filepath2;
                }
                
                public String getHdpath() {
                    return hdpath;
                }
                
                public void setHdpath(String hdpath) {
                    this.hdpath = hdpath;
                }
                
                public String getShort_tag() {
                    return short_tag;
                }
                
                public void setShort_tag(String short_tag) {
                    this.short_tag = short_tag;
                }
                
                public String getIsvip() {
                    return isvip;
                }
                
                public void setIsvip(String isvip) {
                    this.isvip = isvip;
                }
                
                public List<String> getCover() {
                    return cover;
                }
                
                public void setCover(List<String> cover) {
                    this.cover = cover;
                }
                
                public List<KwordListEntity> getKword_list() {
                    return kword_list;
                }
                
                public void setKword_list(List<KwordListEntity> kword_list) {
                    this.kword_list = kword_list;
                }
                
                public static class KwordListEntity {
                    private String cate_name;
                    private int cate_id;
                    private int forword;
                    private int parent_id;
                    
                    public String getCate_name() {
                        return cate_name;
                    }
                    
                    public void setCate_name(String cate_name) {
                        this.cate_name = cate_name;
                    }
                    
                    public int getCate_id() {
                        return cate_id;
                    }
                    
                    public void setCate_id(int cate_id) {
                        this.cate_id = cate_id;
                    }
                    
                    public int getForword() {
                        return forword;
                    }
                    
                    public void setForword(int forword) {
                        this.forword = forword;
                    }
                    
                    public int getParent_id() {
                        return parent_id;
                    }
                    
                    public void setParent_id(int parent_id) {
                        this.parent_id = parent_id;
                    }
                }
            }
        }
    }
}
