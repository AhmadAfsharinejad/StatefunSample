package org.example;


import org.apache.flink.statefun.flink.harness.Harness;
import org.apache.flink.statefun.flink.harness.io.SerializableSupplier;
import org.apache.flink.util.StringUtils;
import org.example.generated.People;
import org.junit.Ignore;
import org.junit.Test;

import java.util.concurrent.ThreadLocalRandom;

public class RunnerTest {

    @Ignore("This has an infinite egress and it would never complete, only use in the IDE")
    @Test
    public void run() throws Exception {

        Harness harness = new Harness();
        harness.withConfiguration(
                "classloader.parent-first-patterns.additional",
                "org.apache.flink.statefun;org.apache.kafka;com.google.protobuf");
        harness.withKryoMessageSerializer();
        harness.withSupplyingIngress(FlinkConstants.MESSAGE_INGRESS, new InputGenerator());
        harness.withPrintingEgress(FlinkConstants.MESSAGE_EGRESS);
        harness.start();
    }

    private static final class InputGenerator implements SerializableSupplier<People> {

        static int counter;

        @Override
        public People get() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException("Interrupted", e);
            }
            return getRandomMessage();
        }

        private People getRandomMessage() {
            final ThreadLocalRandom r = ThreadLocalRandom.current();
            final String name = StringUtils.generateRandomAlphanumericString(r, 4);
            final int age = r.nextInt(1, 100);
            return People.newBuilder().setId(counter++ + "").setName(name).setAge(age).build();
        }
    }
}
