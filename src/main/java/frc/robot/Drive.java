package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Drive implements Component
{
    //A multipier for speed
    final double MULTIPLIER = .4;

    //Correspond to the four motors
    WPI_TalonSRX leftFront;
    WPI_TalonSRX leftBack;
    WPI_TalonSRX rightFront;
    WPI_TalonSRX rightBack;

    //These essentially allow us to treat two motors as a single unit
    SpeedControllerGroup leftDrive;
    SpeedControllerGroup rightDrive;

    //A system for driving
    DifferentialDrive dDrive;


    //Constructor
    public Drive()
    {
        //Initialize the 4 motors as new talons with the given ports
        leftFront = new WPI_TalonSRX(RobotMap.LEFT_FRONT_MOTOR);
        rightFront = new WPI_TalonSRX(RobotMap.RIGHT_FRONT_MOTOR);
        leftBack = new WPI_TalonSRX(RobotMap.LEFT_BACK_MOTOR);
        rightBack = new WPI_TalonSRX(RobotMap.RIGHT_BACK_MOTOR);

        //Initializes the speed controllers. 
        leftDrive = new SpeedControllerGroup(leftFront, leftBack);
        rightDrive = new SpeedControllerGroup(rightFront, rightBack);

        //Initializes the differential drive
        dDrive = new DifferentialDrive(leftDrive, rightDrive);
    }


    @Override
    public void update() {
        dDrive.arcadeDrive(MULTIPLIER * (RobotMap.driveController.getY(GenericHID.Hand.kLeft)),
                MULTIPLIER * (-RobotMap.driveController.getX(GenericHID.Hand.kLeft)));
    }

    @Override
    public void autoUpdate() {

    }

    @Override
    public void disable() {

    }

}