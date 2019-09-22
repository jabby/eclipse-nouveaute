package fr.jabbytechs.eclipse.demo.resources;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import fr.jabbytechs.eclipse.demo.model.Conversion;
import fr.jabbytechs.eclipse.demo.model.ConversionUnit;
import fr.jabbytechs.eclipse.demo.services.ConversionService;

@Path("/conversions")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ConversionResource {

	
	@Inject
	ConversionService conversionService;
	
	@GET
	public List<Conversion> listConversions(@QueryParam("conversionUnit") String param) {
		ConversionUnit conversionUnit  = param != null ? ConversionUnit.valueOf(param) : null;
		return conversionService.getAvailableConversion(conversionUnit);
	}
}
