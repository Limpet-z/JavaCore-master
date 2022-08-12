package stepic._3_oop.robot;

import java.util.Objects;

public class Robot2 {

    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {

       try (RobotConnection robotConnection = new RobotConnection() {
           @Override
           public void moveRobotTo(int x, int y) {

           }

           @Override
           public void close() {

           }
       }) {

           for (int i = 1; i <= 3; i++) {

               if (i == 1 || i == 2) {

                   try {
                       robotConnectionManager.getConnection();
                       robotConnection.moveRobotTo(toX, toY);
                       robotConnection.close();

                   } catch (RobotConnectionException ignore) {
                       robotConnection.close();
                   }


               } else {
                   try {
                       robotConnectionManager.getConnection();
                       robotConnection.moveRobotTo(toX, toY);
                       robotConnection.close();

                   } catch (RobotConnectionException e) {
                       throw new RobotConnectionException(e.getMessage());
                   }
                   robotConnection.close();
               }

           }

       } catch (RobotConnectionException e) {
           throw new RuntimeException(e.getMessage());
       }
    }

    public static class RobotConnectionManagerImplementation implements Robot2.RobotConnectionManager {
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
        public Robot2.RobotConnection getConnection() {
            if (curCA < connectionAttempt) {
                curCA++;
                throw new Robot2.RobotConnectionException("CONNECTION EXCEPTION");
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
            Robot2.RobotConnection rc = new Robot2.Robot(0, 0, Robot2.Direction.DOWN, isTM, isTC, isException);
            return rc;
        }
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    public static class Robot implements Robot2.RobotConnection {
        int x;
        int y;
        Robot2.Direction dir;
        boolean isthrowMove;
        boolean isthrowClose;
        boolean isthrowException;


        public void close() {
            if (isthrowClose) {
                throw new Robot2.RobotConnectionException("CLOSE EXCEPTION");
            }
        }

        public Robot(int x, int y, Robot2.Direction dir, boolean itm, boolean itc, boolean ite) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            isthrowMove = itm;
            isthrowClose = itc;
            isthrowException = ite;
        }

        public Robot2.Direction getDirection() {
            return dir;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void turnLeft() {
            if (dir == Robot2.Direction.UP) {
                dir = Robot2.Direction.LEFT;
            } else if (dir == Robot2.Direction.DOWN) {
                dir = Robot2.Direction.RIGHT;
            } else if (dir == Robot2.Direction.LEFT) {
                dir = Robot2.Direction.DOWN;
            } else if (dir == Robot2.Direction.RIGHT) {
                dir = Robot2.Direction.UP;
            }
        }

        public void turnRight() {
            if (dir == Robot2.Direction.UP) {
                dir = Robot2.Direction.RIGHT;
            } else if (dir == Robot2.Direction.DOWN) {
                dir = Robot2.Direction.LEFT;
            } else if (dir == Robot2.Direction.LEFT) {
                dir = Robot2.Direction.UP;
            } else if (dir == Robot2.Direction.RIGHT) {
                dir = Robot2.Direction.DOWN;
            }
        }

        public void stepForward() {
            if (dir == Robot2.Direction.UP) {
                y++;
            }
            if (dir == Robot2.Direction.DOWN) {
                y--;
            }
            if (dir == Robot2.Direction.LEFT) {
                x--;
            }
            if (dir == Robot2.Direction.RIGHT) {
                x++;
            }
        }

        public void moveRobotTo(int toX, int toY) {
            int dx = toX - getX();
            int dy = toY - getY();

            Robot2.Direction needX = Robot2.Direction.RIGHT;
            if (dx < 0) {
                needX = Robot2.Direction.LEFT;
            }
            while (getDirection() != needX) {
                turnRight();
            }

            for (dx = Math.abs(dx); dx > 0; dx--) {
                stepForward();
            }

            Robot2.Direction needY = Robot2.Direction.UP;
            if (dy < 0) {
                needY = Robot2.Direction.DOWN;
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
                throw new Robot2.RobotConnectionException("MOVE EXCEPTION");
            }
        }
    }

    public interface RobotConnection extends AutoCloseable {
        void moveRobotTo(int x, int y);

        @Override
        void close();
    }

    public interface RobotConnectionManager {
        Robot2.RobotConnection getConnection();
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
            Robot2.RobotConnectionManagerImplementation rcm = new Robot2.RobotConnectionManagerImplementation(3, 3, false, 1);
            moveRobot(rcm, 2, 2);
        } catch (Exception r) {
            System.out.println("TEST #1 " + ((Objects.equals(r.getMessage(), "MOVE EXCEPTION")) ? "PASS" : "FAILED WITH " + r.getMessage()));
        }

        try {
            Robot2.RobotConnectionManagerImplementation rcm = new Robot2.RobotConnectionManagerImplementation(0, 0, false, 0);
            moveRobot(rcm, 2, 2);
            System.out.println("TEST #2 PASS");
        } catch (Robot_4_2_8.RobotConnectionException r) {
            System.out.println("TEST #2 FAILED WITH " + r.getMessage());
        }

        try {
            Robot2.RobotConnectionManagerImplementation rcm = new Robot2.RobotConnectionManagerImplementation(2, 0, false, 0);
            moveRobot(rcm, 2, 2);
            System.out.println("TEST #3 PASS");
        } catch (Exception r) {
            System.out.println("TEST #3 FAILED WITH " + r.getMessage());
        }

        try {
            Robot2.RobotConnectionManagerImplementation rcm = new Robot2.RobotConnectionManagerImplementation(3, 0, false, 0);
            moveRobot(rcm, 2, 2);
        } catch (Exception r) {
            System.out.println("TEST #4 " + ((Objects.equals(r.getMessage(), "MOVE EXCEPTION")) ? "PASS" : "FAILED WITH " + r.getMessage()));
        }

        try {
            Robot2.RobotConnectionManagerImplementation rcm = new Robot2.RobotConnectionManagerImplementation(3, 0, true, 0);
            moveRobot(rcm, 2, 2);
        } catch (Exception r) {
            System.out.println("TEST #5 " + ((r.getMessage() == "ANOTHER EXCEPTION") ? "PASS" : "FAILED WITH " + r.getMessage()));
        }

        try {
            Robot2.RobotConnectionManagerImplementation rcm = new Robot2.RobotConnectionManagerImplementation(2, 5, false, 0);
            moveRobot(rcm, 2, 2);
            System.out.println("TEST #6 PASS");
        } catch (Exception r) {
            System.out.println("TEST #6 FAILED WITH " + r.getMessage());
        }

        try {
            Robot2.RobotConnectionManagerImplementation rcm = new Robot2.RobotConnectionManagerImplementation(0, 5, false, 2);
            moveRobot(rcm, 2, 2);
            System.out.println("TEST #7 PASS");
        } catch (Exception r) {
            System.out.println("TEST #7 FAILED WITH " + r.getMessage());
        }

        try {
            Robot2.RobotConnectionManagerImplementation rcm = new Robot2.RobotConnectionManagerImplementation(1, 0, false, 2);
            moveRobot(rcm, 2, 2);
        } catch (Exception r) {
            System.out.println("TEST #8 " + ((Objects.equals(r.getMessage(), "MOVE EXCEPTION")) ? "PASS" : "FAILED WITH " + r.getMessage()));
        }
    }
}
