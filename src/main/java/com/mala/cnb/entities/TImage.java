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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mawp
 */
@Entity
@Table(name = "T_IMAGE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TImage.findAll", query = "SELECT t FROM TImage t"),
    @NamedQuery(name = "TImage.findByImageID", query = "SELECT t FROM TImage t WHERE t.imageID = :imageID"),
    @NamedQuery(name = "TImage.findByInsertDate", query = "SELECT t FROM TImage t WHERE t.insertDate = :insertDate"),
    @NamedQuery(name = "TImage.findByNote", query = "SELECT t FROM TImage t WHERE t.note = :note"),
    @NamedQuery(name = "TImage.findByModule", query = "SELECT t FROM TImage t WHERE t.module = :module")})
public class TImage implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ImageID")
    private Integer imageID;
    @Column(name = "InsertDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertDate;
    @Lob
    @Column(name = "Thumbnail")
    private byte[] thumbnail;
    @Lob
    @Column(name = "FullSizeImage")
    private byte[] fullSizeImage;
    @Size(max = 200)
    @Column(name = "Note")
    private String note;
    @Column(name = "Module")
    private Character module;

    public TImage() {
    }

    public TImage(Integer imageID) {
        this.imageID = imageID;
    }

    public Integer getImageID() {
        return imageID;
    }

    public void setImageID(Integer imageID) {
        this.imageID = imageID;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    public byte[] getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(byte[] thumbnail) {
        this.thumbnail = thumbnail;
    }

    public byte[] getFullSizeImage() {
        return fullSizeImage;
    }

    public void setFullSizeImage(byte[] fullSizeImage) {
        this.fullSizeImage = fullSizeImage;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Character getModule() {
        return module;
    }

    public void setModule(Character module) {
        this.module = module;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (imageID != null ? imageID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TImage)) {
            return false;
        }
        TImage other = (TImage) object;
        if ((this.imageID == null && other.imageID != null) || (this.imageID != null && !this.imageID.equals(other.imageID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mala.cnb.entities.TImage[ imageID=" + imageID + " ]";
    }
    
}
