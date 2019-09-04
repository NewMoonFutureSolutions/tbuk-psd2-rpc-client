package tbuk.psd2.grpc.client;

import com.tbuk.grpc.psd2.Linking;
import io.grpc.ManagedChannel;
import io.grpc.StatusRuntimeException;
import io.grpc.netty.GrpcSslContexts;
import io.grpc.netty.NettyChannelBuilder;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;

import javax.net.ssl.SSLException;
import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LinkingClientTls {
    private static final Logger logger = Logger.getLogger(LinkingClientTls.class.getName());

    private final ManagedChannel channel;
    private final com.tbuk.grpc.psd2.AccountLinkingServiceGrpc.AccountLinkingServiceBlockingStub blockingStub;

    // SSL Context

    /**
     *
     * @param trustCertCollectionFilePath : bu CA oluyor (yani public key) Java truststore'a eklenmeli bu sekilde : keytool -import -alias teiid -file publicX09SandboxTBUK.pem -storetype JKS -keystore server.truststore
     * @param clientCertChainFilePath : bu public key
     * @param clientPrivateKeyFilePath : bu private key
     * @return
     * @throws SSLException
     */
    private static SslContext buildSslContext(String trustCertCollectionFilePath,
                                              String clientCertChainFilePath,
                                              String clientPrivateKeyFilePath) throws SSLException {
        SslContextBuilder builder = GrpcSslContexts.forClient();
        builder.trustManager(new File(trustCertCollectionFilePath));
        builder.keyManager(new File(clientCertChainFilePath), new File(clientPrivateKeyFilePath));

        return builder.build();
    }


    public LinkingClientTls(String host,
                            int port,
                            SslContext sslContext) throws SSLException {

        this(NettyChannelBuilder.forAddress(host, port)
                .overrideAuthority("openbanking.turkishbank.co.uk")  /* Only for using provided test certs. */
                .sslContext(sslContext)
                .build());
    }

    /**
     * Burasi her client icin degisecek
     */
    LinkingClientTls(ManagedChannel channel) {
        this.channel = channel;
        blockingStub = com.tbuk.grpc.psd2.AccountLinkingServiceGrpc.newBlockingStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    /**
     * Method
     */
    public void linkAccount(String accessToken) {
        Linking.GetBankAuthorizationRequest request = Linking.GetBankAuthorizationRequest .newBuilder().setAccessToken(accessToken).build();
        Linking.BankAuthorization response;
        try {
            response = blockingStub.getBankAuthorization(request);
        } catch (StatusRuntimeException e) {
            logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
            return;
        }
        logger.info("Gelen cevap: " + response.getBankId());
    }


    public static void main(String[] args) throws Exception {
        LinkingClientTls client=new LinkingClientTls(CONSTANTS.host,
                CONSTANTS.port,
                buildSslContext(CONSTANTS.trustCertCollectionFilePath,
                        CONSTANTS.certChainFilePath,
                        CONSTANTS.privateKeyFilePath)
        );


        try {
            client.linkAccount("Bearer Token buraya");
        } finally {
            client.shutdown();
        }
    }
}
