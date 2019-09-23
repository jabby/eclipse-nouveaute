package fr.jabbytechs.eclipse.demo.services;

import static fr.jabbytechs.eclipse.demo.model.ConversionUnit.ATTOMETRE;
import static fr.jabbytechs.eclipse.demo.model.ConversionUnit.CENTIMETRE;
import static fr.jabbytechs.eclipse.demo.model.ConversionUnit.CHAIN;
import static fr.jabbytechs.eclipse.demo.model.ConversionUnit.DECAMETRE;
import static fr.jabbytechs.eclipse.demo.model.ConversionUnit.DECIMETRE;
import static fr.jabbytechs.eclipse.demo.model.ConversionUnit.EXAMETRE;
import static fr.jabbytechs.eclipse.demo.model.ConversionUnit.FEMTOMETRE;
import static fr.jabbytechs.eclipse.demo.model.ConversionUnit.FOOT;
import static fr.jabbytechs.eclipse.demo.model.ConversionUnit.FURLONG;
import static fr.jabbytechs.eclipse.demo.model.ConversionUnit.GIGAMETRE;
import static fr.jabbytechs.eclipse.demo.model.ConversionUnit.HECTOMETRE;
import static fr.jabbytechs.eclipse.demo.model.ConversionUnit.INCH;
import static fr.jabbytechs.eclipse.demo.model.ConversionUnit.KILOMETRE;
import static fr.jabbytechs.eclipse.demo.model.ConversionUnit.LEAGUE;
import static fr.jabbytechs.eclipse.demo.model.ConversionUnit.MEGAMETRE;
import static fr.jabbytechs.eclipse.demo.model.ConversionUnit.METRE;
import static fr.jabbytechs.eclipse.demo.model.ConversionUnit.MICROMETRE;
import static fr.jabbytechs.eclipse.demo.model.ConversionUnit.MILE;
import static fr.jabbytechs.eclipse.demo.model.ConversionUnit.MILLIMETRE;
import static fr.jabbytechs.eclipse.demo.model.ConversionUnit.NANOMETRE;
import static fr.jabbytechs.eclipse.demo.model.ConversionUnit.PETAMETRE;
import static fr.jabbytechs.eclipse.demo.model.ConversionUnit.PICOMETRE;
import static fr.jabbytechs.eclipse.demo.model.ConversionUnit.TERAMETRE;
import static fr.jabbytechs.eclipse.demo.model.ConversionUnit.THOU;
import static fr.jabbytechs.eclipse.demo.model.ConversionUnit.YARD;
import static fr.jabbytechs.eclipse.demo.model.ConversionUnit.YOCTOMETRE;
import static fr.jabbytechs.eclipse.demo.model.ConversionUnit.YOTTAMETRE;
import static fr.jabbytechs.eclipse.demo.model.ConversionUnit.ZEPTOMETRE;
import static fr.jabbytechs.eclipse.demo.model.ConversionUnit.ZETTAMETRE;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

import fr.jabbytechs.eclipse.demo.model.Conversion;
import fr.jabbytechs.eclipse.demo.model.ConversionResult;
import fr.jabbytechs.eclipse.demo.model.ConversionUnit;

@ApplicationScoped
public class ConversionService implements Service {

	
	private static final List<Conversion> conversions = new ArrayList<>(); 
	
	public List<Conversion> getAvailableConversion(ConversionUnit conversionUnit) {
		
		if (conversionUnit != null) {
			
			System.out.println("Filter is : " + conversionUnit.name());
	
			
			return conversions.stream().filter((Conversion conversion) -> {
				return conversion.getOrigin() == conversionUnit || conversion.getTarget() == conversionUnit;
			})
			.collect(Collectors.toList());
		}
		return getAllAvailableConversion();
	}
	
	public List<Conversion> getAllAvailableConversion() {
		return conversions;
	}

