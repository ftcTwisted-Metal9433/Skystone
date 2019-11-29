package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
@TeleOp (name = "JacobGamerMove")
public class epic_gamer_person extends OpMode {

    DcMotor frontRight;
    DcMotor frontLeft;
    DcMotor backRight;
    DcMotor backLeft;
    DcMotor pullyBoi;
    Servo servoboiRight;
    Servo servoboiLeft;

    @Override
    public void init() {
        frontRight = hardwareMap.dcMotor.get("frontRight");
        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        backRight = hardwareMap.dcMotor.get("backRight");
        backLeft = hardwareMap.dcMotor.get("backLeft");
        pullyBoi = hardwareMap.dcMotor.get("pullyBoi");
        servoboiRight = hardwareMap.servo.get("servoboiRight");
        servoboiLeft = hardwareMap.servo.get("servoboiLeft");

        //setting the direction
        pullyBoi.setDirection(DcMotorSimple.Direction.REVERSE);
        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);

        servoboiRight.setPosition(.75);
        servoboiLeft.setPosition(.5);


    }

    @Override
    public void loop() {


        if (Math.abs(gamepad1.left_stick_y) > .1) {
            frontLeft.setPower(-gamepad1.left_stick_y * .9);
            backLeft.setPower(-gamepad1.left_stick_y * .9);
        } else {
            frontLeft.setPower(0);
            backLeft.setPower(0);
        }
        if (Math.abs(gamepad1.right_stick_y) > .1) {
            frontRight.setPower(-gamepad1.right_stick_y * .9);
            backRight.setPower(-gamepad1.right_stick_y * .9);
        } else {
            frontRight.setPower(0);
            backRight.setPower(0);
        }
        if (gamepad1.left_bumper){
            frontLeft.setPower(-.5);
            backLeft.setPower(.5);
            frontRight.setPower(.5);
            backRight.setPower(-.5);
        } else {
            frontLeft.setPower(0);
            backLeft.setPower(0);
            frontRight.setPower(0);
            backRight.setPower(0);
        }
        if (gamepad1.right_bumper) {
            frontLeft.setPower(.5);
            backLeft.setPower(-.5);
            frontRight.setPower(-.5);
            backRight.setPower(.5);
        } else {
            frontLeft.setPower(0);
            backLeft.setPower(0);
            frontRight.setPower(0);
            backRight.setPower(0);
        }


        // spool boi power interchangable
        if (Math.abs(gamepad1.left_trigger) > .1) {
            pullyBoi.setPower(gamepad1.left_trigger);
        } else if (Math.abs(gamepad1.right_trigger) > .1) {
            pullyBoi.setPower(-gamepad1.right_trigger);
        }
        else {
            pullyBoi.setPower(0);
        }
        // 6 by 6 design is 4 dollars and 9 by 9 design is 6 dollars
        if (gamepad1.a) {
            servoboiRight.setPosition(0);
            servoboiLeft.setPosition(1);
        }
        if (gamepad1.x) {
            servoboiRight.setPosition(.75);
            servoboiLeft.setPosition(.5);
        }



    }
}
