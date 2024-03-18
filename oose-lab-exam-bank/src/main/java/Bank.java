import java.util.HashMap;
import java.util.List;

public class Bank {
    LoadCSV loadCSV = new LoadCSV();
    HashMap<AssetType, TraderAssetDesk> desks = new HashMap<>();

    public Bank() {
        setUpTraderAssetDesk();
        setUpPeople();
    }

    public void allTrades() {
        for (TraderAssetDesk desk : desks.values()) {
            desk.trade();
        }
    }

    // Set up TraderAssetDesks for each AssetType
    private void setUpTraderAssetDesk() {
        for (AssetType assetType : AssetType.values()) {
            desks.put(assetType, new TraderAssetDesk(assetType));
        }
    }

    // Adds people to their respective TraderAssetDesks based on CSV data
    protected void setUpPeople() {
        List<String[]> csvPeople = loadCSV.getCSVRows("src/main/resource/people.csv");
        for (String[] row : csvPeople) {
            Person person = PersonFactory.createPerson(row);
            // Set the balance using the newly added setter method in the Person class
            double balance = Double.parseDouble(row[4]);
            person.setBalance(balance);
            // Now add the person to their respective TraderAssetDesk
            TraderAssetDesk desk = getTraderAssetDesk(AssetType.valueOf(row[3]));
            if (desk != null) {
                desk.addTrader(person);
            }
        }
    }

    // Retrieves the TraderAssetDesk for a given AssetType
    public TraderAssetDesk getTraderAssetDesk(AssetType assetType) {
        return desks.get(assetType);
    }

    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.allTrades();
        // Test 1: Print all trader details for the algorithmic desk
        System.out.println("Test 1: Algorithmic Desk - Trader Details:");
        TraderAssetDesk algorithmicDesk = bank.getTraderAssetDesk(AssetType.ALGORITHMIC);
        algorithmicDesk.printAllTraderDetails();

        // Test 2: Check balances for the algorithmic desk
        System.out.println("\nTest 2: Algorithmic Desk - Balance Check:");
        algorithmicDesk.checkBalances();

        // Test 3: Print all trader details for all desks
        System.out.println("\nTest 3: All Desks - Trader Details:");
        for (AssetType assetType : AssetType.values()) {
            TraderAssetDesk desk = bank.getTraderAssetDesk(assetType);
            desk.printAllTraderDetails();
        }

        // Test 4: Check balances for all desks
        System.out.println("\nTest 4: All Desks - Balance Check:");
        for (AssetType assetType : AssetType.values()) {
            TraderAssetDesk desk = bank.getTraderAssetDesk(assetType);
            desk.checkBalances();
        }
        }
}