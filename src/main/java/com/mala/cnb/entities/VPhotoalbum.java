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
@Table(name = "v_photoalbum")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VPhotoalbum.findAll", query = "SELECT v FROM VPhotoalbum v"),
    @NamedQuery(name = "VPhotoalbum.findByImageID", query = "SELECT v FROM VPhotoalbum v WHERE v.imageID = :imageID"),
    @NamedQuery(name = "VPhotoalbum.findByInsertDate", query = "SELECT v FROM VPhotoalbum v WHERE v.insertDate = :insertDate"),
    @NamedQuery(name = "VPhotoalbum.findByFullSizeImagePath", query = "SELECT v FROM VPhotoalbum v WHERE v.fullSizeImagePath = :fullSizeImagePath"),
    @NamedQuery(name = "VPhotoalbum.findByThumbnailPath", query = "SELECT v FROM VPhotoalbum v WHERE v.thumbnailPath = :thumbnailPath")})
public class VPhotoalbum implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ImageID")
    @Id
    private int imageID;
    @Column(name = "InsertDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertDate;
    @Size(max = 132)
    @Column(name = "FullSizeImagePath")
    private String fullSizeImagePath;
    @Size(max = 128)
    @Column(name = "ThumbnailPath")
    private String thumbnailPath;

    public VPhotoalbum() {
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    public String getFullSizeImagePath() {
        return fullSizeImagePath;
    }

    public void setFullSizeImagePath(String fullSizeImagePath) {
        this.fullSizeImagePath = fullSizeImagePath;
    }

    public String getThumbnailPath() {
        return thumbnailPath;
    }

    public void setThumbnailPath(String thumbnailPath) {
        this.thumbnailPath = thumbnailPath;
    }
    
}
