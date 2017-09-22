package org.mposch.solidityContractWrapper;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Future;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.EventValues;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import rx.Observable;
import rx.functions.Func1;

/**
 * Auto generated code.<br>
 * <strong>Do not modify!</strong><br>
 * Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>, or {@link org.web3j.codegen.SolidityFunctionWrapperGenerator} to update.
 *
 * <p>Generated with web3j version 2.3.0.
 */
public final class RecordStorage extends Contract {
    private static final String BINARY = "606060405260408051908101604052600381527f312e340000000000000000000000000000000000000000000000000000000000602082015260009080516200004d92916020019062000168565b5060018054600160a060020a03191633600160a060020a03161790554260025534156200007957600080fd5b5b60018054620000a391600160a060020a039091169064010000000062000a80620000d382021704565b60018054620000cc91600160a060020a03909116906401000000006200088a6200011b82021704565b5b62000212565b600154600160a060020a039081169033168114620000f057600080fd5b600160a060020a0383166000908152600660205260409020805460ff19168315151790555b5b505050565b600154600160a060020a0390811690331681146200013857600080fd5b600160a060020a0383166000908152600660205260409020805461ff001916610100841515021790555b5b505050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10620001ab57805160ff1916838001178555620001db565b82800160010185558215620001db579182015b82811115620001db578251825591602001919060010190620001be565b5b50620001ea929150620001ee565b5090565b6200020f91905b80821115620001ea5760008155600101620001f5565b5090565b90565b6110ca80620002226000396000f300606060405236156101045763ffffffff7c0100000000000000000000000000000000000000000000000000000000600035041663257a114381146101095780633801ebc61461013c57806349ea0618146101ad57806354fd4d50146101e05780635c52c0741461026b5780635dbe47e81461029057806373a920da146102c35780637518e4fe146102e95780637d4344251461031b57806384486d90146103b2578063877c1214146103d75780638da5cb5b146103fd578063a87d942c1461042c578063cc81140714610451578063d8270dce1461046c578063dc8bee9214610491578063e2778ee5146104c2578063f50a6443146104ea578063f5187dee14610514575b600080fd5b341561011457600080fd5b610128600160a060020a0360043516610587565b604051901515815260200160405180910390f35b341561014757600080fd5b61019b60048035600160a060020a03169060446024803590810190830135806020601f820181900481020160405190810160405281815292919060208401838380828437509496506105a995505050505050565b60405190815260200160405180910390f35b34156101b857600080fd5b610128600160a060020a036004351661071f565b604051901515815260200160405180910390f35b34156101eb57600080fd5b6101f3610746565b60405160208082528190810183818151815260200191508051906020019080838360005b838110156102305780820151818401525b602001610217565b50505050905090810190601f16801561025d5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b341561027657600080fd5b61019b6107e4565b60405190815260200160405180910390f35b341561029b57600080fd5b610128600160a060020a0360043516610819565b604051901515815260200160405180910390f35b34156102ce57600080fd5b6102e7600160a060020a0360043516602435151561088a565b005b34156102f457600080fd5b6102ff6004356108d6565b604051600160a060020a03909116815260200160405180910390f35b341561032657600080fd5b6101f3600160a060020a0360043516610939565b60405160208082528190810183818151815260200191508051906020019080838360005b838110156102305780820151818401525b602001610217565b50505050905090810190601f16801561025d5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34156103bd57600080fd5b61019b610a4b565b60405190815260200160405180910390f35b34156103e257600080fd5b6102e7600160a060020a03600435166024351515610a80565b005b341561040857600080fd5b6102ff610ac7565b604051600160a060020a03909116815260200160405180910390f35b341561043757600080fd5b61019b610ad6565b60405190815260200160405180910390f35b341561045c57600080fd5b6102e7600435602435610b0b565b005b341561047757600080fd5b61019b610b38565b60405190815260200160405180910390f35b341561049c57600080fd5b61019b600160a060020a0360043516610b3e565b60405190815260200160405180910390f35b34156104cd57600080fd5b61019b600435610d51565b60405190815260200160405180910390f35b34156104f557600080fd5b610128600435610db6565b604051901515815260200160405180910390f35b341561051f57600080fd5b61012860048035600160a060020a03169060446024803590810190830135806020601f82018190048102016040519081016040528181529291906020840183838082843750949650610e5395505050505050565b604051901515815260200160405180910390f35b600160a060020a03811660009081526006602052604090205460ff165b919050565b600160a060020a03331660009081526006602052604081205460ff1615156105d057600080fd5b6105d983610819565b156105e357600080fd5b600160a060020a038316600090815260056020526040902082805161060c929160200190610f98565b506001600780548060010182816106239190611017565b916000526020600020900160005b8154600160a060020a038089166101009390930a838102910219909116179091556000818152600560205260409081902093909203600193909301839055917f67a48f38e10dc5aac739d90e6c86181e1dec2cfee3269002e83dbbc0941cb2c99185905182815260406020820181815290820183818151815260200191508051906020019080838360005b838110156106d55780820151818401525b6020016106bc565b50505050905090810190601f1680156107025780820380516001836020036101000a031916815260200191505b50935050505060405180910390a250600754600019015b92915050565b600160a060020a038116600090815260066020526040902054610100900460ff165b919050565b60008054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156107dc5780601f106107b1576101008083540402835291602001916107dc565b820191906000526020600020905b8154815290600101906020018083116107bf57829003601f168201915b505050505081565b33600160a060020a0316600090815260066020526040812054610100900460ff16151561081057600080fd5b506003545b5b90565b600754600090151561082d575060006105a4565b600160a060020a03821660008181526005602052604090206001015460078054909190811061085857fe5b906000526020600020900160005b9054906101000a9004600160a060020a0316600160a060020a03161490505b919050565b600154600160a060020a0390811690331681146108a657600080fd5b600160a060020a0383166000908152600660205260409020805461ff001916610100841515021790555b5b505050565b33600160a060020a0316600090815260066020526040812054610100900460ff16151561090257600080fd5b600780548390811061091057fe5b906000526020600020900160005b9054906101000a9004600160a060020a031690505b5b919050565b610941611041565b33600160a060020a0316600090815260066020526040902054610100900460ff16151561096d57600080fd5b61097682610819565b151561098157600080fd5b6005600083600160a060020a0316600160a060020a031681526020019081526020016000206000018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610a3d5780601f10610a1257610100808354040283529160200191610a3d565b820191906000526020600020905b815481529060010190602001808311610a2057829003601f168201915b505050505090505b5b919050565b33600160a060020a0316600090815260066020526040812054610100900460ff161515610a7757600080fd5b506004545b5b90565b600154600160a060020a039081169033168114610a9c57600080fd5b600160a060020a0383166000908152600660205260409020805460ff19168315151790555b5b505050565b600154600160a060020a031681565b33600160a060020a0316600090815260066020526040812054610100900460ff161515610b0257600080fd5b506007545b5b90565b600154600160a060020a039081169033168114610b2757600080fd5b600383905560048290555b5b505050565b60025481565b33600160a060020a031660009081526006602052604081205481908190610100900460ff161515610b6e57600080fd5b610b7784610819565b1515610b8257600080fd5b600160a060020a03841660009081526005602052604090206001015460078054919350906000198101908110610bb457fe5b906000526020600020900160005b9054906101000a9004600160a060020a0316905080600783815481101515610be657fe5b906000526020600020900160005b8154600160a060020a039384166101009290920a9182029184021916179055811660009081526005602052604090206001018290556007805490610c3c906000198301611017565b5083600160a060020a03167fc081e614396db3b3fb106e28510023a2809ea427581eb82dc77e8c8fe9ead0848360405190815260200160405180910390a2600160a060020a038116600081815260056020526040908190207fa0fe756b7d8c5beeccd8b5643a32e5c78f85181b84521b253c61863dcbbd97e8918591905182815260406020820181815283546002600019610100600184161502019091160491830182905290606083019084908015610d365780601f10610d0b57610100808354040283529160200191610d36565b820191906000526020600020905b815481529060010190602001808311610d1957829003601f168201915b5050935050505060405180910390a28192505b5b5050919050565b33600160a060020a0316600090815260066020526040812054610100900460ff161515610d7d57600080fd5b610d8682610db6565b15610d925750806105a4565b600454821015610da557506004546105a4565b506003546105a4565b5b5b5b919050565b33600160a060020a0316600090815260066020526040812054610100900460ff161515610de257600080fd5b600454821080610df3575060035482115b15610e44577ff2e8da6fdefcd9e24fce8bc93fa48bff9e5c8731eaad198a27b8546940d524843383604051600160a060020a03909216825260208201526040908101905180910390a15060006105a4565b5060016105a4565b5b5b919050565b33600160a060020a0316600090815260066020526040812054610100900460ff161515610e7f57600080fd5b610e8883610819565b1515610e9357600080fd5b600160a060020a0383166000908152600560205260409020828051610ebc929160200190610f98565b50600160a060020a0383166000818152600560205260409081902060018101547fa0fe756b7d8c5beeccd8b5643a32e5c78f85181b84521b253c61863dcbbd97e8929091905182815260406020820181815283546002600019610100600184161502019091160491830182905290606083019084908015610f7e5780601f10610f5357610100808354040283529160200191610f7e565b820191906000526020600020905b815481529060010190602001808311610f6157829003601f168201915b5050935050505060405180910390a25060015b5b92915050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10610fd957805160ff1916838001178555611006565b82800160010185558215611006579182015b82811115611006578251825591602001919060010190610feb565b5b5061101392915061107d565b5090565b8154818355818115116108d0576000838152602090206108d091810190830161107d565b5b505050565b60206040519081016040526000815290565b8154818355818115116108d0576000838152602090206108d091810190830161107d565b5b505050565b61081591905b808211156110135760008155600101611083565b5090565b905600a165627a7a723058205bd8fddbb0fcb66d1d3ab0a508bb649f1c70878865f45de79815697f7ab7128a0029";

