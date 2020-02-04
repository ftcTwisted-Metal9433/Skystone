package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcontroller.external.samples.HardwarePushbot;

@Autonomous(name = "Get the Block Rev")
public class Get_That_Block_Rev extends LinearOpMode {
    /* Declare OpMode members. */
    //TODO: Declare motors
    private ElapsedTime runtime = new ElapsedTime();

    static final double     COUNTS_PER_MOTOR_REV    = 1120 ;    // eg: TETRIX Motor Encoder
    static final double     DRIVE_GEAR_REDUCTION    = 1.0 ;     // This is < 1.0 if geared UP
    static final double     WHEEL_DIAMETER_INCHES   = 4.0 ;     // For figuring circumference
    static final double     COUNTS_PER_INCH         = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) /
            (WHEEL_DIAMETER_INCHES * 3.1415);

    DcMotor frontRight;
    DcMotor frontLeft;
    DcMotor backRight;
    DcMotor backLeft;
    DcMotor pullyBoi;
    CRServo intake;
    Servo moveBoi;
    Servo moveBoi2;

    @Override
    public void runOpMode() {

        /*
         * Initialize the drive system variables.
         * The init() method of the hardware class does all the work here
         */
        frontRight = hardwareMap.dcMotor.get("frontRight");
        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        backRight = hardwareMap.dcMotor.get("backRight");
        backLeft = hardwareMap.dcMotor.get("backLeft");
        pullyBoi = hardwareMap.dcMotor.get("pullyBoi");
        intake = hardwareMap.crservo.get("intake");
        moveBoi = hardwareMap.servo.get("moveBoi");
        moveBoi2 = hardwareMap.servo.get("moveBoi2");

        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);



        telemetry.addData("Status", "Resetting Encoders");    //
        telemetry.update();

        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        // Send telemetry message to indicate successful Encoder reset
        telemetry.addData("Path0",  "Starting at %7d :%7d",
                frontLeft.getCurrentPosition() ,
                frontRight.getCurrentPosition());

        telemetry.update();
        setMoveBoi(0);
        setMoveBoi2(.8);
        // Wait for the game to start (driver presses PLAY)
        waitForStart();


        strafeRight(.25, 3.4, 2);
        intakeOut(1, 2200);
        pullUp(1, 850);
        encoderDrive(1, 34.50, 34.50, 2);
        pullDown(1, 900);
        sleep(1000);
        intakeIn(1, 1200);
        sleep(1000);
        encoderDrive(1, -10, -10 , 3);
        encoderDrive(1, -15.5, 15.5, 3);
        encoderDrive(1, 80, 80, 20);
        encoderDrive(1, 15.5, -15.5, 3);
        pullUp(1, 1100);
        sleep(1000);
        encoderDrive(1, 12, 12, 2);
        setMoveBoi(.8);
        setMoveBoi2(0);
        pullDown(1, 800);
        intakeOut(1, 600);
        encoderDrive(1, -38, -38, 3);
        setMoveBoi(0);
        setMoveBoi2(.8);
        pullUp(1, 800);
        strafeRight(.5, 40, 8);
        pullDown(1, 1000);
        encoderDrive(1, 30, 30, 5);
        encoderDrive(1, 15.5, -15.5, 3);
        encoderDrive(1, 5, 5, 2);






        freeze();





        telemetry.addData("Path", "Complete");
        telemetry.update();
    }

    /*
     *  Method to perfmorm a relative move, based on encoder counts.
     *  Encoders are not reset as the move is based on the current position.
     *  Move will stop if any of three conditions occur:
     *  1) Move gets to the desired position
     *  2) Move runs out of time
     *  3) Driver stops the opmode running.
     */
    public void drive(double speed,
                             double backLeftInches, double backRightInches,
                             double frontLeftInches, double frontRightInches,
                             double timeoutS) {
        int newBackLeftTarget;
        int newBackRightTarget;
        int newFrontLeftTarget;
        int newFrontRightTarget;

        // Ensure that the opmode is still active
        if (opModeIsActive()) {

            // Determine new target position, and pass to motor controller
            newFrontLeftTarget = frontLeft.getCurrentPosition() + (int)(frontLeftInches * COUNTS_PER_INCH);
            newFrontRightTarget = frontRight.getCurrentPosition() + (int)(frontRightInches * COUNTS_PER_INCH);
            newBackLeftTarget = backLeft.getCurrentPosition() + (int)(backLeftInches * COUNTS_PER_INCH);
            newBackRightTarget = backRight.getCurrentPosition() + (int)(backRightInches * COUNTS_PER_INCH);
            frontLeft.setTargetPosition(newFrontLeftTarget);
            frontRight.setTargetPosition(newFrontRightTarget);
            backLeft.setTargetPosition(newBackLeftTarget);
            backRight.setTargetPosition(newBackRightTarget);

            // Turn On RUN_TO_POSITION
            frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            // reset the timeout time and start motion.
            runtime.reset();
            frontLeft.setPower(Math.abs(speed));
            frontRight.setPower(Math.abs(speed));
            backLeft.setPower(Math.abs(speed));
            backRight.setPower(Math.abs(speed));

            // keep looping while we are still active, and there is time left, and both motors are running.
            // Note: We use (isBusy() && isBusy()) in the loop test, which means that when EITHER motor hits
            // its target position, the motion will stop.  This is "safer" in the event that the robot will
            // always end the motion as soon as possible.
            // However, if you require that BOTH motors have finished their moves before the robot continues
            // onto the next step, use (isBusy() || isBusy()) in the loop test.
            while (opModeIsActive() &&
                    (runtime.seconds() < timeoutS) &&
                    (frontLeft.isBusy() && frontRight.isBusy()&& backLeft.isBusy()&& backRight.isBusy())) {

//                // Display it for the driver.
//                telemetry.addData("Path1",  "Running to %7d :%7d", newbackLeftTarget,  newbackRightTarget , newfrontLeftTarget, newfrontRightTarget);
//                telemetry.addData("Path2",  "Running at %7d :%7d",
//                        telemetry.addData("Path3",  "Running at %7d :%7d",
//                                telemetry.addData("Path4",  "Running at %7d :%7d",
//                        telemetry.addData("frontRight Encoder", frontRight.getCurrentPosition());
//                                telemetry.addData("frontRight goTo", newfrontRightTarget);
//                        frontLeft.getCurrentPosition(),
//                        frontRight.getCurrentPosition());
//                telemetry.update();
            }

            // Stop all motion;
            frontLeft.setPower(0);
            frontRight.setPower(0);
            backLeft.setPower(0);
            backRight.setPower(0);

            // Turn off RUN_TO_POSITION
            frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        }
    }
    public void encoderDrive (double speed,double leftInches, double rightInches, double timeoutS) {
        drive(speed, leftInches, rightInches, leftInches, rightInches, timeoutS);
    }

    public void intakeOut (double power, int time) {
        intake.setPower(-power);
        sleep(time);
        intake.setPower(0);
    }

    public void intakeIn (double power, int time) {
        intake.setPower(power);
        sleep(time);
        intake.setPower(0);
    }

    public void pullUp (double power, int time) {
        pullyBoi.setPower(-power);
        sleep(time);
        pullyBoi.setPower(0);
    }

    public void pullDown (double power, int time) {
        pullyBoi.setPower(power);
        sleep(time);
        pullyBoi.setPower(0);
    }

    public void strafeLeft(double speed, double inches, double timeoutS) {
        drive(speed, inches, -inches, -inches, inches, timeoutS);
    }

    public void strafeRight(double speed, double inches, double timeoutS) {
        drive(speed, -inches, inches, inches, -inches, timeoutS);
    }

    public void setMoveBoi(double position){
        moveBoi.setPosition(position);
    }

    public void setMoveBoi2(double position){
        moveBoi2.setPosition(position);
    }

    public void freeze () {
        frontLeft.setPower(0);
        backLeft.setPower(0);
        frontRight.setPower(0);
        backRight.setPower(0);
    }

}

