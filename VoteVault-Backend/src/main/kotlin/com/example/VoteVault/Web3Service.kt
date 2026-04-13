package com.example.VoteVault

import org.springframework.stereotype.Service
import org.web3j.crypto.Credentials
import org.web3j.protocol.Web3j
import org.web3j.protocol.http.HttpService
import org.web3j.tx.gas.DefaultGasProvider
import java.math.BigInteger

@Service
class Web3Service {

    // 1. Connect to the Blockchain Network
    private val web3j = Web3j.build(HttpService("https://eth-sepolia.g.alchemy.com/v2/AmPEhr7K7VaYGXWLyR2ht"))

    // 2. The Server's Wallet (The Election Commission / Relayer)
    private val credentials = Credentials.create("1e8318e2a4532a678123c9677e04b616cbf33d80afaa0d0291b900e570a8e604")

    // 3. Load your auto-generated Smart Contract
    private val contract = SecureVoting.load(
        "0xA31b80c19F89dA0baae73D5aE89F69D4d4BCa5C1",
        web3j,
        credentials,
        DefaultGasProvider()
    )

    // NEW: The KYC Gateway. Spring Boot calls this after verifying a user's ID
    fun whitelistUser(userAddress: String): String {
        val receipt = contract.whitelistUser(userAddress).send()
        return receipt.transactionHash
    }

    // UPDATED: Now requires the cryptographic signature from the Android phone
    fun castVote(
        candidateId: Int,
        messageHash: ByteArray,
        v: BigInteger,
        r: ByteArray,
        s: ByteArray
    ): String {
        val id = BigInteger.valueOf(candidateId.toLong())

        // Pass the candidate AND the signature to the blockchain
        val receipt = contract.castVote(id, messageHash, v, r, s).send()
        return receipt.transactionHash
    }

    fun getScore(candidateId: Int): BigInteger {
        val id = BigInteger.valueOf(candidateId.toLong())
        return contract.getScore(id).send()
    }
}