package contract;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple4;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.5.5.
 */
@SuppressWarnings("rawtypes")
public class Provenance_sol_Provenance extends Contract {
    private static final String BINARY = "60c060405260016080908152600260a081905261001e916000916100e1565b50604080516080810182527f198e9393920d483a7260bfb731fb5d25f1aa493335a9e71297e485b7aef312c281527f1800deef121f1e76426a00665e5c4479674322d4f75edadd46debd5cd992f6ed60208201527f090689d0585ff075ec9e99ad690c3395bc4b313370b38ef355acdadcd122975b918101919091527f12c85ea5db8c6deb4aab71808dcb408fe3d1e7690c43d37b4ce6cc0166fa7daa60608201526100ce906002906004610124565b503480156100db57600080fd5b5061016f565b8260028101928215610114579160200282015b82811115610114578251829060ff169055916020019190600101906100f4565b50610120929150610152565b5090565b8260048101928215610114579160200282015b82811115610114578251825591602001919060010190610137565b61016c91905b808211156101205760008155600101610158565b90565b610ab48061017e6000396000f3fe60806040526004361061006c5763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416630118fa498114610071578063157557381461012d578063335932fc14610216578063ac41c7d514610252578063c71a7943146102f1575b600080fd5b34801561007d57600080fd5b5061012b6004803603604081101561009457600080fd5b813591908101906040810160208201356401000000008111156100b657600080fd5b8201836020820111156100c857600080fd5b803590602001918460018302840111640100000000831117156100ea57600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295506103cb945050505050565b005b34801561013957600080fd5b5061015d6004803603604081101561015057600080fd5b5080359060200135610495565b604051808581526020018481526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200180602001828103825283818151815260200191508051906020019080838360005b838110156101d85781810151838201526020016101c0565b50505050905090810190601f1680156102055780820380516001836020036101000a031916815260200191505b509550505050505060405180910390f35b34801561022257600080fd5b506102406004803603602081101561023957600080fd5b5035610567565b60408051918252519081900360200190f35b34801561025e57600080fd5b5061027c6004803603602081101561027557600080fd5b5035610579565b6040805160208082528351818301528351919283929083019185019080838360005b838110156102b657818101518382015260200161029e565b50505050905090810190601f1680156102e35780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b3480156102fd57600080fd5b5061012b600480360361018081101561031557600080fd5b604080518082018252918301929181830191839060029083908390808284376000920191909152505060408051608081810190925292959493818101939250906004908390839080828437600092019190915250506040805180820182529295949381810193925090600290839083908082843760009201919091525050604080516080818101909252929594938181019392509060049083908390808284376000920191909152509194506106cd9350505050565b6103d361098f565b506040805160808101825283815260008481526007602090815283822054818401818152338587019081526060860188815289865260068552878620938652928452959093208451815592516001840155935160028301805473ffffffffffffffffffffffffffffffffffffffff191673ffffffffffffffffffffffffffffffffffffffff909216919091179055925180519293849361047992600385019201906109ce565b5050506000928352505060076020526040902080546001019055565b6006602090815260009283526040808420825291835291819020805460018083015460028085015460038601805488516101009682161596909602600019011692909204601f81018990048902850189019097528684529396919573ffffffffffffffffffffffffffffffffffffffff9094169493909183018282801561055d5780601f106105325761010080835404028352916020019161055d565b820191906000526020600020905b81548152906001019060200180831161054057829003601f168201915b5050505050905084565b60076020526000908152604090205481565b6000818152600660209081526040808320600783528184205460001990810185529083529281902060030180548251600260018316156101000290960190911694909404601f8101849004840285018401909252818452606093929091908301828280156106285780601f106105fd57610100808354040283529160200191610628565b820191906000526020600020905b81548152906001019060200180831161060b57829003601f168201915b505050505090507f613d9cd2bbf3e47bb693c60a9c4c7c21be4584814d8889e845f53b8874d7a8a6816040518080602001828103825283818151815260200191508051906020019080838360005b8381101561068e578181015183820152602001610676565b50505050905090810190601f1680156106bb5780820380516001836020036101000a031916815260200191505b509250505060405180910390a1919050565b6106d9848484846107aa565b1561074357604080516020808252600f908201527f76657269667920737563636565642100000000000000000000000000000000008183015290517fa396f8d98c67c164560cb969bf42c7fd20318f6a13d8a83e7a589a61fb1214b69181900360600190a16107a4565b604080516020808252600e908201527f766572696679206661696c6564210000000000000000000000000000000000008183015290517fa396f8d98c67c164560cb969bf42c7fd20318f6a13d8a83e7a589a61fb1214b69181900360600190a15b50505050565b60408051600c8082526101a08201909252600091906060908260208201610180803883395050885182519293509183915060009081106107e657fe5b60209081029091010152866001602002015181600181518110151561080757fe5b6020908102919091010152855181518290600290811061082357fe5b60209081029091010152856001602002015181600381518110151561084457fe5b6020908102919091010152604086015181518290600490811061086357fe5b6020908102919091010152606086015181518290600590811061088257fe5b6020908102919091010152845181518290600690811061089e57fe5b6020908102909101015284600160200201518160078151811015156108bf57fe5b602090810291909101015283518151829060089081106108db57fe5b6020908102909101015283600160200201518160098151811015156108fc57fe5b6020908102919091010152604084015181518290600a90811061091b57fe5b6020908102919091010152606084015181518290600b90811061093a57fe5b6020908102909101015261094c610a4c565b60006020826020860260208601600060086107d05a03f1905080801561097157610973565bfe5b5080151561098057600080fd5b50511515979650505050505050565b6080604051908101604052806000815260200160008152602001600073ffffffffffffffffffffffffffffffffffffffff168152602001606081525090565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10610a0f57805160ff1916838001178555610a3c565b82800160010185558215610a3c579182015b82811115610a3c578251825591602001919060010190610a21565b50610a48929150610a6b565b5090565b6020604051908101604052806001906020820280388339509192915050565b610a8591905b80821115610a485760008155600101610a71565b9056fea165627a7a723058204cbd343c36ad0ffd897307aa3026766b609be82975951f2835880e50a3e2b10c0029";

