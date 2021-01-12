public class GasTank {
    private double tank;
    private boolean full;

    public GasTank() {
        this.tank = 100.00;
        this.full = true;
    }

    public double getTank() {
        return tank;
    }

    public void setTank(double tank) {
        this.tank = tank;
    }

    public boolean isFull() {
        return full;
    }

    public void setFull(boolean full) {
        this.full = full;
    }
}
