package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
@Autonomous (name = "RedSideTest")
public class Red_side extends LinearOpMode {
    DcMotor frontRight;
    DcMotor frontLeft;
    DcMotor backRight;
    DcMotor backLeft;
    @Override
    public void runOpMode() throws InterruptedException {
        frontRight = hardwareMap.dcMotor.get("frontRight");
        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        backRight = hardwareMap.dcMotor.get("backRight");
        backLeft = hardwareMap.dcMotor.get("backLeft");

        waitForStart();
        frontRight.setPower(.25);
        frontLeft.setPower(-.25);
        backRight.setPower(.25);
        backLeft.setPower(-.25);
        sleep(1000);

        frontRight.setPower(0);
        frontLeft.setPower(0);
        backRight.setPower(0);
        backLeft.setPower(0);
        sleep(1000);
        //turn right
        frontRight.setPower(-.26);
        frontLeft.setPower(.26);
        backRight.setPower(-.26);
        backLeft.setPower(.26);
        sleep(1000);

        frontRight.setPower(0);
        frontLeft.setPower(0);
        backRight.setPower(0);
        backLeft.setPower(0);
        sleep(1000);

        frontRight.setPower(-.25);
        frontLeft.setPower(.25);
        backRight.setPower(-.25);
        backLeft.setPower(.25);
        sleep(1600);

        frontRight.setPower(0);
        frontLeft.setPower(0);
        backRight.setPower(0);
        backLeft.setPower(0);
        stop();


    }
}


