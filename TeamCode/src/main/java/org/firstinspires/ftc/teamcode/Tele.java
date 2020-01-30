package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import static fi.iki.elonen.NanoHTTPD.Method.HEAD;

@TeleOp (name = "TeleOp")
public class Tele extends OpMode {
    DcMotor frontRight;
    DcMotor frontLeft;
    DcMotor backRight;
    DcMotor backLeft;
    DcMotor pullyBoi;
    CRServo intake;
    Servo moveBoi;
    Servo moveBoi2;

    @Override
    public void init() {
        frontRight = hardwareMap.dcMotor.get("frontRight");
        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        backRight = hardwareMap.dcMotor.get("backRight");
        backLeft = hardwareMap.dcMotor.get("backLeft");
        pullyBoi = hardwareMap.dcMotor.get("pullyBoi");
        intake = hardwareMap.crservo.get("intake");
        moveBoi = hardwareMap.servo.get("moveBoi");
        moveBoi2 =hardwareMap.servo.get("moveBoi2");

        //setting the direction
        pullyBoi.setDirection(DcMotorSimple.Direction.REVERSE);
        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);



    }

    @Override
    public void loop() {
        telemetry.addData("frontLeft", "power FL" + frontLeft.getPower());
        telemetry.addData("frontRight","power FR" + frontRight.getPower());
        telemetry.addData("backLeft","power BL" + backLeft.getPower());
        telemetry.addData("backRight","power BR" + backRight.getPower());
        telemetry.addData("pullyBoi","power PB" + pullyBoi.getPower());

        telemetry.update();




        //Base Motors
        if (Math.abs(gamepad1.left_stick_y) > .1) {

            frontLeft.setPower(-gamepad1.left_stick_y * 1);
            backLeft.setPower(-gamepad1.left_stick_y * 1);

            frontLeft.setPower(-gamepad1.left_stick_y);
            backLeft.setPower(-gamepad1.left_stick_y * .9);

        } else {
            frontLeft.setPower(0);
            backLeft.setPower(0);
        }
        if (Math.abs(gamepad1.right_stick_y) > .1) {

            frontRight.setPower(-gamepad1.right_stick_y * 1);
            backRight.setPower(-gamepad1.right_stick_y * 1);

            frontRight.setPower(-gamepad1.right_stick_y);
            backRight.setPower(-gamepad1.right_stick_y * .9);
        } else {
            frontRight.setPower(0);
            backRight.setPower(0);
        }

        //Strafing Left
        if (Math.abs(gamepad1.left_trigger) > .1){
            frontLeft.setPower(-gamepad1.left_trigger * 1);
            backLeft.setPower(gamepad1.left_trigger * 1);
            frontRight.setPower(gamepad1.left_trigger * 1);
            backRight.setPower(-gamepad1.left_trigger * 1);
        } else if (Math.abs(gamepad1.left_trigger) < .1) {
            frontLeft.setPower(0);
            backLeft.setPower(0);
            frontRight.setPower(0);
            backRight.setPower(0);
        }
        //Strafing Right
        if (Math.abs(gamepad1.right_trigger) > .1) {
            frontLeft.setPower(gamepad1.right_trigger * 1);
            backLeft.setPower(-gamepad1.right_trigger * 1);
            frontRight.setPower(-gamepad1.right_trigger * 1);
            backRight.setPower(gamepad1.right_trigger * 1);
        }
        else if (Math.abs(gamepad1.right_trigger) < .1) {
            frontLeft.setPower(0);
            backLeft.setPower(0);
            frontRight.setPower(0);
            backRight.setPower(0);
        }

        // spool boi power interchangable
        if (Math.abs(gamepad2.left_trigger) > .1) {
            pullyBoi.setPower(gamepad2.left_trigger);
        } else if (Math.abs(gamepad2.right_trigger) > .1) {
            pullyBoi.setPower(-gamepad2.right_trigger);
        }
        else { pullyBoi.setPower(0);
        }

        if (gamepad2.x) {
            intake.setPower(1);
<<<<<<< HEAD
        }
        else if (gamepad2.y){
            intake.setPower(-1);
        }
        else
            intake.setPower(0);
=======
        }
        else if (gamepad2.y) {
            intake.setPower(-1);
        }
        else
            intake.setPower(0);

>>>>>>> 12f95794c520a55fa9391d89918d0d6f0eaa7319



        if (gamepad1.x) {
            moveBoi.setPosition(.8);
            moveBoi2.setPosition(0);
        }
        else if (gamepad1.y){
            moveBoi.setPosition(0);
            moveBoi2.setPosition(.8);
        }


    }

}








