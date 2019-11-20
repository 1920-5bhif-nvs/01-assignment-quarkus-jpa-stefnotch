package at.htl.krankenhaus.rest;

import io.quarkus.hibernate.orm.panache.Panache;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.hibernate.orm.panache.PanacheQuery;

import javax.inject.Inject;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Example endpoint:
 * <code>
 * @Path("diagnosis")
 * @Produces({MediaType.APPLICATION_JSON})
 * @Consumes({MediaType.APPLICATION_JSON})
 * @Transactional
 * public class DiagnosisEndpoint {
 *     @GET
 *     public Response getAll() {
 *         return EndpointHelpers.getMany(Diagnosis.findAll());
 *     }
 *
 *     @GET
 *     @Path("{id}")
 *     public Response getById(@PathParam("id") long id) {
 *         return EndpointHelpers.get(Diagnosis.findById(id));
 *     }
 *
 *     @POST
 *     public Response post(Diagnosis entity) {
 *         return EndpointHelpers.post(entity);
 *     }
 *
 *     @PUT
 *     public Response put(Diagnosis entity) {
 *         return EndpointHelpers.put(entity);
 *     }
 *
 *     @DELETE
 *     @Path("{id}")
 *     public Response put(@PathParam("id") long id) {
 *         return EndpointHelpers.delete(Diagnosis.findById(id));
 *     }
 * }
 * </code>
 */
public final class EndpointHelpers {
    private  EndpointHelpers() {
    }

    public static <T extends PanacheEntityBase> Response get(T entity) {
        if(entity != null) {
            return Response.ok().entity(entity).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    public static <T extends PanacheEntityBase> Response getMany(List<T> entities) {
        return Response.ok().entity(entities).build();
    }

    public static <T extends PanacheEntity> Response post(T entity) {
        try {
            entity.persist(); // And flush?
        } catch(PersistenceException e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        // Return the newly created entity
        return Response.ok(entity).build();
    }

    public static <T extends PanacheEntity> Response put(T entity) {
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

    public static <T extends PanacheEntity> Response delete(T entity) {
        if(entity != null) {
            entity.delete();
        }

        return Response.noContent().build();
    }
}