    public static final String FUNC_CREATE = "create";

    public static final String FUNC_PROVES = "proves";

    public static final String FUNC_INDEX = "index";

    public static final String FUNC_GETPROV = "getProv";

    public static final String FUNC_VERIFY = "verify";

    public static final Event NOTIFY_EVENT = new Event("notify", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
    ;

    public static final Event CONTENT_EVENT = new Event("Content", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
    ;

    @Deprecated
    protected Provenance_sol_Provenance(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Provenance_sol_Provenance(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Provenance_sol_Provenance(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Provenance_sol_Provenance(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> create(BigInteger _idP, String _content) {
        final Function function = new Function(
                FUNC_CREATE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_idP), 
                new org.web3j.abi.datatypes.Utf8String(_content)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Tuple4<BigInteger, BigInteger, String, String>> proves(BigInteger param0, BigInteger param1) {
        final Function function = new Function(FUNC_PROVES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0), 
                new org.web3j.abi.datatypes.generated.Uint256(param1)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}));
        return new RemoteFunctionCall<Tuple4<BigInteger, BigInteger, String, String>>(function,
                new Callable<Tuple4<BigInteger, BigInteger, String, String>>() {
                    @Override
                    public Tuple4<BigInteger, BigInteger, String, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple4<BigInteger, BigInteger, String, String>(
                                (BigInteger) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (String) results.get(3).getValue());
                    }
                });
    }

    public RemoteFunctionCall<BigInteger> index(BigInteger param0) {
        final Function function = new Function(FUNC_INDEX, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> getProv(BigInteger _idP) {
        final Function function = new Function(
                FUNC_GETPROV, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_idP)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> verify(List<BigInteger> params1, List<BigInteger> params2, List<BigInteger> params3, List<BigInteger> params4) {
        final Function function = new Function(
                FUNC_VERIFY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.StaticArray2<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.datatypes.generated.Uint256.class,
                        org.web3j.abi.Utils.typeMap(params1, org.web3j.abi.datatypes.generated.Uint256.class)), 
                new org.web3j.abi.datatypes.generated.StaticArray4<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.datatypes.generated.Uint256.class,
                        org.web3j.abi.Utils.typeMap(params2, org.web3j.abi.datatypes.generated.Uint256.class)), 
                new org.web3j.abi.datatypes.generated.StaticArray2<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.datatypes.generated.Uint256.class,
                        org.web3j.abi.Utils.typeMap(params3, org.web3j.abi.datatypes.generated.Uint256.class)), 
                new org.web3j.abi.datatypes.generated.StaticArray4<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.datatypes.generated.Uint256.class,
                        org.web3j.abi.Utils.typeMap(params4, org.web3j.abi.datatypes.generated.Uint256.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public List<NotifyEventResponse> getNotifyEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(NOTIFY_EVENT, transactionReceipt);
        ArrayList<NotifyEventResponse> responses = new ArrayList<NotifyEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            NotifyEventResponse typedResponse = new NotifyEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.note = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<NotifyEventResponse> notifyEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, NotifyEventResponse>() {
            @Override
            public NotifyEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(NOTIFY_EVENT, log);
                NotifyEventResponse typedResponse = new NotifyEventResponse();
                typedResponse.log = log;
                typedResponse.note = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<NotifyEventResponse> notifyEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(NOTIFY_EVENT));
        return notifyEventFlowable(filter);
    }

    public List<ContentEventResponse> getContentEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(CONTENT_EVENT, transactionReceipt);
        ArrayList<ContentEventResponse> responses = new ArrayList<ContentEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ContentEventResponse typedResponse = new ContentEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._content = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ContentEventResponse> contentEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, ContentEventResponse>() {
            @Override
            public ContentEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(CONTENT_EVENT, log);
                ContentEventResponse typedResponse = new ContentEventResponse();
                typedResponse.log = log;
                typedResponse._content = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ContentEventResponse> contentEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(CONTENT_EVENT));
        return contentEventFlowable(filter);
    }

    @Deprecated
    public static Provenance_sol_Provenance load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Provenance_sol_Provenance(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Provenance_sol_Provenance load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Provenance_sol_Provenance(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Provenance_sol_Provenance load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Provenance_sol_Provenance(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Provenance_sol_Provenance load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Provenance_sol_Provenance(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Provenance_sol_Provenance> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Provenance_sol_Provenance.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Provenance_sol_Provenance> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Provenance_sol_Provenance.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Provenance_sol_Provenance> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Provenance_sol_Provenance.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Provenance_sol_Provenance> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Provenance_sol_Provenance.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class NotifyEventResponse extends BaseEventResponse {
        public String note;
    }

    public static class ContentEventResponse extends BaseEventResponse {
        public String _content;
    }
}