    private RecordStorage(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    private RecordStorage(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public List<LogNewStringEventResponse> getLogNewStringEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("LogNewString", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<LogNewStringEventResponse> responses = new ArrayList<LogNewStringEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            LogNewStringEventResponse typedResponse = new LogNewStringEventResponse();
            typedResponse.userAddress = (Address) eventValues.getIndexedValues().get(0);
            typedResponse.index = (Uint256) eventValues.getNonIndexedValues().get(0);
            typedResponse.data = (Utf8String) eventValues.getNonIndexedValues().get(1);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<LogNewStringEventResponse> logNewStringEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("LogNewString", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, LogNewStringEventResponse>() {
            @Override
            public LogNewStringEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                LogNewStringEventResponse typedResponse = new LogNewStringEventResponse();
                typedResponse.userAddress = (Address) eventValues.getIndexedValues().get(0);
                typedResponse.index = (Uint256) eventValues.getNonIndexedValues().get(0);
                typedResponse.data = (Utf8String) eventValues.getNonIndexedValues().get(1);
                return typedResponse;
            }
        });
    }

    public List<LogUpdateStringEventResponse> getLogUpdateStringEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("LogUpdateString", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<LogUpdateStringEventResponse> responses = new ArrayList<LogUpdateStringEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            LogUpdateStringEventResponse typedResponse = new LogUpdateStringEventResponse();
            typedResponse.userAddress = (Address) eventValues.getIndexedValues().get(0);
            typedResponse.index = (Uint256) eventValues.getNonIndexedValues().get(0);
            typedResponse.data = (Utf8String) eventValues.getNonIndexedValues().get(1);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<LogUpdateStringEventResponse> logUpdateStringEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("LogUpdateString", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, LogUpdateStringEventResponse>() {
            @Override
            public LogUpdateStringEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                LogUpdateStringEventResponse typedResponse = new LogUpdateStringEventResponse();
                typedResponse.userAddress = (Address) eventValues.getIndexedValues().get(0);
                typedResponse.index = (Uint256) eventValues.getNonIndexedValues().get(0);
                typedResponse.data = (Utf8String) eventValues.getNonIndexedValues().get(1);
                return typedResponse;
            }
        });
    }

