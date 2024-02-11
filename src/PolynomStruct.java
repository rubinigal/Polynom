
public class PolynomStruct {
	private int power;
    private double number;
    
    public PolynomStruct(double number, int power) {
        this.power = power;
        this.number = number;
    }
    
    public int getPower() {
        return this.power;
    }
    
    public double getNumber() {
        return this.number;
    }
    
    public String toString() {
        String str = "";
        if (this.number < 0) {
        	if (this.number == -1)
        		str = str + '-' + "x";
        	else
        		str = str + this.number + "x";
        } else if (this.number > 0) {
        	if (this.number == 1)
        		str = str + '+' + "x";
        	else
        		str = str + '+' + this.number + "x";
        }
        if (this.power > 1) {
            str = str + "^" + this.power;
        }
        return str;
    }
}
