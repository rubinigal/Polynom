import java.util.ArrayList;

public class Polynom {
	private ArrayList<PolynomStruct> polynom = new ArrayList<>();
	
	// We will take two arrays and merge then into one polynom elements array 
	public Polynom(double[] numbers, int[] powers) throws Exception {
		 if (numbers.length != powers.length) {
	            throw new Exception("Error: Two arrays with different lengths!");
	        }
	        for (int i = 0; i < powers.length; i++) {
	            polynom.add(i, new PolynomStruct(numbers[i], powers[i]));
	        }
	        sort(polynom);
	}
	
	// Makes a copy of the array filled with PolynomStruct elements
	public Polynom(ArrayList<PolynomStruct> polynom) {
        this.polynom = new ArrayList<>(polynom);
    }
	
	// Getter
    public ArrayList<PolynomStruct> getPolynom()
    {
        return this.polynom;
    }
    
    // We will sort the array based on the numbers power
    public void sort(ArrayList<PolynomStruct> polynom)
    {
    	//A loop to sort the array
        for (int i = 0; i < polynom.size(); i++) {
            for (int j = i + 1; j < polynom.size(); j++) {
                if (polynom.get(i).getPower() < polynom.get(j).getPower()) {
                	PolynomStruct temp = polynom.get(i);
                    polynom.set(i, polynom.get(j));
                    polynom.set(j, temp);
                }
            }
        }
        // merge same powers
        for (int i = 0, j = 1; j < polynom.size(); i++, j++) {
            if (polynom.get(i).getPower() == polynom.get(j).getPower()) {
                polynom.set(j, new PolynomStruct(polynom.get(i).getNumber() + polynom.get(j).getNumber(), polynom.get(j).getPower()));
                polynom.remove(i);
            }
        }
    }
    
    // Adds one polynom to another
    public Polynom plus(Polynom polynom) {
        Polynom newPolynom = new Polynom(this.polynom);
        boolean match;
        for (int i = 0; i < polynom.polynom.size(); i++) {
            match = false;
            int currentPower = polynom.polynom.get(i).getPower();
            int j = 0;
            while (j < newPolynom.polynom.size() && !match) {
                int newPower = newPolynom.polynom.get(j).getPower();
                if (newPower == currentPower) {
                	newPolynom.polynom.set(j, new PolynomStruct(polynom.polynom.get(i).getNumber() + 
                												newPolynom.polynom.get(j).getNumber(), currentPower));
                	match = true;
                }
                j++;
            }
            // We did not find a pair with the same power so we add it to array as is
            if (!match) {
            	newPolynom.polynom.add(0, polynom.polynom.get(i));
            }
        }
        newPolynom.sort(newPolynom.getPolynom());
        return newPolynom;
    }
    
    // The minus function is the same as plus we just multiply the the second array elements by -1
    public Polynom minus(Polynom polynom) {
    	Polynom newPolynom = new Polynom(polynom.getPolynom());
        for (int i = 0; i < newPolynom.polynom.size(); i++) {
        	newPolynom.polynom.set(i, new PolynomStruct(-1 * newPolynom.polynom.get(i).getNumber(), newPolynom.polynom.get(i).getPower()));
        }
        return new Polynom(this.polynom).plus(newPolynom);
    }
    
    // The derivative function
    public Polynom derivative() {
    	Polynom newPolynom = new Polynom(this.polynom);
    	for (int i = 0; i < newPolynom.polynom.size(); i++) {
    		int power =  newPolynom.polynom.get(i).getPower();
    		if (power != 0) {
    			double number =  newPolynom.polynom.get(i).getNumber();
    			newPolynom.polynom.set(i, new PolynomStruct(power * number, power - 1));
    		} else {
    			newPolynom.polynom.remove(i);
    		}
    	}
    	return newPolynom;
    }
    
    // Override for toString
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < this.polynom.size() - 1; i++) {
        	// Using PolynomStruct toString
            str.append(polynom.get(i).toString());
        }
        // Last element so we need to check if we need 'x' and its power
        if (this.polynom.get(this.polynom.size() - 1).getPower() == 0) {
            if (this.polynom.get(this.polynom.size() - 1).getNumber() < 0) {
                str.append(this.polynom.get(this.polynom.size() - 1).getNumber());
            } else {
                str.append("+").append(this.polynom.get(this.polynom.size() - 1).getNumber());
            }
        } else {
            str.append(polynom.get(this.polynom.size() - 1).toString());
        }
        return str.toString();
    }
    
    // Override for equals
    public boolean equals(Object polynom) {
        if (polynom instanceof Polynom) {
            if (this.polynom.size() != ((Polynom) polynom).polynom.size())
                return false;
            for (int i = 0; i < this.polynom.size(); i++) {
                if (this.polynom.get(i).getNumber() != ((Polynom)polynom).polynom.get(i).getNumber() || 
                	this.polynom.get(i).getPower() != ((Polynom)polynom).polynom.get(i).getPower())
                    return false;
            }
            return true;
        } else {
            System.out.println("Object type is not a Polynom");
            return false;
        }
    }
}
