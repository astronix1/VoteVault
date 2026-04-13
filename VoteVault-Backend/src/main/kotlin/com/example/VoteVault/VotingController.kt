package com.example.VoteVault

import org.springframework.web.bind.annotation.*
import org.web3j.utils.Numeric
import java.math.BigInteger

@RestController
class VotingController(private val web3Service: Web3Service) {

    // 1. The DTO (Data Transfer Object)
    // This tells Spring Boot how to read the JSON sent by your Android app
    data class VotePayload(
        val candidateId: Int,
        val messageHash: String, // Expecting a Hex String like "0xab12..."
        val v: Int,              // Expecting an integer (usually 27 or 28)
        val r: String,           // Expecting a Hex String
        val s: String            // Expecting a Hex String
    )

    // 2. The upgraded /vote endpoint
    @PostMapping("/vote")
    fun castVote(@RequestBody payload: VotePayload): String {
        return try {
            // Translate the Hex Strings from the JSON back into ByteArrays for Web3j
            val messageHashBytes = Numeric.hexStringToByteArray(payload.messageHash)
            val rBytes = Numeric.hexStringToByteArray(payload.r)
            val sBytes = Numeric.hexStringToByteArray(payload.s)

            // Convert 'v' to a BigInteger
            val vBigInt = BigInteger.valueOf(payload.v.toLong())

            // Pass everything to your upgraded Web3Service
            val txHash = web3Service.castVote(
                payload.candidateId,
                messageHashBytes,
                vBigInt,
                rBytes,
                sBytes
            )
            "Success! Vote recorded on Sepolia. TX Hash: $txHash"
        } catch (e: Exception) {
            "Error casting vote: ${e.message}"
        }
    }

    // 3. The Score endpoint (Unchanged, as reading is still free and open)
    @GetMapping("/score/{id}")
    fun getScore(@PathVariable id: Int): BigInteger {
        return web3Service.getScore(id)
    }
}