package com.example.VoteVault;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.annotation.processing.Generated;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/LFDT-web3j/web3j/tree/main/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.8.0.
 */
@SuppressWarnings("rawtypes")
@Generated("org.web3j.codegen.SolidityFunctionWrapperGenerator")
public class SecureVoting extends Contract {
    public static final String BINARY = "6080604052348015600e575f5ffd5b50335f5f6101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506109e98061005b5f395ff3fe608060405234801561000f575f5ffd5b506004361061007b575f3560e01c80633c3a220d116100595780633c3a220d1461010f5780634a4c560d1461013f578063882e860c1461015b578063f851a440146101775761007b565b806309eef43e1461007f5780630e1af57b146100af5780633af32abf146100df575b5f5ffd5b6100996004803603810190610094919061054c565b610195565b6040516100a69190610591565b60405180910390f35b6100c960048036038101906100c491906105dd565b6101b2565b6040516100d69190610617565b60405180910390f35b6100f960048036038101906100f4919061054c565b6101cc565b6040516101069190610591565b60405180910390f35b610129600480360381019061012491906105dd565b6101e9565b6040516101369190610617565b60405180910390f35b6101596004803603810190610154919061054c565b6101fe565b005b61017560048036038101906101709190610699565b6102e4565b005b61017f6104ca565b60405161018c919061071f565b60405180910390f35b6003602052805f5260405f205f915054906101000a900460ff1681565b5f60015f8381526020019081526020015f20549050919050565b6002602052805f5260405f205f915054906101000a900460ff1681565b6001602052805f5260405f205f915090505481565b5f5f9054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161461028c576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610283906107b8565b60405180910390fd5b600160025f8373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f205f6101000a81548160ff02191690831515021790555050565b5f6001858585856040515f815260200160405260405161030794939291906107f4565b6020604051602081039080840390855afa158015610327573d5f5f3e3d5ffd5b50505060206040510351905060025f8273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f205f9054906101000a900460ff166103bc576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016103b3906108a7565b60405180910390fd5b60035f8273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f205f9054906101000a900460ff1615610446576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161043d90610935565b60405180910390fd5b6001805f8881526020019081526020015f205f8282546104669190610980565b92505081905550600160035f8373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020015f205f6101000a81548160ff021916908315150217905550505050505050565b5f5f9054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b5f5ffd5b5f73ffffffffffffffffffffffffffffffffffffffff82169050919050565b5f61051b826104f2565b9050919050565b61052b81610511565b8114610535575f5ffd5b50565b5f8135905061054681610522565b92915050565b5f60208284031215610561576105606104ee565b5b5f61056e84828501610538565b91505092915050565b5f8115159050919050565b61058b81610577565b82525050565b5f6020820190506105a45f830184610582565b92915050565b5f819050919050565b6105bc816105aa565b81146105c6575f5ffd5b50565b5f813590506105d7816105b3565b92915050565b5f602082840312156105f2576105f16104ee565b5b5f6105ff848285016105c9565b91505092915050565b610611816105aa565b82525050565b5f60208201905061062a5f830184610608565b92915050565b5f819050919050565b61064281610630565b811461064c575f5ffd5b50565b5f8135905061065d81610639565b92915050565b5f60ff82169050919050565b61067881610663565b8114610682575f5ffd5b50565b5f813590506106938161066f565b92915050565b5f5f5f5f5f60a086880312156106b2576106b16104ee565b5b5f6106bf888289016105c9565b95505060206106d08882890161064f565b94505060406106e188828901610685565b93505060606106f28882890161064f565b92505060806107038882890161064f565b9150509295509295909350565b61071981610511565b82525050565b5f6020820190506107325f830184610710565b92915050565b5f82825260208201905092915050565b7f4f6e6c792074686520456c656374696f6e20436f6d6d697373696f6e2063616e5f8201527f2077686974656c69737400000000000000000000000000000000000000000000602082015250565b5f6107a2602a83610738565b91506107ad82610748565b604082019050919050565b5f6020820190508181035f8301526107cf81610796565b9050919050565b6107df81610630565b82525050565b6107ee81610663565b82525050565b5f6080820190506108075f8301876107d6565b61081460208301866107e5565b61082160408301856107d6565b61082e60608301846107d6565b95945050505050565b7f4163636573732044656e6965643a2050686f6e65206973206e6f7420776869745f8201527f656c69737465642e000000000000000000000000000000000000000000000000602082015250565b5f610891602883610738565b915061089c82610837565b604082019050919050565b5f6020820190508181035f8301526108be81610885565b9050919050565b7f4163636573732044656e6965643a205468697320636974697a656e20686173205f8201527f616c726561647920766f7465642e000000000000000000000000000000000000602082015250565b5f61091f602e83610738565b915061092a826108c5565b604082019050919050565b5f6020820190508181035f83015261094c81610913565b9050919050565b7f4e487b71000000000000000000000000000000000000000000000000000000005f52601160045260245ffd5b5f61098a826105aa565b9150610995836105aa565b92508282019050808211156109ad576109ac610953565b5b9291505056fea264697066735822122029329325ff4847c3ca1a704e32cecb24c49f652d7ab3004aca2aefa9f62e20ce64736f6c63430008220033";

