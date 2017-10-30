package com;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.examples.helloworld.GreeterGrpc;
import io.grpc.examples.helloworld.HelloReply;
import io.grpc.examples.helloworld.HelloRequest;
import io.grpc.stub.StreamObserver;

import java.io.IOException;

/**
 * Created by WIN on 2017/10/26.
 */
public class HelloWorldServer {

    private int port = 50051;
    private Server server;

    private void start() throws IOException {
        server = ServerBuilder.forPort(port)
                .addService(new GreeterImpl())
                .build()
                .start();
        System.out.println("server start....");

        Runtime.getRuntime().addShutdownHook(new Thread(){

            @Override
            public void run() {
                System.err.println("####shutdown grpc server since jvm is shutting down####");
                HelloWorldServer.this.stop();
            }
        });
    }

    /**
     * stop server
     */
    private void stop() {
        if(null != server) {
            server.shutdown();
        }
    }

    private void blockUnitShutdown() throws InterruptedException {
        if(null != server) {
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws Exception {
        final HelloWorldServer server = new HelloWorldServer();
        server.start();
        server.blockUnitShutdown();
    }


    /**
     * 实现服务接口的类
     */
    private class GreeterImpl extends GreeterGrpc.GreeterImplBase {
        public void sayHello(HelloRequest req, StreamObserver<HelloReply> responseObserver) {
            System.out.println("from client data: "+req.getName());
            HelloReply reply = HelloReply.newBuilder().setMessage(("Hello  " + req.getName())).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }
    }
}
