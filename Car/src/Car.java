public class Car {
    Wheels wheels;
    SteeringWheel steer;
    GasTank tank;
    Gearshift gear;
    Engine engine;
    private double baseSpeed;
    private double curSpeed;

    public Car() {
        this.wheels = new Wheels();
        this.steer = new SteeringWheel(wheels);
        this.tank = new GasTank();
        this.gear = new Gearshift();
        this.engine = new Engine();
        this.baseSpeed = 5;
        this.curSpeed = 0;
    }
    public void carStatus(){
        String eng = "";
        if(engine.isEngine()){
            eng = "ON";
        } else {
            eng = "OFF";
        }
        if(engine.isEngine() && (gear.isDrive() || gear.isReverse()) && curSpeed == 0){
            curSpeed += baseSpeed;
        }
        System.out.printf("Engine is: %s\n" +
                        "Gearshift is: %s\n" +
                        "Steering wheel is: %s\n" +
                        "Current Speed is: %.2f MPH\n" +
                        "car direction is: %s\n" +
                        "Fuel tank is: %.2f%%\n"
                        , eng, gear.gearShiftStatus(),
                        wheels.wheelStatus(), curSpeed, wheels.getDirection(),tank.getTank());
    }

    public void turnEngineON(){
        engine.setEngine(true);
    }

    public void turnEngineOFF(){
        engine.setEngine(false);
    }

    public void reverse(){
        gear.setReverse(true);
        wheels.setBackwards(true);
    }

    public void park(){
        gear.setPark(true);
        wheels.setBackwards(false);
        wheels.setForward(false);
        curSpeed = 0;
    }

    public void drive(){
        gear.setDrive(true);
        wheels.setForward(true);
    }

    public void turnLeft(){
        wheels.setLeft(true);
    }

    public void turnRight(){
        wheels.setRight(true);
    }

    public void steerNeutral(){
        wheels.setNeutral(true);
    }

    public void setFuelTank(double curSpeed){
        tank.setTank(tank.getTank() - Math.pow( (Math.abs(baseSpeed - curSpeed) * 0.3), (2/3) ) );
    }

    public void speedUp(double curSpeed){
        this.curSpeed += curSpeed;
    }

    public void slowDown(double curSpeed){
        this.curSpeed -= curSpeed;
    }

    public void engineConsume(){
        if(engine.isEngine()){
            tank.setTank(tank.getTank() - 0.02);
        }
    }

    public double getCurSpeed() {
        return curSpeed ;
    }

}
