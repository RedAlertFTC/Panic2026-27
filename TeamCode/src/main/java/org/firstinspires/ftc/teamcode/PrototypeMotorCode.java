package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
// Random comment.
@TeleOp(name="PrototypeMotorCode", group="teleOp")
public class PrototypeMotorCode extends LinearOpMode {

    private DcMotor input_motor = null;

  //  @Override
    //public void waitForStart() {
      //  super.waitForStart();
    //}

    @Override
    public void runOpMode(){
        input_motor = hardwareMap.get(DcMotor.class, "im");
        input_motor.setDirection(DcMotor.Direction.FORWARD);

        waitForStart();
        while (opModeIsActive()) {

            if (gamepad1.left_stick_y > 0) {
                input_motor.setPower(500);
            } else if(gamepad1.left_stick_y < 0) {
                input_motor.setPower(-500);
            }
            else{
                input_motor.setPower(0);
            }

            if (gamepad1.right_stick_y > 0) {
                input_motor.setPower(500);
            } else if(gamepad1.right_stick_y < 0) {
                input_motor.setPower(-500);
            }
            else{
                input_motor.setPower(0);
            // run until the end of the match (driver presses STOP)
            /*while (opModeIsActive()) {
                double max;

                // POV Mode uses left joystick to go forward & strafe, and right joystick to rotate.
                double axial   = -gamepad1.left_stick_y;  // Note: pushing stick forward gives negative value
                double lateral =  gamepad1.left_stick_x;
                double yaw     =  gamepad1.right_stick_x;



               // if (max > 1.0) {
                 //   input_motor  /= max;

              //  }

                // This is test code:
                //
                // Uncomment the following code to test your motor directions.
                // Each button should make the corresponding motor run FORWARD.
                //   1) First get all the motors to take to correct positions on the robot
                //      by adjusting your Robot Configuration if necessary.
                //   2) Then make sure they run in the correct direction by modifying the
                //      the setDirection() calls above.
                // Once the correct motors move in the correct direction re-comment this code.

            /*
            frontLeftPower  = gamepad1.x ? 1.0 : 0.0;  // X gamepad
            backLeftPower   = gamepad1.a ? 1.0 : 0.0;  // A gamepad
            frontRightPower = gamepad1.y ? 1.0 : 0.0;  // Y gamepad
            backRightPower  = gamepad1.b ? 1.0 : 0.0;  // B gamepad
            */

                // Send calculated power to wheels
               /* frontLeftDrive.setPower(frontLeftPower);
                frontRightDrive.setPower(frontRightPower);
                backLeftDrive.setPower(backLeftPower);
                backRightDrive.setPower(backRightPower); */
            }
        }
    }
}