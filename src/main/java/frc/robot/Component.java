package frc.robot;

//This is an interface that allows us to interact in similar ways with different pieces of code.

public interface Component
{
    public void update();
    public void autoUpdate();
    public void disable();
}