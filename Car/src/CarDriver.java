import java.util.Locale;
import java.util.Scanner;

public class CarDriver {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int carCommand = 0;
        String gearCommand = "";
        String steerCommand = "";
        double speed = 0.0;
        Car car = new Car();
        while(true){
            if(car.getCurSpeed() > 0){
                car.setFuelTank(car.getCurSpeed());
            }
            if(car.tank.getTank() <= 0){
                System.out.println("You're out of gas!!");
                break;
            }
            car.carStatus();
            System.out.println("Your Car Commands: (Enter number that matches)\n" +
                    "1.engine start\n" +
                    "2.engine stop\n" +
                    "3.gear commands\n" +
                    "4.steer commands\n" +
                    "5.accel\n" +
                    "6.decel\n" +
                    "7.exit");
            carCommand = input.nextInt();
            switch (carCommand){
                case 1: car.turnEngineON();
                    break;
                case 2: car.turnEngineOFF();
                    break;
                case 3: System.out.println("gear -R: Set car in Reverse\n" +
                            "gear -D: Set car in Drive\n" +
                            "gear -P: Set car in Park");
                    gearCommand = input.next().toUpperCase();
                    switch (gearCommand){
                        case "R":
                            if(car.getCurSpeed() == 0 || car.getCurSpeed() == 5){
                                car.reverse();
                            }
                            else {
                                System.out.println("Cant switch gears while the car is driving");
                            }
                            break;
                        case "D":
                            if(car.getCurSpeed() == 0 || car.getCurSpeed() == 5){
                                car.drive();
                            }
                            else {
                                System.out.println("Cant switch gears while the car is driving");
                            }
                            break;
                        case "P":
                            if(car.getCurSpeed() == 0 || car.getCurSpeed() == 5){
                                car.park();
                            }
                            else {
                                System.out.println("Cant switch gears while the car is driving");
                            }
                            break;
                        default:
                            System.out.println("Invalid command! back to car commands");
                    }
                    break;
                case 4: System.out.println("steer -L: Steer left\n" +
                            "steer -R: Steer right\n" +
                            "steer -N: Steer to neutral (car goes straight)");
                        steerCommand = input.next().toUpperCase();
                    switch (steerCommand){
                        case "L": car.turnLeft();
                            break;
                        case "R": car.turnRight();
                            break;
                        case "N": car.steerNeutral();
                            break;
                        default:
                            System.out.println("Invalid command! back to car commands");
                    }
                    break;
                case 5: System.out.print("Speed up by:");
                    speed = input.nextDouble();
                    if(car.engine.isEngine() && (car.gear.isDrive() || car.gear.isReverse())){
                        car.speedUp(speed);
                    } else {
                        System.out.println("The engine must be running with the gear set to Drive or Reverse to speed up");
                    }
                    break;
                case 6: System.out.print("Slow down by:");
                    speed = input.nextDouble();
                    if(car.engine.isEngine() && (car.gear.isDrive() || car.gear.isReverse())){
                        car.slowDown(speed);
                    } else {
                        System.out.println("The engine must be running with the gear set to Drive or Reverse to slow down");
                    }
                    break;
                case 7:
                    if(car.gear.isPark() && !car.engine.isEngine() && car.wheels.isNeutral()){
                        System.out.println("Exiting the car..");
                        System.exit(0);
                    }
                    else {
                        System.out.println("You can only exit if the car is set to Park, with the engine off, and the steering wheel at neutral.");
                    }
                    break;
                default:
                    System.out.println("Invalid command! back to car commands");
            }

            car.engineConsume();

        }

    }
}