    private static String librariesLinkedBinary;

    public static final String FUNC_CASTVOTE = "castVote";

    public static final String FUNC_WHITELISTUSER = "whitelistUser";

    public static final String FUNC_ADMIN = "admin";

    public static final String FUNC_GETSCORE = "getScore";

    public static final String FUNC_HASVOTED = "hasVoted";

    public static final String FUNC_ISWHITELISTED = "isWhitelisted";

    public static final String FUNC_VOTECOUNTS = "voteCounts";

    @Deprecated
    protected SecureVoting(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected SecureVoting(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected SecureVoting(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected SecureVoting(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> castVote(BigInteger candidateId,
            byte[] messageHash, BigInteger v, byte[] r, byte[] s) {
        final Function function = new Function(
                FUNC_CASTVOTE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(candidateId), 
                new org.web3j.abi.datatypes.generated.Bytes32(messageHash), 
                new org.web3j.abi.datatypes.generated.Uint8(v), 
                new org.web3j.abi.datatypes.generated.Bytes32(r), 
                new org.web3j.abi.datatypes.generated.Bytes32(s)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> whitelistUser(String userPublicKey) {
        final Function function = new Function(
                FUNC_WHITELISTUSER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, userPublicKey)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> admin() {
        final Function function = new Function(FUNC_ADMIN, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> getScore(BigInteger candidateId) {
        final Function function = new Function(FUNC_GETSCORE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(candidateId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Boolean> hasVoted(String param0) {
        final Function function = new Function(FUNC_HASVOTED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<Boolean> isWhitelisted(String param0) {
        final Function function = new Function(FUNC_ISWHITELISTED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<BigInteger> voteCounts(BigInteger param0) {
        final Function function = new Function(FUNC_VOTECOUNTS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    @Deprecated
    public static SecureVoting load(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return new SecureVoting(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static SecureVoting load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new SecureVoting(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static SecureVoting load(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        return new SecureVoting(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static SecureVoting load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new SecureVoting(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<SecureVoting> deploy(Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        return deployRemoteCall(SecureVoting.class, web3j, credentials, contractGasProvider, getDeploymentBinary(), "");
    }

    public static RemoteCall<SecureVoting> deploy(Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(SecureVoting.class, web3j, transactionManager, contractGasProvider, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<SecureVoting> deploy(Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(SecureVoting.class, web3j, credentials, gasPrice, gasLimit, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<SecureVoting> deploy(Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(SecureVoting.class, web3j, transactionManager, gasPrice, gasLimit, getDeploymentBinary(), "");
    }

    public static void linkLibraries(List<Contract.LinkReference> references) {
        librariesLinkedBinary = linkBinaryWithReferences(BINARY, references);
    }

    private static String getDeploymentBinary() {
        if (librariesLinkedBinary != null) {
            return librariesLinkedBinary;
        } else {
            return BINARY;
        }
    }
}
