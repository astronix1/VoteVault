package com.example.VoteVault

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.web3j.crypto.Hash
import org.web3j.crypto.Keys
import org.web3j.crypto.Sign
import java.math.BigInteger

@RestController
class TestController(private val web3Service: Web3Service) {

    @GetMapping("/test-engine")
    fun runFullTest(): String {
        try {
            // STEP 1: Simulate the Android Phone generating a local Private Key
            val mockPhoneKeyPair = Keys.createEcKeyPair()
            val mockPhoneAddress = "0x" + Keys.getAddress(mockPhoneKeyPair)
            println("Created Mock Phone Wallet: $mockPhoneAddress")

            // STEP 2: The Server (Admin) whitelists this new phone
            println("Whitelisting phone on Sepolia... (Please wait ~15 seconds)")
            val whitelistTx = web3Service.whitelistUser(mockPhoneAddress)

            // STEP 3: The Phone mathematically signs a vote for Candidate #1
            val candidateId = 1
            val message = "Vote for Candidate $candidateId"

            // Web3 strictly requires signing the Keccak256 hash of the message
            val messageHash = Hash.sha3(message.toByteArray())

            // Generate the v, r, s signature
            val signature = Sign.signMessage(messageHash, mockPhoneKeyPair, false)

            // STEP 4: The Phone sends the signature to the Server, Server relays to Web3
            println("Submitting signed vote... (Please wait ~15 seconds)")
            val voteTx = web3Service.castVote(
                candidateId,
                messageHash,
                BigInteger(1, signature.v),
                signature.r,
                signature.s
            )

            // Return the Etherscan links so you can prove it worked!
            return """
                <h1>Test Complete!</h1>
                <p><b>Mock Phone Address:</b> $mockPhoneAddress</p>
                <p><b>Whitelist TX:</b> <a href="https://sepolia.etherscan.io/tx/$whitelistTx" target="_blank">$whitelistTx</a></p>
                <p><b>Vote TX:</b> <a href="https://sepolia.etherscan.io/tx/$voteTx" target="_blank">$voteTx</a></p>
            """.trimIndent()

        } catch (e: Exception) {
            return "Error during test: ${e.message}"
        }
    }
}