package org.ls.confeccao.rest.product;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.ls.confeccao.data.entities.Product;
import org.ls.confeccao.data.models.ProductModel;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

public interface ProductRest {
    @POST
    @Path("/add")
    @Operation(summary = "Add Product", description = "Add Product")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses(value = {
        @APIResponse(responseCode = "200", description = "Product added!", 
                     content = @Content(mediaType = MediaType.APPLICATION_JSON, 
                     schema = @Schema(implementation = ProductResponse.class))),
        @APIResponse(responseCode = "400", description = "Bad Request", 
                     content = @Content(mediaType = MediaType.APPLICATION_JSON, 
                     schema = @Schema(implementation = String.class))),
        @APIResponse(responseCode = "422", description = "Unprocessable content", 
                     content = @Content(mediaType = MediaType.APPLICATION_JSON, 
                     schema = @Schema(implementation = String.class))),
        @APIResponse(responseCode = "500", description = "System Error", 
                     content = @Content(mediaType = MediaType.APPLICATION_JSON, 
                     schema = @Schema(implementation = String.class)))
    })
    ProductResponse addProduct(@RequestBody(name = "Update Product", description = "Product data") ProductModel request);

    @POST
    @Path("/update")
    @Operation(summary = "Update Product", description = "Update Product")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses(value = {
        @APIResponse(responseCode = "200", description = "Product updated!", 
                     content = @Content(mediaType = MediaType.APPLICATION_JSON, 
                     schema = @Schema(implementation = ProductResponse.class))),
        @APIResponse(responseCode = "400", description = "Bad Request", 
                     content = @Content(mediaType = MediaType.APPLICATION_JSON, 
                     schema = @Schema(implementation = String.class))),
        @APIResponse(responseCode = "422", description = "Unprocessable content", 
                     content = @Content(mediaType = MediaType.APPLICATION_JSON, 
                     schema = @Schema(implementation = String.class))),
        @APIResponse(responseCode = "500", description = "System Error", 
                     content = @Content(mediaType = MediaType.APPLICATION_JSON, 
                     schema = @Schema(implementation = String.class)))
    })
    ProductResponse updateProduct(@RequestBody(name = "Update Product", description = "Product data") Product request);

    @GET
    @Path("/get")
    @Operation(summary = "Get Product", description = "Get Product")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses(value = {
        @APIResponse(responseCode = "200", description = "Product found!", 
                     content = @Content(mediaType = MediaType.APPLICATION_JSON, 
                     schema = @Schema(implementation = ProductResponse.class))),
        @APIResponse(responseCode = "400", description = "Bad Request", 
                     content = @Content(mediaType = MediaType.APPLICATION_JSON, 
                     schema = @Schema(implementation = String.class))),
        @APIResponse(responseCode = "422", description = "Unprocessable content", 
                     content = @Content(mediaType = MediaType.APPLICATION_JSON, 
                     schema = @Schema(implementation = String.class))),
        @APIResponse(responseCode = "500", description = "System Error", 
                     content = @Content(mediaType = MediaType.APPLICATION_JSON, 
                     schema = @Schema(implementation = String.class)))
    })
    ProductResponse getProduct(@HeaderParam("code") String code);

    @GET
    @Path("/get/all")
    @Operation(summary = "Get Products", description = "Get Products")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses(value = {
        @APIResponse(responseCode = "200", description = "Products found!", 
                     content = @Content(mediaType = MediaType.APPLICATION_JSON, 
                     schema = @Schema(implementation = ProductResponse.class))),
        @APIResponse(responseCode = "400", description = "Bad Request", 
                     content = @Content(mediaType = MediaType.APPLICATION_JSON, 
                     schema = @Schema(implementation = String.class))),
        @APIResponse(responseCode = "422", description = "Unprocessable content", 
                     content = @Content(mediaType = MediaType.APPLICATION_JSON, 
                     schema = @Schema(implementation = String.class))),
        @APIResponse(responseCode = "500", description = "System Error", 
                     content = @Content(mediaType = MediaType.APPLICATION_JSON, 
                     schema = @Schema(implementation = String.class)))
    })
    ProductsResponse getProducts();
}
