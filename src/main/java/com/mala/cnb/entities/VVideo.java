/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mala.cnb.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mawp
 */
@Entity
@Table(name = "v_video")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VVideo.findAll", query = "SELECT v FROM VVideo v"),
    @NamedQuery(name = "VVideo.findByVideoID", query = "SELECT v FROM VVideo v WHERE v.videoID = :videoID"),
    @NamedQuery(name = "VVideo.findByTitle", query = "SELECT v FROM VVideo v WHERE v.title = :title"),
    @NamedQuery(name = "VVideo.findByIntroduction", query = "SELECT v FROM VVideo v WHERE v.introduction = :introduction"),
    @NamedQuery(name = "VVideo.findByUpdateTime", query = "SELECT v FROM VVideo v WHERE v.updateTime = :updateTime"),
    @NamedQuery(name = "VVideo.findByUrl", query = "SELECT v FROM VVideo v WHERE v.url = :url"),
    @NamedQuery(name = "VVideo.findByShareURL", query = "SELECT v FROM VVideo v WHERE v.shareURL = :shareURL"),
    @NamedQuery(name = "VVideo.findByFullUpdateTime", query = "SELECT v FROM VVideo v WHERE v.fullUpdateTime = :fullUpdateTime"),
    @NamedQuery(name = "VVideo.findAfterFullUpdateTime", query = "SELECT v FROM VVideo v WHERE v.fullUpdateTime < :fullUpdateTime"),
    @NamedQuery(name = "VVideo.findByThumbImagePath", query = "SELECT v FROM VVideo v WHERE v.thumbImagePath = :thumbImagePath")})
public class VVideo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VideoID")
    @Id
    private int videoID;
    @Size(max = 100)
    @Column(name = "Title")
    private String title;
    @Size(max = 100)
    @Column(name = "Introduction")
    private String introduction;
    @Size(max = 10)
    @Column(name = "UpdateTime")
    private String updateTime;
    @Size(max = 108)
    @Column(name = "URL")
    private String url;
    @Size(max = 79)
    @Column(name = "ShareURL")
    private String shareURL;
    @Column(name = "FullUpdateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fullUpdateTime;
    @Size(max = 128)
    @Column(name = "ThumbImagePath")
    private String thumbImagePath;

    public VVideo() {
    }

    public int getVideoID() {
        return videoID;
    }

    public void setVideoID(int videoID) {
        this.videoID = videoID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getShareURL() {
        return shareURL;
    }

    public void setShareURL(String shareURL) {
        this.shareURL = shareURL;
    }

    public Date getFullUpdateTime() {
        return fullUpdateTime;
    }

    public void setFullUpdateTime(Date fullUpdateTime) {
        this.fullUpdateTime = fullUpdateTime;
    }

    public String getThumbImagePath() {
        return thumbImagePath;
    }

    public void setThumbImagePath(String thumbImagePath) {
        this.thumbImagePath = thumbImagePath;
    }
    
}
