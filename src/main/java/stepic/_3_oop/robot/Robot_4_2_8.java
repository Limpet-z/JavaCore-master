package stepic._3_oop.robot;

public class Robot_4_2_8 {

    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {


        RobotConnection robotConnection = null;
        for (int i = 0; i < 3; i++) {
            try {
                robotConnection = robotConnectionManager.getConnection();
                robotConnection.moveRobotTo(toX, toY);
                i = 3;
            } catch (RobotConnectionException e) {
                if (i == 2) {
                    throw new RobotConnectionException(e.getMessage());
                }
            } finally {
                if (robotConnection != null) {
                    try {
                        robotConnection.close();
                    } catch (RobotConnectionException ignore) {
                    }
                }
            }
        }
    }

    public static class RobotConnectionManagerImplementation implements RobotConnectionManager {
        private int throwNumberMove;
        private int throwNumberClose;
        private boolean isException;
        private int connectionAttempt;
        private int curCA = 0;
        private int curNM = 0;
        private int curNC = 0;

        public RobotConnectionManagerImplementation(int tnm, int tnc, boolean ie, int ca) {
            throwNumberMove = tnm;
            throwNumberClose = tnc;
            isException = ie;
            connectionAttempt = ca;
        }

        @Override
        public RobotConnection getConnection() {
            if (curCA < connectionAttempt) {
                curCA++;
                throw new RobotConnectionException("CONNECTION EXCEPTION");
            }
            boolean isTC = false;
            boolean isTM = false;
            if (curNC < throwNumberClose) {
                isTC = true;
                curNC++;
            }

            if (curNM < throwNumberMove) {
                isTM = true;
                curNM++;
            }
            RobotConnection rc = new Robot(0, 0, Direction.DOWN, isTM, isTC, isException);
            return rc;
        }
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    public static class Robot implements RobotConnection {
        int x;
        int y;
        Direction dir;
        boolean isthrowMove;
        boolean isthrowClose;
        boolean isthrowException;


        public void close() {
            if (isthrowClose) {
                throw new RobotConnectionException("CLOSE EXCEPTION");
            }
        }

        public Robot(int x, int y, Direction dir, boolean itm, boolean itc, boolean ite) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            isthrowMove = itm;
            isthrowClose = itc;
            isthrowException = ite;
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

        public void moveRobotTo(int toX, int toY) {
            int dx = toX - getX();
            int dy = toY - getY();

            Direction needX = Direction.RIGHT;
            if (dx < 0) {
                needX = Direction.LEFT;
            }
            while (getDirection() != needX) {
                turnRight();
            }

            for (dx = Math.abs(dx); dx > 0; dx--) {
                stepForward();
            }

            Direction needY = Direction.UP;
            if (dy < 0) {
                needY = Direction.DOWN;
            }
            while (getDirection() != needY) {
                turnRight();
            }

            for (dy = Math.abs(dy); dy > 0; dy--) {
                stepForward();
            }

            if (isthrowException) {
                throw new NullPointerException("ANOTHER EXCEPTION");
            }

            if (isthrowMove) {
                throw new RobotConnectionException("MOVE EXCEPTION");
            }
        }
    }

    public interface RobotConnection extends AutoCloseable {
        void moveRobotTo(int x, int y);

        @Override
        void close();
    }

    public interface RobotConnectionManager {
        RobotConnection getConnection();
    }

    public static class RobotConnectionException extends RuntimeException {

        public RobotConnectionException(String message) {
            super(message);

        }

        public RobotConnectionException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static void main(String[] args) {
        try {
            RobotConnectionManagerImplementation rcm = new RobotConnectionManagerImplementation(3, 3, false, 1);
            moveRobot(rcm, 2, 2);
        } catch (Exception r) {
            System.out.println("TEST #1 " + ((r.getMessage() == "MOVE EXCEPTION") ? "PASS" : "FAILED WITH " + r.getMessage()));
        }

        try {
            RobotConnectionManagerImplementation rcm = new RobotConnectionManagerImplementation(0, 0, false, 0);
            moveRobot(rcm, 2, 2);
            System.out.println("TEST #2 PASS");
        } catch (RobotConnectionException r) {
            System.out.println("TEST #2 FAILED WITH " + r.getMessage());
        }

        try {
            RobotConnectionManagerImplementation rcm = new RobotConnectionManagerImplementation(2, 0, false, 0);
            moveRobot(rcm, 2, 2);
            System.out.println("TEST #3 PASS");
        } catch (Exception r) {
            System.out.println("TEST #3 FAILED WITH " + r.getMessage());
        }

        try {
            RobotConnectionManagerImplementation rcm = new RobotConnectionManagerImplementation(3, 0, false, 0);
            moveRobot(rcm, 2, 2);
        } catch (Exception r) {
            System.out.println("TEST #4 " + ((r.getMessage() == "MOVE EXCEPTION") ? "PASS" : "FAILED WITH " + r.getMessage()));
        }

        try {
            RobotConnectionManagerImplementation rcm = new RobotConnectionManagerImplementation(3, 0, true, 0);
            moveRobot(rcm, 2, 2);
        } catch (Exception r) {
            System.out.println("TEST #5 " + ((r.getMessage() == "ANOTHER EXCEPTION") ? "PASS" : "FAILED WITH " + r.getMessage()));
        }

        try {
            RobotConnectionManagerImplementation rcm = new RobotConnectionManagerImplementation(2, 5, false, 0);
            moveRobot(rcm, 2, 2);
            System.out.println("TEST #6 PASS");
        } catch (Exception r) {
            System.out.println("TEST #6 FAILED WITH " + r.getMessage());
        }

        try {
            RobotConnectionManagerImplementation rcm = new RobotConnectionManagerImplementation(0, 5, false, 2);
            moveRobot(rcm, 2, 2);
            System.out.println("TEST #7 PASS");
        } catch (Exception r) {
            System.out.println("TEST #7 FAILED WITH " + r.getMessage());
        }

        try {
            RobotConnectionManagerImplementation rcm = new RobotConnectionManagerImplementation(1, 0, false, 2);
            moveRobot(rcm, 2, 2);
        } catch (Exception r) {
            System.out.println("TEST #8 " + ((r.getMessage() == "MOVE EXCEPTION") ? "PASS" : "FAILED WITH " + r.getMessage()));
        }
    }
}
