package polynomialClassProblem;

public class Polynomial {
	private int arr[], arr1[];
	
	/* This function sets coefficient for a particular degree value, if degree is not there in the polynomial
	 *  then corresponding term(with specified degree and value is added int the polynomial. If the degree
	 *  is already present in the polynomial then previous coefficient is replaced by
	 *  new coefficient value passed as function argument
	*/
    public Polynomial(){
        arr = new int[5];
    }
    
	public void setCoefficient(int degree, int coeff){
		if(degree < arr.length)
			arr[degree] = coeff;
		else {
            while(arr.length <= degree){
                arr1 = new int[arr.length];
                for(int i = 0; i < arr1.length; i ++)
                    arr1[i] = arr[i];

                arr = new int[2 * arr1.length];

                for(int i = 0; i < arr1.length; i ++)
                    arr[i] = arr1[i];
            }
            arr[degree] = coeff;
			
		}
	}
	
	// Prints all the terms(only terms with non zero coefficients are to be printed) in increasing order of degree. 
	public void print(){
		for(int i = 0; i < arr.length; i ++)
			if(arr[i] != 0)
				System.out.print(arr[i] + "x" + i + " ");
		System.out.println();
	}

	
	// Adds two polynomials and returns a new polynomial which has result
	public Polynomial add(Polynomial p){
		if(this.arr.length > p.arr.length) {
			p.setCoefficient(this.arr.length - 1, 0);
		}
		else if(this.arr.length < p.arr.length) {
			this.setCoefficient(p.arr.length - 1, 0);
		}
		for(int i = 0; i < this.arr.length; i ++)
			this.arr[i] += p.arr[i];
		return this;
	}
	
	// Subtracts two polynomials and returns a new polynomial which has result
	public Polynomial subtract(Polynomial p){
		if(this.arr.length > p.arr.length) {
			p.setCoefficient(this.arr.length - 1, 0);
		}
		else if(this.arr.length < p.arr.length) {
			this.setCoefficient(p.arr.length - 1, 0);
		}
		for(int i = 0; i < this.arr.length; i ++)
			this.arr[i] -= p.arr[i];
		return this;
	}
	
	// Multiply two polynomials and returns a new polynomial which has result
	public Polynomial multiply(Polynomial p){
		int length = (this.arr.length + p.arr.length);
		p.setCoefficient(length, 0);
		this.setCoefficient(length, 0);
		int ans[] = new int[this.arr.length];
		
		for(int i = 0; i < this.arr.length; i ++) {
			for(int j = 0; j < p.arr.length; j ++) {
				int res = this.arr[i] * p.arr[j];
				if(res != 0)
						ans[i + j] += res;
			}
		}
		
		for(int i = 0; i < ans.length; i ++)
			this.arr[i] = ans[i];
		return this;		
	}

}
