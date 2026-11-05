package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.IMU;
import org.firstinspires.ftc.robotcore.external.navigation.Pose3D;

@Autonomous
public class LimeLightApril extends OpMode {

    private Limelight3A limelight3A;
    private IMU imu;

    @Override
    public void init() {
        limelight3A = hardwareMap.get(Limelight3A.class, "limelight");
        limelight3A.pipelineSwitch(8); // AprilTag pipeline

        imu = hardwareMap.get(IMU.class, "imu");

        RevHubOrientationOnRobot revHubOrientationOnRobot =
                new RevHubOrientationOnRobot(
                        RevHubOrientationOnRobot.LogoFacingDirection.UP,
                        RevHubOrientationOnRobot.UsbFacingDirection.FORWARD
                );

        imu.initialize(new IMU.Parameters(revHubOrientationOnRobot));
    }

    @Override
    public void start() {
        limelight3A.start();
    }

    @Override
    public void loop() {
        LLResult llResult = limelight3A.getLatestResult();

        if (llResult != null && llResult.isValid()) {
            Pose3D botpose = llResult.getBotpose();

            telemetry.addData("Target X", llResult.getTx());
            telemetry.addData("Target Y", llResult.getTy());
            telemetry.addData("Target Area", llResult.getTa());
            telemetry.addData("BotPose", botpose.toString());
            telemetry.addData(
                    "Yaw",
                    botpose.getOrientation().getYaw()
            );
        }

        telemetry.update();
    }
}