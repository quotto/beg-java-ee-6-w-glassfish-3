package org.beginningee6.book.chapter15;

import java.net.URI;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;


@Path("/books")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Stateless
public class BookRessource {
    @PersistenceContext(unitName = "chapter15PU")
    private EntityManager em;
    @Context
    private UriInfo uriInfo;

    @POST
    public Response createNewBook(JAXBElement<Book> bookJaxb) {
        Book book = bookJaxb.getValue();
        em.persist(book);
        URI uri = uriInfo.getAbsolutePathBuilder().path(book.getId().toString()).build();
        return Response.created(uri).build();
    }

    @GET
    @Path("{id}/")
    public Book getBookById(@PathParam("id") Long id) {
        Book book = em.find(Book.class, id);
        return book;
    }

    @DELETE
    @Path("{id}/")
    public void deleteBook(@PathParam("id") Long id) {
        Book book = em.find(Book.class, id);
        em.remove(book);
    }

    @GET
    @Path("/")
    public List<Book> getAllBooks() {
        Query query = em.createNamedQuery(Book.FIND_ALL);
        List<Book> books = query.getResultList();
        return books;
    }

}
