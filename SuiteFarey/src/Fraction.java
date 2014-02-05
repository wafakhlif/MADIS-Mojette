/***
 * 
 * @author Olfa
 */
public class Fraction {

	/**numérateur*/
	private int numerator;
	/**numérateur*/
	private int denominator;
	
	/**constructeur*/
	public Fraction(int numerator,int denominator){
		this.numerator=numerator;
		this.denominator=denominator;
	}

	public float getFloat(){
		return this.numerator/ this.denominator;
	}
	
	public double calculAngle(){
		double angle=Math.atan((double)denominator/(double) numerator);
		if(angle<0) angle+=Math.PI;
		return angle;
		
	}

	public boolean estValable(int ordre){
		return numerator <=ordre && denominator <=ordre;
	}
	
	public int getNumerator() {
		return numerator;
	}

	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}

	public int getDenominator() {
		return denominator;
	}

	public void setDenominator(int denominator) {
		this.denominator = denominator;
	}

	/**ToString method*/
	public String ToString(){
		return this.numerator+"/"+this.denominator;
	}


}
