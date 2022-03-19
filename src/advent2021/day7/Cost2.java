package advent2021.day7;

public class Cost2 implements Cost {

	@Override
	public int calc(int diff) {
		
		return diff*(diff+1)/2;
	}

}
