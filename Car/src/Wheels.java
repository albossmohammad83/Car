public class Wheels {
    private boolean forward;
    private boolean backwards;
    private boolean left;
    private boolean right;
    private boolean neutral;

    public Wheels() {
        this.forward = false;
        this.backwards = false;
        this.left = false;
        this.right = false;
        this.neutral = true;
    }

    public void setForward(boolean forward) {
        this.forward = forward;
        this.backwards = false;
    }

    public void setBackwards(boolean backwards) {
        this.backwards = backwards;
        this.forward = false;
    }

    public void setLeft(boolean left) {
        this.left = left;
        this.right = false;
        this.neutral = false;
    }

    public void setRight(boolean right) {
        this.right = right;
        this.left = false;
        this.neutral = false;
    }

    public void setNeutral(boolean neutral) {
        this.neutral = neutral;
        this.left = false;
        this.right = false;
    }

    public boolean isForward() {
        return forward;
    }

    public boolean isBackwards() {
        return backwards;
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }

    public boolean isNeutral() {
        return neutral;
    }

    public String wheelStatus(){
        String status = "Neutral";
        if (neutral == true){
            status = "Neutral";
        }
        if(left == true){
            status = "Left";
        }
        if(right == true){
            status = "Right";
        }
        return status;
    }

    public String getDirection() {
        String status = "Not Moving";
        if (forward == true) {
            status = "Moving Forward";
        } else if (backwards == true) {
            status = "Moving Backwards";
        }
        return status;
    }

}
