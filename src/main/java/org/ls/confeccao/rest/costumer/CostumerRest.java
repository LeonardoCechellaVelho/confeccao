package org.ls.confeccao.rest.costumer;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.ls.confeccao.data.entities.Costumer;
import org.ls.confeccao.data.models.CostumerModel;
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

public interface CostumerRest {
    @POST
    @Path("/add")
    @Operation(summary = "Add Costumer", description = "Add Costumer")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses(value = {
        @APIResponse(responseCode = "200", description = "Costumer added!", 
                     content = @Content(mediaType = MediaType.APPLICATION_JSON, 
                     schema = @Schema(implementation = CostumerResponse.class))),
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
    CostumerResponse addCostumer(@RequestBody(name = "Update Costumer", description = "Costumer data") CostumerModel request);

    @POST
    @Path("/update")
    @Operation(summary = "Update Costumer", description = "Update Costumer")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses(value = {
        @APIResponse(responseCode = "200", description = "Costumer updated!", 
                     content = @Content(mediaType = MediaType.APPLICATION_JSON, 
                     schema = @Schema(implementation = CostumerResponse.class))),
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
    CostumerResponse updateCostumer(@RequestBody(name = "Update Costumer", description = "Costumer data") Costumer request);

    @GET
    @Path("/get")
    @Operation(summary = "Get Costumer", description = "Get Costumer")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses(value = {
        @APIResponse(responseCode = "200", description = "Costumer found!", 
                     content = @Content(mediaType = MediaType.APPLICATION_JSON, 
                     schema = @Schema(implementation = CostumerResponse.class))),
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
    CostumerResponse getCostumer(@HeaderParam("code") String code);

    @GET
    @Path("/get/all")
    @Operation(summary = "Get Costumers", description = "Get Costumers")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses(value = {
        @APIResponse(responseCode = "200", description = "Costumers found!", 
                     content = @Content(mediaType = MediaType.APPLICATION_JSON, 
                     schema = @Schema(implementation = CostumerResponse.class))),
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
    CostumersResponse getCostumers();
}
