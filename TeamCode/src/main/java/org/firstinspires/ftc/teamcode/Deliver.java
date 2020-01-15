package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous (name = "-~-")
public class Deliver extends LinearOpMode {
    DcMotor frontRight;
    DcMotor frontLeft;
    DcMotor backRight;
    DcMotor backLeft;
    DcMotor pullyBoi;
    CRServo intake;

    @Override
    public void runOpMode() throws InterruptedException {
        frontRight = hardwareMap.dcMotor.get("frontRight");
        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        backRight = hardwareMap.dcMotor.get("backRight");
        backLeft = hardwareMap.dcMotor.get("backLeft");
        pullyBoi = hardwareMap.dcMotor.get("pullyBoi");
        intake = hardwareMap.crservo.get("intake");

        waitForStart();

        forward(.5,0);
        pullUp(1,980);
        pause(0,250);

        setIntake(-1,2200);
        pause(0,250);

        pullDown(1,1000);
        pause(0,250);

        setIntake(1,700);
        pause(0,250);

        backwards(.5,800);
        turnRight(.5,700);
        forward(.5,1700);
        turnLeft(.5,600);
        pause(0,250);

        setIntake(-1,0);
        pullUp(1,1300);
        pause(0,250);

        backwards(.5,200);
        pullDown(.5,1300);
        strafeLeft(.5,0);
        setIntake(1,1000);


    }
    public void setIntake (double power, int time) {
        intake.setPower(power);
        sleep(time);
    }
    public void pause (double power, int time) {
        frontRight.setPower(0);
        frontLeft.setPower(0);
        backRight.setPower(0);
        backLeft.setPower(0);
        intake.setPower(0);
        pullyBoi.setPower(0);
        sleep(time);
    }
    public void pullUp (double power, int time) {
        pullyBoi.setPower(power);
        sleep(time);
    }
    public void pullDown (double power, int time) {
        pullyBoi.setPower(-power);
        sleep(time);
    }
    public void forward (double power, int time) {
        frontRight.setPower(power);
        frontLeft.setPower(-power);
        backRight.setPower(power);
        backLeft.setPower(-power);
        sleep(time);
    }
    public void backwards (double power, int time) {
        frontRight.setPower(-power);
        frontLeft.setPower(power);
        backRight.setPower(-power);
        backLeft.setPower(power);
        sleep(time);
    }
    public void turnLeft (double power, int time) {
        frontRight.setPower(power);
        frontLeft.setPower(power);
        backRight.setPower(power);
        backLeft.setPower(power);
        sleep(time);
    }
    public void turnRight (double power, int time) {
        frontRight.setPower(-power);
        frontLeft.setPower(-power);
        backRight.setPower(-power);
        backLeft.setPower(-power);
        sleep(time);
    }
    public void strafeLeft (double power, int time) {
        frontRight.setPower(power);
        frontLeft.setPower(power);
        backRight.setPower(-power);
        backLeft.setPower(-power);
        sleep(time);
    }
    public void strafeRight (double power, int time) {
        frontLeft.setPower(-power);
        frontRight.setPower(-power);
        backLeft.setPower(power);
        backRight.setPower(power);
        sleep(time);
    }

}
