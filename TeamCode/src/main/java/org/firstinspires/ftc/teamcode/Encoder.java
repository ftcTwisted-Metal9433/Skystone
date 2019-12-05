package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcontroller.external.samples.HardwarePushbot;

@Autonomous (name = "Encoder")
@Disabled
public class Encoder extends LinearOpMode {

    Encoder robot = new HardwarePushbot()
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


        frontRight.setPower(0);
        frontLeft.setPower(0);
        backRight.setPower(0);
        backLeft.setPower(0);
        pullyBoi.setPower(0);


        frontRight.setMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODER);
        frontLeft.setMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODER);
        backRight.setMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODER);
        backLeft.setMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODER);
        pullyBoi.setMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODER);

        waitForStart();

        private double TICKS_PER_IN = 1120/(4*Math.PI)

        frontRight.getCurrentPosition();

        frontRight.setTargetPosition(1);

        frontRight.setMode();

        frontRight.isBusy();



        public void encodeStraightDriveInches(double inches, double leftPower, double rightPower){


        }


    }
}

