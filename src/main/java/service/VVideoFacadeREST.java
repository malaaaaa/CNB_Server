/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.mala.cnb.entities.VVideo;
import java.sql.Timestamp;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
//@Path("com.mala.cnb.entities.vvideo")
@Path("/video")
public class VVideoFacadeREST extends AbstractFacade<VVideo> {
    @PersistenceContext(unitName = "com.mala_CNB_war_0.5PU")
    private EntityManager em;

    public VVideoFacadeREST() {
        super(VVideo.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(VVideo entity) {
        super.create(entity);
    }

    @PUT
    @Override
    @Consumes({"application/xml", "application/json"})
    public void edit(VVideo entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public VVideo find(@PathParam("id") String id) {
        return super.find(id);
    }
    
    @GET
    @Path("afterUpdatetime/{fullUpdateTime}")
    @Produces({ "application/json"})
    //时间参数格式为2012-12-05 00:00:00.000,如果参数类型为java.sql.date, 格式为 0000-00-00
    public List<VVideo> findAfterUpdateTime(@PathParam("fullUpdateTime") Timestamp fullUpdateTime) {
        Query query = em.createNamedQuery("VVideo.findAfterFullUpdateTime").setParameter("fullUpdateTime", fullUpdateTime);  
        //设置单次查询返回行数
        query.setMaxResults(10);
        List<VVideo> listExpected = query.getResultList();
        //查询不到数据，返回特殊标示
        if (query.getResultList().isEmpty()) {
            VVideo video =new VVideo();
            video.setTitle("NODATAFOUND");
            listExpected.add(video);
            System.out.println("NODATAFOUND");
        }
        return listExpected;
    }
    
    @GET
    @Override
    @Produces({"application/json"})
    public List<VVideo> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<VVideo> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    
}
