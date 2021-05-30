public class BallFactory {
    private int badBallChance;
    private int difficulty;
    private int minBallSpeed;
    private int maxBallSpeed;

    public BallFactory(int minBallSpeed, int maxBallSpeed, int badBallChance) {
        this.minBallSpeed = minBallSpeed;
        this.maxBallSpeed = maxBallSpeed;
        this.badBallChance = badBallChance;
        this.difficulty = 0;
    }

    public Ball create(int maxPositionX) {
        int positionX = (int) (Math.random() * maxPositionX);
        int positionY = 0;
        boolean isGood = (Math.random() * 100) > badBallChance;
        int speed = calculateBallSpeed();
        Ball ball = new Ball(positionX, positionY, isGood, speed);
        return ball;
    }

    private int calculateBallSpeed() {
        double speedIncrease = this.difficulty * Math.random();
        double speed = this.minBallSpeed + speedIncrease;
        return (int)speed;
    }

    public void increaseDifficulty() {
        this.difficulty = Math.min(this.difficulty + 1, maxBallSpeed);
    }
}