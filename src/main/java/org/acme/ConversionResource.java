package org.acme;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/Conversion")
public class ConversionResource {

    // Conversion of Kilometers per Hour to Miles per Hour (POST method)
    @POST
    @Path("/km-to-miles")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public Response convertKmToMiles(String km) {
        double kilometers = Double.parseDouble(km);
        double miles = kilometers * 0.621371;
        return Response.ok(String.format("%.5f", miles)).build(); // Returns with decimal point
    }
    
    @GET
    @Path("/knots-to-km/{value}")
    @Produces(MediaType.APPLICATION_JSON)
    public ConversionResult convertKnotsToKm(@PathParam("value") double knots) {
        double kmh = knots * 1.852;
        return new ConversionResult(kmh); // Certifique-se de que ConversionResult é um POJO com um campo para o valor.
    }
    
    
    

    public class ConversionResult {
        private double value;
    
        public ConversionResult(double value) {
            this.value = value;
        }
    
        public double getValue() {
            return value;
        }
    
        // Opcional: Override toString() para debug
        @Override
        public String toString() {
            return "ConversionResult{" + "value=" + value + '}';
        }
    }
}