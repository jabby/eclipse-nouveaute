package fr.jabbytechs.eclipse.demo.model;

public enum ConversionUnit {

	YOCTOMETRE(ConversionSystem.INTERNATIONAL_SYSTEM, "ym"),
	ZEPTOMETRE(ConversionSystem.INTERNATIONAL_SYSTEM, "zm"),
	ATTOMETRE(ConversionSystem.INTERNATIONAL_SYSTEM, "am"),
	FEMTOMETRE(ConversionSystem.INTERNATIONAL_SYSTEM, "fm"),
	PICOMETRE(ConversionSystem.INTERNATIONAL_SYSTEM, "pm"),
	NANOMETRE(ConversionSystem.INTERNATIONAL_SYSTEM, "nm"),
	MICROMETRE(ConversionSystem.INTERNATIONAL_SYSTEM, "µm"),
	MILLIMETRE(ConversionSystem.INTERNATIONAL_SYSTEM, "mm"),
	CENTIMETRE(ConversionSystem.INTERNATIONAL_SYSTEM, "cm"),
	DECIMETRE(ConversionSystem.INTERNATIONAL_SYSTEM, "dm"),
	METRE(ConversionSystem.INTERNATIONAL_SYSTEM, "m"),
	DECAMETRE(ConversionSystem.INTERNATIONAL_SYSTEM, "dam"),
	HECTOMETRE(ConversionSystem.INTERNATIONAL_SYSTEM, "hm"),
	KILOMETRE(ConversionSystem.INTERNATIONAL_SYSTEM, "km"),
	MEGAMETRE(ConversionSystem.INTERNATIONAL_SYSTEM, "Mm"),
	GIGAMETRE(ConversionSystem.INTERNATIONAL_SYSTEM, "Gm"),
	TERAMETRE(ConversionSystem.INTERNATIONAL_SYSTEM, "Tm"),
	PETAMETRE(ConversionSystem.INTERNATIONAL_SYSTEM, "Pm"),
	EXAMETRE(ConversionSystem.INTERNATIONAL_SYSTEM, "Em"),
	ZETTAMETRE(ConversionSystem.INTERNATIONAL_SYSTEM, "Zm"),
	YOTTAMETRE(ConversionSystem.INTERNATIONAL_SYSTEM, "Ym"),

	
	THOU(ConversionSystem.IMPERIAL, "th"), 
	INCH(ConversionSystem.IMPERIAL, "in"),
	FOOT(ConversionSystem.IMPERIAL, "ft"), 
	YARD(ConversionSystem.IMPERIAL, "yd"),
	CHAIN(ConversionSystem.IMPERIAL, "ch"),
	FURLONG(ConversionSystem.IMPERIAL, "fur"),
	MILE(ConversionSystem.IMPERIAL, "mile"),
	LEAGUE(ConversionSystem.IMPERIAL, "lea"),
	
	; 
	
	
	
	private final String unit;
	private final ConversionSystem system;
	
	private ConversionUnit(ConversionSystem system, String unit) {
		this.system = system;
		this.unit = unit;
	}

	public String getUnit() {
		return unit;
	}

	public ConversionSystem getSystem() {
		return system;
	}
}
