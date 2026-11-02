package cse213.questionsolvingmidterm;

import java.time.LocalDate;

public class Politician {
    private int memberId;
    private String memberType,partyName;
    private boolean isGovtPosition,hasOwnElection;
    private float annualMembershipFee;
    private LocalDate dateOfJoining;

    public Politician(int memberId, String memberType, String partyName, boolean isGovtPosition, boolean hasOwnElection, float annualMembershipFee, LocalDate dateOfJoining) {
        this.memberId = memberId;
        this.memberType = memberType;
        this.partyName = partyName;
        this.isGovtPosition = isGovtPosition;
        this.hasOwnElection = hasOwnElection;
        this.annualMembershipFee = annualMembershipFee;
        this.dateOfJoining = dateOfJoining;
    }

    public int getMemberId() {
        return memberId;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public String getPartyName() {
        return partyName;
    }


    public boolean isGovtPosition() {
        return isGovtPosition;
    }

    public void setGovtPosition(boolean govtPosition) {
        isGovtPosition = govtPosition;
    }

    public boolean isHasOwnElection() {
        return hasOwnElection;
    }

    public void setHasOwnElection(boolean hasOwnElection) {
        this.hasOwnElection = hasOwnElection;
    }

    public double getAnnualMembershipFee() {
        return annualMembershipFee;
    }

    public void setAnnualMembershipFee(float annualMembershipFee) {
        this.annualMembershipFee = annualMembershipFee;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    @Override
    public String toString() {
        return "Politician{" +
                "memberId=" + memberId +
                ", memberType='" + memberType + '\'' +
                ", partyName='" + partyName + '\'' +
                ", isGovtPosition=" + isGovtPosition +
                ", hasOwnElection=" + hasOwnElection +
                ", annualMembershipFee=" + annualMembershipFee +
                ", dateOfJoining=" + dateOfJoining +
                '}';
    }

    public float returnMonthlyPayableToPartyFund(){
        float fee;
        if(isGovtPosition){
             fee = annualMembershipFee + annualMembershipFee*(20/100);
        }
        else{
             fee  = annualMembershipFee;
        }
        return fee;

   }
}
