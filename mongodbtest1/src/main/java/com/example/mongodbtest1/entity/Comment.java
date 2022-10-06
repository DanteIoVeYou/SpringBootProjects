package com.example.mongodbtest1.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Document(collection = "comment")
// 复合索引
// @CompoundIndex(def = "{'userid':1,'nickname':-1}")
public class Comment {
    @Id
    private String id; // 主键

    @Override
    public String toString() {
        return "Comment{" +
                "id='" + id + '\'' +
                ", acticleid='" + acticleid + '\'' +
                ", content='" + content + '\'' +
                ", userid='" + userid + '\'' +
                ", nickname='" + nickname + '\'' +
                ", createDataTime=" + createDataTime +
                ", linknum=" + linknum +
                ", state=" + state +
                '}';
    }

    private String acticleid;
    @Field("content") // 属性名臣和字段名词对应不上
    private String content;
    @Indexed
    private String userid;
    private String nickname;
    private LocalDateTime createDataTime;
    private int linknum;
    private int state;
    private String parentid; // 上级id

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getActicleid() {
        return acticleid;
    }

    public void setActicleid(String acticleid) {
        this.acticleid = acticleid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public LocalDateTime getCreateDataTime() {
        return createDataTime;
    }

    public void setCreateDataTime(LocalDateTime createDataTime) {
        this.createDataTime = createDataTime;
    }

    public int getLinknum() {
        return linknum;
    }

    public void setLinknum(int linknum) {
        this.linknum = linknum;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
