public class SteeringWheel {

    public SteeringWheel(Wheels wheels) {
        wheels.setNeutral(true);
    }

    public void steerLeft (Wheels wheels){
        wheels.setLeft(true);
    }

    public void steerRight (Wheels wheels){
        wheels.setRight(true);
    }

}
