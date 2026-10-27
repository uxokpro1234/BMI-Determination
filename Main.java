import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static double weight, height, BMI;

    public static void main(String[] args){

        while(true){
            Double weightInput = readPositiveDouble("Enter your weight (kg): ");
            if(weightInput == null) return;
            weight = weightInput;

            Double heightInput = readPositiveDouble("Enter your height (cm): ");
            if(heightInput == null) return;

            height = heightInput / 100.0;
            BMI = weight / (height * height);

            System.out.printf("Your BMI: %.1f%n", BMI);

            if(BMI < 18.5) System.out.println("Underweight");
            else if(BMI < 25.0) System.out.println("Healthy weight range");
            else if(BMI < 30.0) System.out.println("Overweight");
            else if(BMI < 35.0) System.out.println("Class 1 obesity");
            else if(BMI < 40.0) System.out.println("Class 2 obesity");
            else System.out.println("Class 3 obesity");

            while(true){
                System.out.print("Do you want to continue? (Y/N): ");
                if(!scanner.hasNext()) return;
                String c = scanner.next().trim();
                if(c.equalsIgnoreCase("Y")){
                    System.out.println();
                    break;
                }
                else if(c.equalsIgnoreCase("N")){
                    System.out.println("Goodbye!");
                    return;
                }
                else{
                    System.out.println("Invalid input! Enter Y or N.");
                }
            }
        }
    }

    public static Double readPositiveDouble(String prompt){
        while(true){
            System.out.print(prompt);

            if(!scanner.hasNext()) return null;

            if(!scanner.hasNextDouble()){
                scanner.next(); // FUCK INVALID INPUT
                System.out.println("Invalid input! Enter a number.");
                continue;
            }

            double value = scanner.nextDouble();
            if(!Double.isFinite(value) || value <= 0){
                System.out.println("Enter a finite number greater than zero!");
                continue;
            }
            return value;
        }
    }
}
