import java.util.ArrayList;

/***
 * 
 * @author Olfa
 *
 */
public class SuiteFarey {

	/**Ordre de la suite*/
	private int n=0;
	/**Elements de la suite*/
	private ArrayList <Fraction> suiteFarey= new ArrayList<Fraction>();
	
	/**Constructeur*/
	public SuiteFarey(int n){
		this.n=n;
		this.suiteFarey=calculSuite(this.n);
	}
	
	
	/**Calcul des termes de la suite */
	public ArrayList <Fraction> calculSuite(int p){
		if (p==1){	
			suiteFarey.add(new Fraction(0,1));
			suiteFarey.add(new Fraction(1,1));
		}	
		if (p>1){
			calculSuite(p-1);
			for (int i=1;i<p;i++){
				if (pgcd(i,p)==1){
					suiteFarey.add(new Fraction (i,p));
				}
			}
		}		
		tri();
		return suiteFarey;
	}

	
		
	//tri selection itératif
	public void tri(){
			
		ArrayList <Float> F=new ArrayList<Float>();
		
		/**transformer les  Fraction en float*/
		for (int j=0;j<this.suiteFarey.size();j++){
			F.add(this.suiteFarey.get(j).getFloat());
		}
		
		for (int i=0;i<=F.size()-2;i++){
			int min=i;
			for(int j=i+1;j<F.size();j++) 
				if (F.get(j)<F.get(min)) min=j;	
					if (min!=i) {
						/**permutation*/
						Fraction f=new Fraction(suiteFarey.get(i).getNumerator(),suiteFarey.get(i).getDenominator());
						suiteFarey.set(i, suiteFarey.get(min));
						F.set(min, f.getFloat());
					}
				}
	}
		
		
		
		/**Calcul du pgcd*/
		static int pgcd (int a, int b) { 

			    if(a<b) 
			      return (pgcd(b,a));
			    else if(b==0) 
			      return (a);
			    else
			      return (pgcd(b,a%b));

		}
	
	

	public int getN() {
		return n;
	}

	public ArrayList<Fraction> getSuiteFarey() {
		tri();
		return suiteFarey;
	}



	@Override
	public String toString() {
		String str=  "SuiteFarey [n=" + n  + "] : ";
		
		for (int i=0;i<this.suiteFarey.size();i++){
			str += this.suiteFarey.get(i).ToString()+ " ; ";
		}
		return str;
	}
		
}
