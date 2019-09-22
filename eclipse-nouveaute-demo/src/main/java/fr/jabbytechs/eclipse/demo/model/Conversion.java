package fr.jabbytechs.eclipse.demo.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Conversion {

	private final ConversionUnit origin;
	private final ConversionUnit target;
	private BigDecimal relationToTarget;

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

	@Override
	public int hashCode() {
		return Objects.hash(origin, relationToTarget, target);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conversion other = (Conversion) obj;
		return origin == other.origin && Objects.equals(relationToTarget, other.relationToTarget)
				&& target == other.target;
	}

}
