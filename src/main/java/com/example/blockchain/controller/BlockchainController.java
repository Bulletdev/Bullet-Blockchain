package com.example.blockchain.controller;

import com.example.blockchain.model.Block;
import com.example.blockchain.model.Transaction;
import com.example.blockchain.service.BlockchainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/blockchain")
public class BlockchainController {

    @Autowired
    private BlockchainService blockchainService;

    @GetMapping("/chain")
    public ResponseEntity<?> getBlockchain() {
        return ResponseEntity.ok(blockchainService.getBlockchain());
    }

    @PostMapping("/transaction")
    public ResponseEntity<?> createTransaction(@RequestBody Transaction transaction, HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token == null || !JwtUtil.validateToken(token)) {
            return ResponseEntity.status(401).body("Unauthorized");
        }
        blockchainService.addTransaction(transaction);
        return ResponseEntity.ok("Transaction added");
    }

    @PostMapping("/mine")
    public ResponseEntity<?> mineBlock(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token == null || !JwtUtil.validateToken(token)) {
            return ResponseEntity.status(401).body("Unauthorized");
        }
        Block newBlock = blockchainService.minePendingTransactions();
        return ResponseEntity.ok(newBlock);
    }
}
