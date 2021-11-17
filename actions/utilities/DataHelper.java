package utilities;

import com.github.javafaker.Faker;

public class DataHelper {
	private Faker faker;

	public static DataHelper getData() {
		return new DataHelper();
	}

	public DataHelper() {
		faker = new Faker();
	}

	public String getFirstName() {
		return faker.name().firstName();
	}

	public String getLastName() {
		return faker.name().lastName();
	}

	public String getFullName() {
		return faker.name().fullName();
	}

	public String getUserName() {
		return faker.name().username();
	}

	public String getPassword() {
		return faker.internet().password();
	}
	public String getEditFirstName() {
		return faker.name().firstName();
	}
	
	public String getEditLastName() {
		return faker.name().lastName();
	}
	public String cardNumber() {
		return faker.finance().creditCard();
	}
}
