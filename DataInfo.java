package dataStalker;


public class DataInfo {

	public String startinginfo;
	public boolean hasNumber = false;
	private double number;
	public double diffrence;

	public double getNumber() {
		return number;
	}


	public void setNumber(double number) {
		this.number = number;
	}


	public double getDiffrence() {
		return diffrence;
	}


	public void setDiffrence(double diffrence) {
		this.diffrence = diffrence;
	}


	public DataInfo(String startinginfo) {
		super();
		this.startinginfo = startinginfo;
	}
	
	
	double getOnlyNumbers() {
		
		   try {
			   double numberOnly = getOnlyNums(startinginfo);
			   hasNumber = true ;
			   number = numberOnly;
			   return numberOnly;
		   }
		   catch(Exception e){
			   hasNumber = false;
			   return -.001;
		   }
	}
	boolean isDiffrent(String newInfo) {
		if(hasNumber) {
			double diff = diffrence(number,getOnlyNums(newInfo));
			if(diff==0) {
				return false;
			}
			diffrence = diff;
		}
		
		if(startinginfo.equals(newInfo)) {
			return false;
		}
		return true;
		
		
		
	}


	public String getStartinginfo() {
		return startinginfo;
	}


	public void setStartinginfo(String startinginfo) {
		this.startinginfo = startinginfo;
	}


	public boolean isHasNumber() {
		return hasNumber;
	}


	public void setHasNumber(boolean hasNumber) {
		this.hasNumber = hasNumber;
	}
	
	
	
	
	/**Object getOnlyNumbers() {
		char[] letters = startinginfo.toCharArray();
		Stream<Character> cStream = IntStream.range(0, letters.length).mapToObj(i -> letters[i]);
		Object[] ints = cStream.filter(let -> Character.isDigit( let)).toArray();
		Stream<Object> stream1 = Arrays.stream(ints);
        stream1.forEach(x -> (Integer)x);
		return ints;
	}
	**/
	double diffrence(double num, double num2) {
		return num2-num;
	}
	double getOnlyNums(String str) {
		double numberOnly = Double.parseDouble(str.replaceAll("[^0-9]", ""));
		return numberOnly;
	}
	
	
}
