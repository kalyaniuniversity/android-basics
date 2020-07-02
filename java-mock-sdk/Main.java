import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int choice;
		Converter converter;
		TemperatureConverter temperatureConverter;
		SpeedConverter speedConverter;

		p("Enter Choice:");
		p("Press 1 for Thermometer.");
		p("Press 2 for Thermocouple.");
		p("Press 3 for PitotTube.");
		p("Press 4 for ShaftLog.");
		p("\nYour choice: ");

		choice = Integer.parseInt(br.readLine());

		while(choice < 1 || choice > 4) {
			p("Wrong input. Try again.");
			p("Your choice: ");
			choice = Integer.parseInt(br.readLine());
		}

		switch(choice) {
			case 1: converter = new Thermometer(); break;
			case 2: converter = new Thermocouple(); break;
			case 3: converter = new PitotTube(); break;
			default: converter = new ShaftLog(); break;
		}

		System.out.println("converted value: " + converter.convert(30.0d));

		if(choice < 3) {
			temperatureConverter = (TemperatureConverter) converter;
			System.out.println("Is hot? " + temperatureConverter.isHot(50.0d));
		} else {
			speedConverter = (SpeedConverter) converter;
			System.out.println("Is fast? " + speedConverter.isFast(100.5d));
		}
	}

	private static void p(Object object) {
		System.out.println(object);
	}
}