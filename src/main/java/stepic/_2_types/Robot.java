package stepic._2_types;

public class Robot {
    int x;
    int y;
    Direction dir;

    public Robot(int x, int y, Direction dir) {
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

    public static void moveRobot(Robot robot, int toX, int toY) {

        var x = robot.getX();
        var y = robot.getY();

        int x123 = Math.abs(x) + Math.abs(toX);
        int y123 = Math.abs(y) - Math.abs(toY);
        int y322 = Math.abs(y) - Math.abs(toY);
        int x228 = Math.abs(toX) - Math.abs(x);

        boolean complete = false;

        while (!complete) {
            complete = true;

            if (x >= toX) {
                if (robot.getDirection().equals(Direction.UP)) {
                    robot.turnLeft();
                }
                if (robot.getDirection().equals(Direction.DOWN)) {
                    robot.turnRight();
                }

                if (robot.getDirection().equals(Direction.RIGHT)) {
                    robot.turnRight();
                    robot.turnRight();
                }

                for (int i = 0; i < x228; i++) {
                    robot.stepForward();
                }
            } else {
                if (robot.getDirection().equals(Direction.UP)) {
                    robot.turnRight();
                }
                if (robot.getDirection().equals(Direction.DOWN)) {
                    robot.turnLeft();
                }

                if (robot.getDirection().equals(Direction.LEFT)) {
                    robot.turnRight();
                    robot.turnRight();
                }

                for (int i = 0; i < x123; i++) {
                    robot.stepForward();
                }
            }

            if (y >= toY) {
                if (robot.getDirection().equals(Direction.UP)) {
                    robot.turnLeft();
                    robot.turnLeft();
                }

                if (robot.getDirection().equals(Direction.RIGHT)) {
                    robot.turnRight();
                }
                if (robot.getDirection().equals(Direction.LEFT)) {
                    robot.turnLeft();
                }

                for (int i = 0; i < y322; i++) {
                    robot.stepForward();
                }
            } else {

                if (robot.getDirection().equals(Direction.DOWN)) {
                    robot.turnLeft();
                    robot.turnLeft();
                }

                if (robot.getDirection().equals(Direction.LEFT)) {
                    robot.turnRight();
                }
                if (robot.getDirection().equals(Direction.RIGHT)) {
                    robot.turnLeft();
                }

                for (int i = 0; i < y123; i++) {
                    robot.stepForward();
                }
            }
        }
    }

    public static void main(String[] args) {
        Robot robot = new Robot(-5, -96, Direction.UP);
        moveRobot(robot, 5, 1);
        System.out.println(robot.getX());
        System.out.println(robot.getY());
        System.out.println(robot.getDirection());
    }

}
