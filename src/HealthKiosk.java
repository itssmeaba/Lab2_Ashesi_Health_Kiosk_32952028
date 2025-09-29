import java.util.Scanner;
public class HealthKiosk {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the Ashesi Health Kiosk!");

        //task 1: service code
        System.out.print("Enter service code (P/L/T/C): ");
        String serviceCode = input.nextLine();
        String service = "";

        switch (serviceCode) {
            case "P":
            case "p":
                service = "PHARMACY";
                System.out.println("Go to: Pharmacy Desk");
                break;
            case "L":
            case "l":
                service = "LAB";
                System.out.println("Go to: Lab Desk");
                break;
            case "T":
            case "t":
                service ="TRIAGE";
                System.out.println("Go to: Triage Desk");
                break;
            case "C":
            case "c":
                service = "COUNSELLING";
                System.out.println("Go to: Counselling Desk");
                break;
            default:
                System.out.println("Invalid service code");
                return;
        }
                //task 2: health metric

            System.out.print("Kindly enter a health metric: ");
            int metric = input.nextInt();

            double bmiRounded = 0;
            int tablets = 0;
            double sinRounded = 0;
            double cosRounded = 0;
            int metricValue = 0;

            switch (metric) {
                case 1:
                    System.out.print("Kindly enter your weight (in kg): ");
                    double weight = input.nextDouble();

                    System.out.print("Kindly enter your height (in m): ");
                    double height = input.nextDouble();
                    double bmi = weight / (height * height);
                    bmiRounded = Math.round(bmi * 10) / 10.0;

                    System.out.print("BMI: " + bmiRounded);

                    if (bmiRounded < 18.5) {
                        System.out.println("  Category: Underweight");
                    } else if (bmiRounded >= 18.5 && bmiRounded <= 24.9) {
                        System.out.println("  Category: Normal");
                    } else if (bmiRounded >= 25 && bmiRounded <= 29.9) {
                        System.out.println("  Category: Overweight");
                    } else if (bmiRounded >= 30) {
                        System.out.println("  Category: Obese");
                    }

                    metricValue = (int)Math.round(bmi);
                    break;
                case 2:
                    System.out.print("Kindly enter your dosage (in mg): ");
                    double dosage = input.nextDouble();
                    double tabletDosage = 250.0;

                    tablets = (int) Math.ceil(dosage / tabletDosage);
                    System.out.println("Number of tablets is " + tablets);
                    metricValue = tablets;
                    break;

                case 3:
                    System.out.print("Kindly enter a angle (in degrees): ");
                    double angle = input.nextDouble();
                    double radians = Math.toRadians(angle);

                    double sinValue = Math.sin(radians);
                    double cosValue = Math.cos(radians);

                    sinRounded = Math.round(sinValue * 1000) / 1000.0;
                    cosRounded = Math.round(cosValue * 1000) / 1000.0;
                    System.out.println("sin: " + sinRounded + ", cos: " + cosRounded);

                    metricValue = (int)Math.round(sinValue * 100);

                    break;

                default:
                    System.out.println("Invalid input");
                    return;
            }

            //task 3
            char randomLetter = (char)(65 + (int)(Math.random()*26));
            int no1 = 3 + (int)(Math.random()*7);
            int no2 = 3 + (int)(Math.random()*7);
            int no3 = 3 + (int)(Math.random()*7);
            int no4 = 3 + (int)(Math.random()*7);

            String studentID = "" + randomLetter + no1 + no2 + no3 + no4;

            if (studentID.length()!=5){
                System.out.println("Invalid length");
                return;
            }else if (!Character.isLetter(studentID.charAt(0))){
                System.out.println("Invalid: First char must be a letter");
                return;
            }else if (!Character.isDigit(studentID.charAt(1)) ||
                    !Character.isDigit(studentID.charAt(2)) ||
                    !Character.isDigit(studentID.charAt(3)) ||
                    !Character.isDigit(studentID.charAt(4)) ){
                System.out.println("Invalid: Last 4 chars must be digits");
                return;
            }else{
                System.out.println(studentID);
                System.out.println("ID OK");
            }

            //task 4
            input.nextLine();
            System.out.print("Kindly enter your name: ");
            String name = input.nextLine();

            char baseCode = Character.toUpperCase(name.charAt(0));
            char shiftedLetter = (char)('A' + (baseCode - 'A' + 2) % 26);

            char digit3 = studentID.charAt(3);
            char digit4 = studentID.charAt(4);

            String code = "" + shiftedLetter + digit3 + digit4 + "-" + metricValue;
            System.out.println("Display code: " + code);

            //task 5
            System.out.println(service + " | ID=" + studentID + " | Code=" + code);
    }
}