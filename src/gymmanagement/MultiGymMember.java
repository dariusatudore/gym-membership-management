package gymmanagement;

public class MultiGymMember extends Member{
    // fields
    private int memberPoints;

    // constructor
    public MultiGymMember(char memberType, int memberID, String memberName, double memberPrice, int memberPoints) {
        super(memberType, memberID, memberName, memberPrice);
        this.memberPoints = memberPoints;
    }

    // setters
    public void setMemberPoints(int memberPoints) {
        this.memberPoints = memberPoints;
    }

    // getters
    public int getMemberPoints() {
        return memberPoints;
    }

    //
    @Override
    public String toString() {
        return super.toString() + ", " + this.memberPoints;
    }
}
