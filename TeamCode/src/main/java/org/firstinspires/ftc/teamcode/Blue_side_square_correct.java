package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
<<<<<<< HEAD
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous (name = "left")
=======
@Autonomous (name = "BlueSideParking(Left)")
>>>>>>> 6a769c0865fda2dd1b9de0b63e747e20d1188e8a
public class Blue_side_square_correct extends LinearOpMode {
    DcMotor frontRight;
    DcMotor frontLeft;
    DcMotor backRight;
    DcMotor backLeft;
    DcMotor pullyBoi;
    Servo servoboiLeft;
    Servo servoboiRight;


    @Override
    public void runOpMode() throws InterruptedException {
        frontRight = hardwareMap.dcMotor.get("frontRight");
        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        backRight = hardwareMap.dcMotor.get("backRight");
        backLeft = hardwareMap.dcMotor.get("backLeft");
        pullyBoi = hardwareMap.dcMotor.get("pullyBoi");
        servoboiLeft = hardwareMap.servo.get("servoboiLeft");
        servoboiRight= hardwareMap.servo.get("servoboiRight");


        waitForStart();

        //lift
        pullyBoi.setPower(.25);
        sleep(100);
        //strafe
        frontRight.setPower(.75);
        frontLeft.setPower(.75);
        backRight.setPower(-.75);
        backLeft.setPower(-.75);
        sleep(1800);
        //stop
        frontRight.setPower(0);
        frontLeft.setPower(0);
        backRight.setPower(0);
        backLeft.setPower(0);
        sleep(1000);
        //forward
        frontRight.setPower(.25);
        frontLeft.setPower(-.25);
        backRight.setPower(.25);
        backLeft.setPower(-.25);
        sleep(500);
        //Down lift
        pullyBoi.setPower(-.25);
        sleep(100);
        //servo
        servoboiRight.setPosition(0);
        servoboiLeft.setPosition(.6);
        //strafe the other way
        frontRight.setPower(-.27);
        frontLeft.setPower(-.27);
        backRight.setPower(.27);
        backLeft.setPower(.27);
        sleep(1000);

        frontRight.setPower(0);
        frontLeft.setPower(0);
        backRight.setPower(0);
        backLeft.setPower(0);
        sleep(1000);
        // going backwards
        frontRight.setPower(-.25);
        frontLeft.setPower(.25);
        backRight.setPower(-.25);
        backLeft.setPower(.25);
        sleep(2100);
        //stop
        frontRight.setPower(0);
        frontLeft.setPower(0);
        backRight.setPower(0);
        backLeft.setPower(0);
        stop();


    }
}


