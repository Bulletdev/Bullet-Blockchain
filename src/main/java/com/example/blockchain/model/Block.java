package com.example.blockchain.model;

public class Block {
    public String hash;
    public String previousHash;
    private long timeStamp;
    private int nonce;
    private List<Transaction> transactions;

    public Block(String previousHash, List<Transaction> transactions) {
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.transactions = transactions;
        this.hash = calculateHash();
    }

    public String calculateHash() {
        // Implementação do hash usando SHA-256
        return Util.applySha256(previousHash + Long.toString(timeStamp) + Integer.toString(nonce) + transactions);
    }

    public void mineBlock(int difficulty) {
        // Mineração usando Proof of Work, ajustando o nonce
        String target = new String(new char[difficulty]).replace('\0', '0');
        while (!hash.substring(0, difficulty).equals(target)) {
            nonce++;
            hash = calculateHash();
        }
    }
}
