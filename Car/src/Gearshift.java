public class Gearshift {
    private boolean park;
    private boolean drive;
    private boolean reverse;

    public Gearshift() {
        this.park = true;
        this.drive = false;
        this.reverse = false;
    }

    public boolean isPark() {
        return park;
    }

    public void setPark(boolean park) {
        this.park = park;
        this.drive = false;
        this.reverse = false;
    }

    public boolean isDrive() {
        return drive;
    }

    public void setDrive(boolean drive) {
        this.drive = drive;
        this.park = false;
        this.reverse = false;
    }

    public boolean isReverse() {
        return reverse;
    }

    public void setReverse(boolean reverse) {
        this.reverse = reverse;
        this.drive = false;
        this.park = false;
    }

    public String gearShiftStatus(){
        String status = null;
        if(park == true){
            status = "Park";
        }
        else if(drive == true){
            status = "Drive";
        }
        else if(reverse == true){
            status = "Reverse";
        }
        return status;
    }
}
