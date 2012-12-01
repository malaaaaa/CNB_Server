/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.mala.cnb.entities.TImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author mawp
 */
@Stateless
//@Path("com.mala.cnb.entities.timage")
@Path("image")
public class TImageFacadeREST extends AbstractFacade<TImage> {

    @PersistenceContext(unitName = "com.mala_CNB_war_0.5PU")
    private EntityManager em;

    public TImageFacadeREST() {
        super(TImage.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(TImage entity) {
        super.create(entity);
    }

    @PUT
    @Override
    @Consumes({"application/xml", "application/json"})
    public void edit(TImage entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public TImage find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<TImage> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<TImage> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    /**
     * ********************以下为自定义方法**********************************
     */
    @GET
    @Path("myMethod")
    @Produces("text/html")
    public String myMethod() {
        // Forward request to service layer.
        return "Hello World By Mawp";
    }

    @GET
    @Path("myMethod_json")
    @Produces({"application/json"})
    public List<TImage> findAll_json() {
        return super.findAll();
    }

    //浏览器可以直接访问解析单张大图片的WebService
    @GET
    @Path("fullsizeimage/{id}")
    @Produces("image/jpeg")
    public InputStream getFullSizeInputStream(@PathParam("id") Integer id) {
        TImage image = this.find(id);
        InputStream is = null;
        try {
            is = new ByteArrayInputStream(image.getFullSizeImage());
        } catch (Throwable e) {
            //找不到图片，显示出错的那张图片
            image = this.find(2);
            is = new ByteArrayInputStream(image.getFullSizeImage());
        }
        return is;
    }
    //浏览器可以直接访问解析单张略缩图片的WebService

    @GET
    @Path("thumbnail/{id}")
    @Produces("image/jpeg")
    public InputStream getThumbNailInputStream(@PathParam("id") Integer id) {
        TImage image = this.find(id);
        InputStream is = null;
        try {
            is = new ByteArrayInputStream(image.getThumbnail());
        } catch (Throwable e) {
            //找不到图片，显示出错的那张图片
            image = this.find(2);
            is = new ByteArrayInputStream(image.getFullSizeImage());
        }
        return is;
    }
}
