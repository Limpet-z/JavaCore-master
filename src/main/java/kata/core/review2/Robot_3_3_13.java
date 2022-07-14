package kata.core.review2;

public class Robot_3_3_13 {

    int x;
    int y;
    Direction dir;
    boolean complete = false;

    public Robot_3_3_13(int x, int y, Direction dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public Direction getDirection() {
        return dir;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void turnLeft() {
        if (dir == Direction.UP) {
            dir = Direction.LEFT;
        } else if (dir == Direction.DOWN) {
            dir = Direction.RIGHT;
        } else if (dir == Direction.LEFT) {
            dir = Direction.DOWN;
        } else if (dir == Direction.RIGHT) {
            dir = Direction.UP;
        }
    }

    public void turnRight() {
        if (dir == Direction.UP) {
            dir = Direction.RIGHT;
        } else if (dir == Direction.DOWN) {
            dir = Direction.LEFT;
        } else if (dir == Direction.LEFT) {
            dir = Direction.UP;
        } else if (dir == Direction.RIGHT) {
            dir = Direction.DOWN;
        }
    }

    public void stepForward() {
        if (dir == Direction.UP) {
            y++;
        }
        if (dir == Direction.DOWN) {
            y--;
        }
        if (dir == Direction.LEFT) {
            x--;
        }
        if (dir == Direction.RIGHT) {
            x++;
        }
    }

    public static void moveRobot(Robot_3_3_13 robot, int toX, int toY) {

        var x = robot.getX();
        var y = robot.getY();
        var d = robot.getDirection();

        var absX = Math.abs(x) + Math.abs(toX);
        var absY = Math.abs(y) + Math.abs(toY);

        boolean com = false;

        while (!com){
            if (x >= toX & y >= toY) {

                if (d.equals(Direction.UP)) {
                    continue;
                }
                if (d.equals(Direction.DOWN)) {
                    robot.turnRight();
                }
                if (d.equals(Direction.LEFT)) {
                    continue;
                }
                if (d.equals(Direction.RIGHT)) {
                    robot.turnLeft();
                    robot.turnLeft();
                }
                //------------------------------//
                if (x > toX) {
                    int i1 = x - toX;
                    for (int j = 0; j < i1; j++) {
                        robot.stepForward();
                    }
                    x = toX;
                }
                robot.turnRight();

                if (toX > x) {
                    int i1 = toX - x;
                    for (int j = 0; j < i1; j++) {
                        robot.stepForward();
                    }
                    x = toX;
                }

                if (y > toY) {
                    robot.turnLeft();
                    int i2 = y - toY;
                    for (int j = 0; j < i2; j++) {
                        robot.stepForward();
                    }
                    y = toY;
                }
            }
        }
    }

    public static void main(String[] args) {
        Robot_3_3_13 robot = new Robot_3_3_13(5, 7, Direction.UP);
        moveRobot(robot, 1, 2);
        System.out.println(robot.getX());
        System.out.println(robot.getY());
        System.out.println(robot.getDirection());
    }

}
