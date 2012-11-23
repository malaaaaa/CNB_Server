/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.mala.cnb.entities.VPhotoalbum;
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
//@Path("com.mala.cnb.entities.vphotoalbum")
@Path("image/photo")
public class VPhotoalbumFacadeREST extends AbstractFacade<VPhotoalbum> {
    @PersistenceContext(unitName = "com.mala_CNB_war_0.5PU")
    private EntityManager em;

    public VPhotoalbumFacadeREST() {
        super(VPhotoalbum.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(VPhotoalbum entity) {
        super.create(entity);
    }

    @PUT
    @Override
    @Consumes({"application/xml", "application/json"})
    public void edit(VPhotoalbum entity) {
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
    public VPhotoalbum find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<VPhotoalbum> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<VPhotoalbum> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    
    //获取所有大图和略缩图WebService地址
    @GET
    @Path("url")
    @Produces({"application/json"})
    public List<VPhotoalbum> findAllVPhotoalbum() {
        return super.findAll();
    }
}
