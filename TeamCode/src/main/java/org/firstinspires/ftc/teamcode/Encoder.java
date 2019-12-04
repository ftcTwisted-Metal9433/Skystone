package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous (name = "Encoder")
public class Encoder extends LinearOpMode {
    DcMotor frontRight = null;
    DcMotor frontLeft = null;
    DcMotor backRight = null;
    DcMotor backLeft = null;
    DcMotor pullyBoi = null;
    Servo servoboiRight;
    Servo servoboiLeft;


    @Override
    public void runOpMode() throws InterruptedException {
        frontRight = hardwareMap.dcMotor.get("frontRight");
        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        backRight = hardwareMap.dcMotor.get("backRight");
        backLeft = hardwareMap.dcMotor.get("backLeft");
        pullyBoi = hardwareMap.dcMotor.get("pullyBoi");
        servoboiRight = hardwareMap.servo.get("servoBoiRight");
        servoboiLeft = hardwareMap.servo.get("servoboiLeft");

        frontRight.setMode(DcMotorController.RunMode.RUN_USING_ENCODER);
        frontLeft.setMode(DcMotorController.RunMode.RUN_USING_ENCODER);
        backRight.setMode(DcMotorController.RunMode.RUN_USING_ENCODER);
        backLeft.setMode(DcMotorController.RunMode.RUN_USING_ENCODER);
        pullyBoi.setMode(DcMotorController.RunMode.RUN_USING_ENCODER);

        waitForStart();

        frontRight.getCurrentPosition();

        frontRight.setTargetPosition();

        frontRight.isBusy();

        int ANDYMARK_TICKS_PER_REV = 1120;

    }
}

