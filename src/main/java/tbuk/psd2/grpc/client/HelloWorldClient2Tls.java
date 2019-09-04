package tbuk.psd2.grpc.client;

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


public class HelloWorldClient2Tls {
    private static final Logger logger = Logger.getLogger(HelloWorldClient2Tls.class.getName());

    private final ManagedChannel channel;
    private final tbuk.psd2.grpc.rest.HelloWorldServiceGrpc.HelloWorldServiceBlockingStub blockingStub;

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


    public HelloWorldClient2Tls(String host,
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
    HelloWorldClient2Tls(ManagedChannel channel) {
        this.channel = channel;
        blockingStub = tbuk.psd2.grpc.rest.HelloWorldServiceGrpc.newBlockingStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    /**
     * Method
     */
    public void greet(String name) {
        tbuk.psd2.grpc.rest.HelloWorld.Person request = tbuk.psd2.grpc.rest.HelloWorld.Person.newBuilder().setFirstName("Bora").setLastName("Uzun").build();
        tbuk.psd2.grpc.rest.HelloWorld.Greeting response;
        try {
            response = blockingStub.sayHello(request);
        } catch (StatusRuntimeException e) {
            logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
            return;
        }
        logger.info("Gelen cevap: " + response.getMessage());
    }


    public static void main(String[] args) throws Exception {
        HelloWorldClient2Tls client=new HelloWorldClient2Tls(CONSTANTS.host,
                                                           CONSTANTS.port,
                buildSslContext(CONSTANTS.trustCertCollectionFilePath,
                        CONSTANTS.certChainFilePath,
                        CONSTANTS.privateKeyFilePath)
        );


        try {
            client.greet("Bora");
        } finally {
            client.shutdown();
        }
    }
}
