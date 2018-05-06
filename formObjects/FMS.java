/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.formObjects;

/**
 * FMS Score Sheet Model Object.
 *
 * It represents the form used to score each athlete.
 *
 * It contains a total of 7 tests and uses their final score to generate a final
 * report or score.
 *
 *
 *
 */
public class FMS {

    private int deepSquatRaw, deepSquatFinal;
    private int hurdleStepRawL, hurdleStepRawR, hurdleStepFinal;
    private int inlineLoungeRawL, inlineLoungeRawR, inlineLoungeFinal;
    private int shoulderMobilityRawL, shoulderMobilityRawR, shoulderMobilityFinal;
    private boolean shoulderClearingL, shoulderClearingR;
    private int legRaiseRawL, legRaiseRawR, legRaiseFinal;
    private int trunkStabilityRaw, trunkStabilityFinal;
    private boolean extensionClearing;
    private int rotaryRawL, rotaryRawR, rotaryFinal;
    private boolean flexionClearing;
    private int total;
    
    private String deepSquatComment,hurdleStepComment,inlineLoungeComment,shoulderMobilityComment,shoulderClearingComment,
            legRaiseComment, trunkStabilityComment,extensionClearingComment,rotaryComment,flexionComment;
    /**
     *
     */
    public FMS(int deepSquatRaw, int hurdleStepRawL, int hurdleStepRawR, int inlineLoungeRawL, int inlineLoungeRawR,
            int shoulderMobilityRawL, int shoulderMobilityRawR, boolean shoulderClearingL, boolean shoulderClearingR,
            int legRaiseRawL, int legRaiseRawR, int trunkStabilityRaw, boolean extensionClearing, int rotaryRawL, int rotaryRawR,
            boolean flexionClearing, int total) {
            
        this.deepSquatRaw = deepSquatRaw;
        this.deepSquatFinal = deepSquatRaw;
        this.hurdleStepRawL=hurdleStepRawL;
        this.hurdleStepRawR=hurdleStepRawR;
        this.hurdleStepFinal=Math.min(hurdleStepRawL, hurdleStepRawR);
        this.inlineLoungeRawL=inlineLoungeRawL;
        this.inlineLoungeRawR=inlineLoungeRawR;
        this.inlineLoungeFinal =Math.min(inlineLoungeRawL, inlineLoungeRawR);
        this.shoulderMobilityRawL=shoulderMobilityRawL;
        this.shoulderMobilityRawR=shoulderMobilityRawR;
        //If clearing test are true then set score to 0
        this.shoulderClearingL=shoulderClearingL;
        this.shoulderClearingR=shoulderClearingR;
        this.shoulderMobilityFinal =(shoulderClearingL || shoulderClearingR)?0:Math.min(shoulderMobilityRawL, shoulderMobilityRawR);               
        this.legRaiseRawL=legRaiseRawL;
        this.legRaiseRawR=legRaiseRawR;
        this.legRaiseFinal =Math.min(legRaiseRawL, legRaiseRawR);
        this.trunkStabilityRaw = trunkStabilityRaw;
        this.extensionClearing = extensionClearing;
        this.trunkStabilityFinal =(extensionClearing)?0:trunkStabilityRaw;
        this.rotaryRawL=rotaryRawL;
        this.rotaryRawR=rotaryRawR;
        this.flexionClearing = flexionClearing;
        this.rotaryFinal= (flexionClearing)? 0 : Math.min(rotaryRawL, rotaryRawR);
        this.total = total;
        
                
    }
    
    public void setComments(String deepSquatComment,String hurdleStepComment,String inlineLoungeComment,String shoulderMobilityComment,String shoulderClearingComment,
            String legRaiseComment,String trunkStabilityComment,String extensionClearingComment,String rotaryComment,String flexionComment){
        
    }

}
