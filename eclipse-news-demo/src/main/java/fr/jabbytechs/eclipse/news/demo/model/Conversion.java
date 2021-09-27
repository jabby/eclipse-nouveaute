package fr.jabbytechs.eclipse.news.demo.model;

import java.math.BigDecimal;

public class Conversion {
	public final ConversionUnit origin;
	public final ConversionUnit target;
	public final BigDecimal relationToTarget;
	
	public Conversion(ConversionUnit origin, ConversionUnit target, BigDecimal relationToTarget) {
		this.origin = origin;
		this.target = target;
		this.relationToTarget = relationToTarget;
	}

	public ConversionUnit getOrigin() {
		return origin;
	}

	public ConversionUnit getTarget() {
		return target;
	}

	public BigDecimal getRelationToTarget() {
		return relationToTarget;
	}
}
