package org.ls.confeccao.rest.brand;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.ls.confeccao.data.entities.Brand;
import org.ls.confeccao.data.models.BrandModel;
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

public interface BrandRest {
    @POST
    @Path("/add")
    @Operation(summary = "Add Brand", description = "Add Brand")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses(value = {
        @APIResponse(responseCode = "200", description = "Brand added!", 
                     content = @Content(mediaType = MediaType.APPLICATION_JSON, 
                     schema = @Schema(implementation = BrandResponse.class))),
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
    BrandResponse addBrand(@RequestBody(name = "Update Brand", description = "Brand data") BrandModel request);

    @POST
    @Path("/update")
    @Operation(summary = "Update Brand", description = "Update Brand")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses(value = {
        @APIResponse(responseCode = "200", description = "Brand updated!", 
                     content = @Content(mediaType = MediaType.APPLICATION_JSON, 
                     schema = @Schema(implementation = BrandResponse.class))),
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
    BrandResponse updateBrand(@RequestBody(name = "Update Brand", description = "Brand data") Brand request);

    @GET
    @Path("/get")
    @Operation(summary = "Get Brand", description = "Get Brand")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses(value = {
        @APIResponse(responseCode = "200", description = "Brand found!", 
                     content = @Content(mediaType = MediaType.APPLICATION_JSON, 
                     schema = @Schema(implementation = BrandResponse.class))),
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
    BrandResponse getBrand(@HeaderParam("code") String code);

    @GET
    @Path("/get/all")
    @Operation(summary = "Get Brands", description = "Get Brands")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses(value = {
        @APIResponse(responseCode = "200", description = "Brands found!", 
                     content = @Content(mediaType = MediaType.APPLICATION_JSON, 
                     schema = @Schema(implementation = BrandResponse.class))),
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
    BrandsResponse getBrands();
}
