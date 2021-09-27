package fr.jabbytechs.eclipse.news.demo.model;

import java.math.BigDecimal;

public class ConversionResult {

	private ConversionUnit origin;
	private ConversionUnit target;
	private BigDecimal initialValue;
	private BigDecimal resultValue;
	
	public ConversionResult(ConversionUnit origin, ConversionUnit target, BigDecimal initialValue,
			BigDecimal resultValue) {
		this.origin = origin;
		this.target = target;
		this.initialValue = initialValue;
		this.resultValue = resultValue;
	}

	public ConversionUnit getOrigin() {
		return origin;
	}

	public void setOrigin(ConversionUnit origin) {
		this.origin = origin;
	}

	public ConversionUnit getTarget() {
		return target;
	}

	public void setTarget(ConversionUnit target) {
		this.target = target;
	}

	public BigDecimal getInitialValue() {
		return initialValue;
	}

	public void setInitialValue(BigDecimal initialValue) {
		this.initialValue = initialValue;
	}

	public BigDecimal getResultValue() {
		return resultValue;
	}

	public void setResultValue(BigDecimal resultValue) {
		this.resultValue = resultValue;
	}

}
