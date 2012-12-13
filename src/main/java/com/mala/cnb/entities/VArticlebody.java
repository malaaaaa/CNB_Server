/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mala.cnb.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mawp
 */
@Entity
@Table(name = "v_articlebody")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VArticlebody.findAll", query = "SELECT v FROM VArticlebody v"),
    @NamedQuery(name = "VArticlebody.findById", query = "SELECT v FROM VArticlebody v WHERE v.id = :id"),
    @NamedQuery(name = "VArticlebody.findByArticleID", query = "SELECT v FROM VArticlebody v WHERE v.articleID = :articleID order by v.sort"),
    @NamedQuery(name = "VArticlebody.findByType", query = "SELECT v FROM VArticlebody v WHERE v.type = :type"),
    @NamedQuery(name = "VArticlebody.findBySort", query = "SELECT v FROM VArticlebody v WHERE v.sort = :sort")})
public class VArticlebody implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 22)
    @Column(name = "ID")
    @Id
    private String id;
    @Column(name = "ArticleID")
    private Integer articleID;
    @Column(name = "Type")
    private Integer type;
    @Lob
    @Size(max = 65535)
    @Column(name = "Content")
    private String content;
    @Column(name = "Sort")
    private Integer sort;

    public VArticlebody() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getArticleID() {
        return articleID;
    }

    public void setArticleID(Integer articleID) {
        this.articleID = articleID;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
    
}