    public List<LogDeleteStringEventResponse> getLogDeleteStringEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("LogDeleteString", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<LogDeleteStringEventResponse> responses = new ArrayList<LogDeleteStringEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            LogDeleteStringEventResponse typedResponse = new LogDeleteStringEventResponse();
            typedResponse.userAddress = (Address) eventValues.getIndexedValues().get(0);
            typedResponse.index = (Uint256) eventValues.getNonIndexedValues().get(0);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<LogDeleteStringEventResponse> logDeleteStringEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("LogDeleteString", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, LogDeleteStringEventResponse>() {
            @Override
            public LogDeleteStringEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                LogDeleteStringEventResponse typedResponse = new LogDeleteStringEventResponse();
                typedResponse.userAddress = (Address) eventValues.getIndexedValues().get(0);
                typedResponse.index = (Uint256) eventValues.getNonIndexedValues().get(0);
                return typedResponse;
            }
        });
    }

    public List<NotifyAllEventResponse> getNotifyAllEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("notifyAll", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList());
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<NotifyAllEventResponse> responses = new ArrayList<NotifyAllEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            NotifyAllEventResponse typedResponse = new NotifyAllEventResponse();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<NotifyAllEventResponse> notifyAllEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("notifyAll", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList());
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, NotifyAllEventResponse>() {
            @Override
            public NotifyAllEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                NotifyAllEventResponse typedResponse = new NotifyAllEventResponse();
                return typedResponse;
            }
        });
    }

    public List<NotifyEventResponse> getNotifyEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("notify", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<NotifyEventResponse> responses = new ArrayList<NotifyEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            NotifyEventResponse typedResponse = new NotifyEventResponse();
            typedResponse.id = (Utf8String) eventValues.getNonIndexedValues().get(0);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<NotifyEventResponse> notifyEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("notify", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, NotifyEventResponse>() {
            @Override
            public NotifyEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                NotifyEventResponse typedResponse = new NotifyEventResponse();
                typedResponse.id = (Utf8String) eventValues.getNonIndexedValues().get(0);
                return typedResponse;
            }
        });
    }

    public List<OutOfBoundsEventResponse> getOutOfBoundsEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("outOfBounds", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<OutOfBoundsEventResponse> responses = new ArrayList<OutOfBoundsEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            OutOfBoundsEventResponse typedResponse = new OutOfBoundsEventResponse();
            typedResponse.userAddress = (Address) eventValues.getNonIndexedValues().get(0);
            typedResponse.value = (Uint256) eventValues.getNonIndexedValues().get(1);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<OutOfBoundsEventResponse> outOfBoundsEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("outOfBounds", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, OutOfBoundsEventResponse>() {
            @Override
            public OutOfBoundsEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                OutOfBoundsEventResponse typedResponse = new OutOfBoundsEventResponse();
                typedResponse.userAddress = (Address) eventValues.getNonIndexedValues().get(0);
                typedResponse.value = (Uint256) eventValues.getNonIndexedValues().get(1);
                return typedResponse;
            }
        });
    }

    public Future<Bool> getPermissionWrite(Address adr) {
        Function function = new Function("getPermissionWrite", 
                Arrays.<Type>asList(adr), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<TransactionReceipt> setString(Address userAddress, Utf8String data) {
        Function function = new Function("setString", Arrays.<Type>asList(userAddress, data), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<Bool> getPermissionRead(Address adr) {
        Function function = new Function("getPermissionRead", 
                Arrays.<Type>asList(adr), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<Utf8String> version() {
        Function function = new Function("version", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<Uint256> getHighValue() {
        Function function = new Function("getHighValue", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<Bool> contains(Address userAddress) {
        Function function = new Function("contains", 
                Arrays.<Type>asList(userAddress), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<TransactionReceipt> setPermissionRead(Address user, Bool perm) {
        Function function = new Function("setPermissionRead", Arrays.<Type>asList(user, perm), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<Address> getStringAtIndex(Uint256 index) {
        Function function = new Function("getStringAtIndex", 
                Arrays.<Type>asList(index), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<Utf8String> getString(Address userAddress) {
        Function function = new Function("getString", 
                Arrays.<Type>asList(userAddress), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<Uint256> getLowValue() {
        Function function = new Function("getLowValue", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<TransactionReceipt> setPermissionWrite(Address user, Bool perm) {
        Function function = new Function("setPermissionWrite", Arrays.<Type>asList(user, perm), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<Address> owner() {
        Function function = new Function("owner", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<Uint256> getCount() {
        Function function = new Function("getCount", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<TransactionReceipt> setRangeValues(Uint256 high, Uint256 low) {
        Function function = new Function("setRangeValues", Arrays.<Type>asList(high, low), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<Uint256> creationTime() {
        Function function = new Function("creationTime", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<TransactionReceipt> deleteString(Address userAddress) {
        Function function = new Function("deleteString", Arrays.<Type>asList(userAddress), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<Uint256> getBoundedValue(Uint256 value) {
        Function function = new Function("getBoundedValue", 
                Arrays.<Type>asList(value), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<Bool> isInRange(Uint256 value) {
        Function function = new Function("isInRange", 
                Arrays.<Type>asList(value), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<TransactionReceipt> updateString(Address userAddress, Utf8String userData) {
        Function function = new Function("updateString", Arrays.<Type>asList(userAddress, userData), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public static Future<RecordStorage> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue) {
        return deployAsync(RecordStorage.class, web3j, credentials, gasPrice, gasLimit, BINARY, "", initialWeiValue);
    }

    public static Future<RecordStorage> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue) {
        return deployAsync(RecordStorage.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "", initialWeiValue);
    }

    public static RecordStorage load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new RecordStorage(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static RecordStorage load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new RecordStorage(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static class LogNewStringEventResponse {
        public Address userAddress;

        public Uint256 index;

        public Utf8String data;
    }

    public static class LogUpdateStringEventResponse {
        public Address userAddress;

        public Uint256 index;

        public Utf8String data;
    }

    public static class LogDeleteStringEventResponse {
        public Address userAddress;

        public Uint256 index;
    }

    public static class NotifyAllEventResponse {
    }

    public static class NotifyEventResponse {
        public Utf8String id;
    }

    public static class OutOfBoundsEventResponse {
        public Address userAddress;

        public Uint256 value;
    }
}
