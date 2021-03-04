package gymmanagement;

public class Member {
    // fields
    private char memberType;
    private int memberID;
    private String memberName;
    private double membershipPrice;

    // constructor
    public Member(char memberType, int memberID, String memberName, double memberPrice) {
        this.memberType = memberType;
        this.memberID = memberID;
        this.memberName = memberName;
        this.membershipPrice = memberPrice;
    }

    // setters
    public void setMemberType(char memberType) {
        this.memberType = memberType;
    }
    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }
    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
    public void setMemberPrice(double memberPrice) {
        this.membershipPrice = memberPrice;
    }

    // getters
    public char getMemberType() {
        return memberType;
    }
    public int getMemberID() {
        return memberID;
    }
    public String getMemberName() {
        return memberName;
    }
    public double getMemberPrice() {
        return membershipPrice;
    }

    //
    @Override
    public String toString() {
        return this.memberType + ", " + this.memberID + ", " + this.memberName + ", " + this.membershipPrice;
    }
}
