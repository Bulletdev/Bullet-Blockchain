package com.example.blockchain.service;

public class PeerToPeerService {
    private List<Socket> peers = new ArrayList<>();

    public void connectToPeer(String ip, int port) throws IOException {
        Socket socket = new Socket(ip, port);
        peers.add(socket);
        // Implementar lógica para enviar/receber blocos
    }

    public void broadcastBlock(Block newBlock) {
        // Lógica para enviar um novo bloco para todos os peers conectados
    }
}