	public ConversionResult convert(BigDecimal value, ConversionUnit origin, ConversionUnit target) {
		
		Conversion currentConversion = null;
		for (int i = 0; i < conversions.size(); i++) {
			currentConversion = conversions.get(i);
			
			if (currentConversion.getOrigin() == origin && currentConversion.getTarget() == target) {
				break;
			}
		}
		
		if (currentConversion != null) {
			return new ConversionResult(origin, target, value, value.multiply(currentConversion.getRelationToTarget()));
		}
		
		return new ConversionResult(origin, target, value, value);
	}
	
	
	@PostConstruct
	void initData() {
		
		
		
		//TODO : add all conversions
		
		MathContext mathContext = new MathContext(12);
		
		conversions.clear();
		conversions.add(new Conversion(ConversionUnit.METRE, YOCTOMETRE, BigDecimal.ONE.divide(BigDecimal.TEN, mathContext)));
		conversions.add(new Conversion(ConversionUnit.METRE, ZEPTOMETRE, BigDecimal.ONE.divide(BigDecimal.TEN, mathContext)));
		conversions.add(new Conversion(ConversionUnit.METRE, ATTOMETRE, BigDecimal.ONE.divide(BigDecimal.TEN, mathContext)));
		conversions.add(new Conversion(ConversionUnit.METRE, FEMTOMETRE, BigDecimal.ONE.divide(BigDecimal.TEN, mathContext)));
		conversions.add(new Conversion(ConversionUnit.METRE, PICOMETRE, BigDecimal.ONE.divide(BigDecimal.TEN, mathContext)));
		conversions.add(new Conversion(ConversionUnit.METRE, NANOMETRE, BigDecimal.ONE.divide(BigDecimal.TEN, mathContext)));
		conversions.add(new Conversion(ConversionUnit.METRE, MICROMETRE, BigDecimal.ONE.divide(BigDecimal.TEN, mathContext)));
		conversions.add(new Conversion(ConversionUnit.METRE, MILLIMETRE, BigDecimal.ONE.divide(BigDecimal.TEN, mathContext)));
		conversions.add(new Conversion(ConversionUnit.METRE, CENTIMETRE, BigDecimal.ONE.divide(BigDecimal.TEN, mathContext)));
		conversions.add(new Conversion(ConversionUnit.METRE, DECIMETRE, BigDecimal.ONE.divide(BigDecimal.TEN, mathContext)));
		conversions.add(new Conversion(ConversionUnit.METRE, METRE, BigDecimal.ONE));
		conversions.add(new Conversion(ConversionUnit.METRE, DECAMETRE, BigDecimal.ONE.multiply(BigDecimal.TEN, mathContext)));
	    conversions.add(new Conversion(ConversionUnit.METRE, HECTOMETRE, BigDecimal.ONE.multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext)));
        conversions.add(new Conversion(ConversionUnit.METRE, KILOMETRE, BigDecimal.ONE.multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext)));
        conversions.add(new Conversion(ConversionUnit.METRE, MEGAMETRE, BigDecimal.ONE.multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext)));
        conversions.add(new Conversion(ConversionUnit.METRE, GIGAMETRE, BigDecimal.ONE.multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext)));
        conversions.add(new Conversion(ConversionUnit.METRE, TERAMETRE, BigDecimal.ONE.multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext)));
        conversions.add(new Conversion(ConversionUnit.METRE, PETAMETRE, BigDecimal.ONE.multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext)));
        conversions.add(new Conversion(ConversionUnit.METRE, EXAMETRE, BigDecimal.ONE.multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext)));
        conversions.add(new Conversion(ConversionUnit.METRE, ZETTAMETRE, BigDecimal.ONE.multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext)));
        conversions.add(new Conversion(ConversionUnit.METRE, YOTTAMETRE, BigDecimal.ONE.multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext).multiply(BigDecimal.TEN, mathContext)));
        
        
        
        conversions.add(new Conversion(METRE, THOU, BigDecimal.ONE.divide(new BigDecimal("0.0000254"), mathContext)));       
        conversions.add(new Conversion(METRE, INCH, BigDecimal.ONE.divide(new BigDecimal("0.0254") , mathContext)));       
        conversions.add(new Conversion(METRE,FOOT, BigDecimal.ONE.divide(new BigDecimal("0.3048") , mathContext)));       
        conversions.add(new Conversion(METRE, YARD, BigDecimal.ONE.divide(new BigDecimal("0.9144") , mathContext)));       
        conversions.add(new Conversion(METRE, CHAIN, BigDecimal.ONE.divide(new BigDecimal("20.1168") , mathContext)));       
        conversions.add(new Conversion(METRE, FURLONG, BigDecimal.ONE.divide(new BigDecimal("201.168") , mathContext)));       
        conversions.add(new Conversion(METRE, MILE, BigDecimal.ONE.divide(new BigDecimal("1609.344") , mathContext)));       
        conversions.add(new Conversion(METRE, LEAGUE, BigDecimal.ONE.divide(new BigDecimal("4828.032") , mathContext)));      
        
        conversions.add(new Conversion( THOU, METRE,BigDecimal.ONE.multiply(new BigDecimal("0.0000254") , mathContext)));       
        conversions.add(new Conversion( INCH, METRE,BigDecimal.ONE.multiply(new BigDecimal("0.0254") , mathContext)));       
        conversions.add(new Conversion(FOOT, METRE,BigDecimal.ONE.multiply(new BigDecimal("0.3048") , mathContext)));       
        conversions.add(new Conversion( YARD, METRE,BigDecimal.ONE.multiply(new BigDecimal("0.9144") , mathContext)));       
        conversions.add(new Conversion( CHAIN,METRE, BigDecimal.ONE.multiply(new BigDecimal("20.1168") , mathContext)));       
        conversions.add(new Conversion( FURLONG, METRE, BigDecimal.ONE.multiply(new BigDecimal("201.168") , mathContext)));       
        conversions.add(new Conversion( MILE, METRE,BigDecimal.ONE.multiply(new BigDecimal("1609.344") , mathContext)));       
        conversions.add(new Conversion( LEAGUE, METRE,BigDecimal.ONE.multiply(new BigDecimal("4828.032") , mathContext)));
        
	}



}
