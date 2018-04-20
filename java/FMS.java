/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java;

/**
 *
 * @author Mario
 */
public class FMS {

    private FMSTest deepSquat;
    private FMSTest hurdleStep;
    private FMSTest inlineLunge;
    private FMSTest activeStraightLegRaise;
    private FMSCompositeTest shoulder;
    private FMSCompositeTest trunkAndExtension;
    private FMSCompositeTest rotaryAndFlexion;

    public FMS() {
        this.deepSquat = new FMSTest("Deep Squat");
        this.hurdleStep = new FMSTest("Hurdle Step");
        this.inlineLunge = new FMSTest("Inline Lunge");
        this.activeStraightLegRaise = new FMSTest("Active Straight-Leg Raise");
        //COmposite tests initialization
        this.shoulder = new FMSCompositeTest(new FMSTest("Shoulder Mobility"), new FMSTest("Shoulder Clearing Test"));
        this.trunkAndExtension = new FMSCompositeTest(new FMSTest("Trunk Stability Push-Up"), new FMSTest("Extension Clearing Test"));
        this.rotaryAndFlexion = new FMSCompositeTest(new FMSTest("Rotary Mobility"), new FMSTest("Flexion Clearing Test"));
    }

    /**
     * @return the deepSquat
     */
    public FMSTest getDeepSquat() {
        return deepSquat;
    }

    /**
     * @return the hurdleStep
     */
    public FMSTest getHurdleStep() {
        return hurdleStep;
    }

    /**
     * @return the inlineLunge
     */
    public FMSTest getInlineLunge() {
        return inlineLunge;
    }

    /**
     * @return the activeStraightLegRaise
     */
    public FMSTest getActiveStraightLegRaise() {
        return activeStraightLegRaise;
    }

    /**
     * @return the shoulder
     */
    public FMSCompositeTest getShoulder() {
        return shoulder;
    }

    /**
     * @return the trunkAndExtension
     */
    public FMSCompositeTest getTrunkAndExtension() {
        return trunkAndExtension;
    }

    /**
     * @return the rotaryAndFlexion
     */
    public FMSCompositeTest getRotaryAndFlexion() {
        return rotaryAndFlexion;
    }
}
