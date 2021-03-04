package gymmanagement;

public class SingleGymMember extends Member{
    // fields
    private int memberGym;

    // constructor
    public SingleGymMember(char memberType, int memberID, String memberName, double memberPrice, int memberGym) {
        super(memberType, memberID, memberName, memberPrice);
        this.memberGym = memberGym;
    }

    // setters
    public void setMemberGym(int memberGym) {
        this.memberGym = memberGym;
    }

    // getters
    public int getMemberGym() {
        return this.memberGym;
    }

    //
    @Override
    public String toString() {
        return super.toString() + ", " + this.memberGym;
    }
}
