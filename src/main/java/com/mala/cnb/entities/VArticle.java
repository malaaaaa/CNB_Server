/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mala.cnb.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mawp
 */
@Entity
@Table(name = "v_article")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VArticle.findAll", query = "SELECT v FROM VArticle v"),
    @NamedQuery(name = "VArticle.findByArticleID", query = "SELECT v FROM VArticle v WHERE v.articleID = :articleID"),
    @NamedQuery(name = "VArticle.findBySubTitle", query = "SELECT v FROM VArticle v WHERE v.subTitle = :subTitle"),
    @NamedQuery(name = "VArticle.findByThumbImagePath", query = "SELECT v FROM VArticle v WHERE v.thumbImagePath = :thumbImagePath"),
    @NamedQuery(name = "VArticle.findByTitle", query = "SELECT v FROM VArticle v WHERE v.title = :title"),
    @NamedQuery(name = "VArticle.findByUpdateTime", query = "SELECT v FROM VArticle v WHERE v.updateTime = :updateTime")})
public class VArticle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ArticleID")
    @Id
    private int articleID;
    @Size(max = 100)
    @Column(name = "SubTitle")
    private String subTitle;
    @Size(max = 128)
    @Column(name = "ThumbImagePath")
    private String thumbImagePath;
    @Size(max = 50)
    @Column(name = "Title")
    private String title;
    @Size(max = 72)
    @Column(name = "UpdateTime")
    private String updateTime;

    public VArticle() {
    }

    public int getArticleID() {
        return articleID;
    }

    public void setArticleID(int articleID) {
        this.articleID = articleID;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getThumbImagePath() {
        return thumbImagePath;
    }

    public void setThumbImagePath(String thumbImagePath) {
        this.thumbImagePath = thumbImagePath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
    
}
