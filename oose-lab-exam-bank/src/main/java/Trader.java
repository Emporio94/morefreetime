public class Trader{
    
    private AssetType assetType;
    private String[] trades;
    protected int balance = 0;
    private int tradeCounter = 0;   
    private Person person; 

    public Trader(Person person, AssetType assetType, int balance, String[] trades){
        this.person = person;
        this.assetType = assetType;
        this.trades = trades;
        this.balance = balance;
    }

    public void checkBalance(TraderAssetDesk desk) {
        if (balance < desk.getWib()) {
            System.out.println(getName() + " is below the warning limit.");
        } else if (balance > desk.getWia()) {
            System.out.println(getName() + " is above the warning limit.");
        }
    }

    public String getName(){
        return person.getName();
    }

    public AssetType getAssetType(){
        return assetType;
    }

    public Role getRole(){
        return person.getRole();
    }

    public void trade(){
        balance += Integer.parseInt(trades[tradeCounter]);
        tradeCounter ++;
    }

}