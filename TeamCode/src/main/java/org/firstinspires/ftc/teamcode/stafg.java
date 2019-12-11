package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name = "straf")
public class straf extends LinearOpMode {
    DcMotor frontRight;
    DcMotor frontLeft;
    DcMotor backRight;
    DcMotor backLeft;
    DcMotor pullyBoi;
    Servo servoboiRight;
    Servo servoboiLeft;

    public void opentopickupblock(){

    }

//play minecraft

    public void move(double rightPower, double leftPower, int ms) {
        frontRight.setPower(rightPower);
        frontLeft.setPower(leftPower);
        backRight.setPower(rightPower);
        backLeft.setPower(leftPower);
        sleep(ms);
    }
    public void strRight(double rightPower, double leftPower, int ms) {
        frontRight.setPower(-rightPower);
        frontLeft.setPower(-leftPower);
        backRight.setPower(rightPower);
        backLeft.setPower(leftPower);
        sleep(ms);
    }
    public void strLeft(double rightPower, double leftPower, int ms) {
        frontRight.setPower(rightPower);
        frontLeft.setPower(leftPower);
        backRight.setPower(-rightPower);
        backLeft.setPower(-leftPower);
        sleep(ms);
    }

    public void closearms(int ms){
        servoboiLeft.setPosition(1);
        servoboiRight.setPosition(1);
        sleep(1000);
    }
    public void open(int ms){
        servoboiLeft.setPosition(.5);
        servoboiRight.setPosition(.75);
        sleep(1000);
    }
    public void dropLift(int ms){
        pullyBoi.setPower(-.25);
        sleep(1000);
    }
    public void LiftupLift(int ms){
        pullyBoi.setPower(.25);
        sleep(1000);


    }



    @Override
    public void runOpMode() throws InterruptedException {
        frontRight = hardwareMap.dcMotor.get("frontRight");
        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        backRight = hardwareMap.dcMotor.get("backRight");
        backLeft = hardwareMap.dcMotor.get("backLeft");

        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();

        strLeft(.5,.5,1500);

        move(.5,.5,100);

        closearms();





        stop();








    }
}

