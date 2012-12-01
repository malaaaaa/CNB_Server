package com.mala.cnb.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2012-11-28T15:58:31")
@StaticMetamodel(TImage.class)
public class TImage_ { 

    public static volatile SingularAttribute<TImage, Character> module;
    public static volatile SingularAttribute<TImage, byte[]> thumbnail;
    public static volatile SingularAttribute<TImage, Integer> imageID;
    public static volatile SingularAttribute<TImage, byte[]> fullSizeImage;
    public static volatile SingularAttribute<TImage, Date> insertDate;
    public static volatile SingularAttribute<TImage, String> note;

}