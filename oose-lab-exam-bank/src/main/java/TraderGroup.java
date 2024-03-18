import java.util.List;
import java.util.ArrayList;

public class TraderGroup implements TradingComposite {

    private List<TradingComposite> members = new ArrayList<>();
    private String name;

    public TraderGroup(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void checkBalances(TraderAssetDesk desk) {
        for (TradingComposite member : members) {
            member.checkBalances(desk); // Recursively check balances for all members
        }
    }

    @Override
    public void printDetails() {
        System.out.println("Trader Group: " + name);
        for (TradingComposite member : members) {
            member.printDetails();
        }
    }

    @Override
    public void add(TradingComposite member) {
        this.members.add(member);
    }

    public List<TradingComposite> getMembers() {
        return new ArrayList<>(members); // Retrun a devensive Copy of the list
    }
}