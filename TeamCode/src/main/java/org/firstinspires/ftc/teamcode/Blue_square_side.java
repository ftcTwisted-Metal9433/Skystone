package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous (name = "Blue_square_side")
public class Blue_square_side extends LinearOpMode {
    private DcMotor frontRight;
    private DcMotor frontLeft;
    private DcMotor backRight;
    private DcMotor backLeft;
    private DcMotor pullyBoi;
    private Servo servoboiRight;
    private Servo servoboiLeft;

    double TICKS_PER_IN = 1120 / (4 * Math.PI);

    public void move(double rightPower, double leftPower, int ms) {
        frontRight.setPower(rightPower);
        frontLeft.setPower(leftPower);
        backRight.setPower(rightPower);
        backLeft.setPower(leftPower);
        sleep(ms);

    }

    public void stopRobot() {
        frontRight.setPower(0);
        frontLeft.setPower(0);
        backRight.setPower(0);
        backLeft.setPower(0);
    }

    public void pointTurnRight( double right, double left, int ms) {
        frontLeft.setPower(.25);
        backLeft.setPower(.25);

        sleep(ms);
    }

    public void pointTurnLeft(double Right, double Left, int ms ) {
        frontRight.setPower(.25);
        frontLeft.setPower(.25);
        backRight.setPower(.25);
        backLeft.setPower(.25);
        sleep(ms);
    }

    public void openArms() {
        pullyBoi.setPower(-.5);
        servoboiRight.setPosition(1);
    }

    public void closeServo() {
        pullyBoi.setPower(0);
        servoboiRight.setPosition(0); //-Chris, change the number of the servo cuz the numbers arent correct

    }

    public void liftUp() {
        pullyBoi.setPower(.5);
        sleep(3000);
    }

    public void backward(double right, double left) {
        frontRight.setPower(-.5);
        frontLeft.setPower(.5);
        backRight.setPower(-.5);
        backLeft.setPower(.5);
    }

    public void encoderdrivingboi(double inches, double leftPower, double rightPower) {
        frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        int leftWheelDistance = frontLeft.getCurrentPosition() + (int) (TICKS_PER_IN * inches);
        int rightWheelDistance = frontRight.getCurrentPosition() + (int) (TICKS_PER_IN * inches);

        frontLeft.setTargetPosition(leftWheelDistance);
        frontRight.setTargetPosition(rightWheelDistance);

        while (Math.abs(frontLeft.getCurrentPosition()) < leftWheelDistance ||
                Math.abs(frontRight.getCurrentPosition()) < rightWheelDistance) {

            frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            frontRight.setPower(rightPower);
            frontLeft.setPower(leftPower);

            backLeft.setPower(frontLeft.getPower());
            backRight.setPower(frontRight.getPower());

            telemetry.addData("Left Enc ", frontLeft.getCurrentPosition());
            telemetry.addData("Right Enc ", frontRight.getCurrentPosition());
            updateTelemetry(telemetry);
            telemetry.update();
        }

        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
    }

    @Override
    public void runOpMode() throws InterruptedException {


        frontRight = hardwareMap.dcMotor.get("frontRight");
        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        backRight = hardwareMap.dcMotor.get("backRight");
        backLeft = hardwareMap.dcMotor.get("backLeft");
        pullyBoi = hardwareMap.dcMotor.get("pullyBoi");
        servoboiRight = hardwareMap.servo.get("servoboiRight");
        servoboiLeft = hardwareMap.servo.get("servoboiLeft");




        waitForStart();
        //pick up the stone in the beginning
        move(.5,.5,5000);

        //stop robot
        frontLeft.setPower(0);
        backLeft.setPower(0);
        frontRight.setPower(0);
        backRight.setPower(0);
//turn right
        frontRight.setPower(.28);
        frontLeft.setPower(-.28);
        backRight.setPower(.28);
        backLeft.setPower(-.28);

        sleep(200);

        encoderdrivingboi(14,.5,.5);
        //turn left
        frontRight.setPower(-.28);
        frontLeft.setPower(.28);
        backRight.setPower(-.28);
        backLeft.setPower(.28);

        sleep(500);


        encoderdrivingboi(2,-.5,.5);
        //turn left
        frontRight.setPower(-.35);
        frontLeft.setPower(.35);
        backRight.setPower(-.35);
        backLeft.setPower(.35);

        sleep(1000);

        encoderdrivingboi(2,-.5,.5);

        openArms();

        closeServo();

        liftUp();


        //turn right
        frontRight.setPower(-.35);
        frontLeft.setPower(-.35);
        backRight.setPower(-.35);
        backLeft.setPower(-.35);

        sleep(1000);

        encoderdrivingboi(4,.5,.5);
        //turn right
        frontRight.setPower(-.35);
        frontLeft.setPower(-.35);
        backRight.setPower(-.35);
        backLeft.setPower(-.35);

        sleep(500);

        //ready to go turn under the bar.
        //backwards
        encoderdrivingboi(20,-.5,.5);
        //turn left
        frontRight.setPower(.35);
        frontLeft.setPower(.35);
        backRight.setPower(.35);
        backLeft.setPower(.35);
        sleep(500);
        encoderdrivingboi(10,-.5,.5);
        //turn right
        frontRight.setPower(-.35);
        frontLeft.setPower(-.35);
        backRight.setPower(-.35);
        backLeft.setPower(-.35);

        encoderdrivingboi(2,-.5,.5);

        openArms();

        //return to homebase
        encoderdrivingboi(4,5,-5);
        //turn right
        frontRight.setPower(-.35);
        frontLeft.setPower(-.35);
        backRight.setPower(-.35);
        backLeft.setPower(-.35);
        encoderdrivingboi(15,-1,1);
        //turn right
        frontRight.setPower(-.35);
        frontLeft.setPower(-.35);
        backRight.setPower(-.35);
        backLeft.setPower(-.35);
        encoderdrivingboi(10,-1,1);
        stopRobot();
        frontRight.setPower(0);
        frontLeft.setPower(0);
        backRight.setPower(0);
        backLeft.setPower(0);
        stop();


    }
}



