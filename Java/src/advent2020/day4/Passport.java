package advent2020.day4;

public class Passport {

	int birthYear;
	int issueYear;
	int expirationYear;

	int passportID;
	int countryID;

	String eyeColor;
	String hairColor;

	int height;

	boolean valid = false;

	public Passport(String info) {

		String[] fields = info.split(" ");
		if (fields.length >= 8 || (!info.contains("cid") && fields.length >= 7)) {
			valid = true;
		}
	}


	public boolean isValid() {
		return valid;
	}

	public int getValidFields(){
		int validField = 0;


		return validField;
	}
}
