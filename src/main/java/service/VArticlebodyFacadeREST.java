/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.mala.cnb.entities.VArticlebody;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
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
//@Path("com.mala.cnb.entities.varticlebody")
@Path("/articlebody")
public class VArticlebodyFacadeREST extends AbstractFacade<VArticlebody> {
    @PersistenceContext(unitName = "com.mala_CNB_war_0.5PU")
    private EntityManager em;

    public VArticlebodyFacadeREST() {
        super(VArticlebody.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(VArticlebody entity) {
        super.create(entity);
    }

    @PUT
    @Override
    @Consumes({"application/xml", "application/json"})
    public void edit(VArticlebody entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        super.remove(super.find(id));
    }

//    @GET
//    @Path("{id}")
//    @Produces({"application/xml", "application/json"})
//    public VArticlebody find(@PathParam("id") String id) {
//        return super.find(id);
//    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<VArticlebody> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<VArticlebody> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    
        @GET
    @Path("{id}")
    @Produces({ "application/json"})
    public List<VArticlebody> findByID(@PathParam("id") Integer id) {
//        Query query = em.createQuery("SELECT t FROM VArticlebody t where t.articleID=:arg1");
//        query.setParameter("arg1", id);
        Query query = em.createNamedQuery("VArticlebody.findByArticleID").setParameter("articleID", id);                 
        List<VArticlebody> listExpected = query.getResultList();

        return listExpected;
    }
    
}
