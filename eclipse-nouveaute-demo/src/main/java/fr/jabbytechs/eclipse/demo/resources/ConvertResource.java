package fr.jabbytechs.eclipse.demo.resources;

import java.math.BigDecimal;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.jabbytechs.eclipse.demo.model.ConversionResult;
import fr.jabbytechs.eclipse.demo.model.ConversionUnit;
import fr.jabbytechs.eclipse.demo.services.ConversionService;

@Path("/convert")
public class ConvertResource {

	@Inject
	ConversionService conversionService;

	@Path("/{value}/{originUnit}/{targetUnit}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@GET
	public ConversionResult convert(@PathParam("value") String value, @PathParam("originUnit") String originUnit,
			@PathParam("targetUnit") String targetUnit) {

		return conversionService.convert(new BigDecimal(value), ConversionUnit.valueOf(originUnit), ConversionUnit.valueOf(targetUnit));
	}

}
