public class Transaction {
    public String transactionId;
    public PublicKey sender;
    public PublicKey recipient;
    public float value;
    public byte[] signature;

    public Transaction(PublicKey from, PublicKey to, float value) {
        this.sender = from;
        this.recipient = to;
        this.value = value;
        this.transactionId = calculateHash();
    }

    public String calculateHash() {
        return Util.applySha256(Util.getStringFromKey(sender) + Util.getStringFromKey(recipient) + Float.toString(value));
    }

    public void generateSignature(PrivateKey privateKey) {
        String data = Util.getStringFromKey(sender) + Util.getStringFromKey(recipient) + Float.toString(value);
        signature = Util.applyECDSASig(privateKey, data);
    }

    public boolean verifySignature() {
        String data = Util.getStringFromKey(sender) + Util.getStringFromKey(recipient) + Float.toString(value);
        return Util.verifyECDSASig(sender, data, signature);
    }
}
