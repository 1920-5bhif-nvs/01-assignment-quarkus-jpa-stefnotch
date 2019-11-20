package at.htl.krankenhaus.rest;

import io.quarkus.hibernate.orm.panache.Panache;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.inject.Inject;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
@Transactional // Database transactions
public abstract class AbstractEndpoint<T extends PanacheEntity> {

    public AbstractEndpoint() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAll() {

        return Response.ok().entity(T.findAll()).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getSingle(@PathParam("id") long id) {
        T entity = T.findById(id);
        if(entity != null) {
            return Response.ok().entity(entity).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post(T entity) {
        try {
            entity.persist(); // And flush?
        } catch(PersistenceException e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        // Return the newly created entity
        return Response.ok(entity).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response put(T entity) {
        try {
            //Ideally it would check if the entity already exists
            // (dao.find(entity))
            // And if it doesn't, it should return 201 (CREATED) instead of 200 (OK)
            entity = Panache.getEntityManager().merge(entity);
        } catch (PersistenceException e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        return Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") long id) {
        T entity = T.findById(id);
        if(entity != null) {
            entity.delete();
        }

        return Response.noContent().build();
    }
}
