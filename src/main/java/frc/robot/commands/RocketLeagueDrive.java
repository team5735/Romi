// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.CommandBase;
import java.util.function.Supplier;

public class RocketLeagueDrive extends CommandBase {
  private final Drivetrain m_drivetrain;
  private final Supplier<Double> m_throttleSupplier;
  private final Supplier<Boolean> m_boostSupplier;
  private final Supplier<Double> m_turnSupplier;

  public RocketLeagueDrive(
      Drivetrain drivetrain,
      Supplier<Double> throttleSupplier,
      Supplier<Boolean> boostSupplier,
      Supplier<Double> turnSupplier) {
    m_drivetrain = drivetrain;
    m_throttleSupplier = throttleSupplier;
    m_boostSupplier = boostSupplier;
    m_turnSupplier = turnSupplier;
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drivetrain.arcadeDrive(m_throttleSupplier.get() * 0.7 + (m_boostSupplier.get() ? 0.3 : 0), m_turnSupplier.get() * 0.69);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
