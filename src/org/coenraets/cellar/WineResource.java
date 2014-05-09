package org.coenraets.cellar;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * @author Christophe Coenraets
 */
@Path("/wines")
public class WineResource {

    WineDAO dao = new WineDAO();

    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<Wine> finaAll() {
        return dao.findAll();
    }

    @GET @Path("search/{query}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Wine findByName(@PathParam("query") String query) {
        return dao.findByName(query);
    }

    @GET @Path("{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Wine findById(@PathParam("id") String id) {
        return dao.findById(Integer.parseInt(id));
    }

    @POST
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Wine create(Wine wine) {
        return dao.create(wine);
    }

    @PUT @Path("{id}")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Wine update(Wine wine) {
        return dao.update(wine);
    }

    @DELETE @Path("{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void remove(@PathParam("id") int id) {
        dao.remove(id);
    }

}
