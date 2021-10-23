package com.example.saga.manager;

import com.example.saga.command.CompensateTestEntityCommand;
import com.example.saga.command.CreateOrderCommand;
import com.example.saga.events.OrderCompensatedEvent;
import com.example.saga.events.OrderCreatedEvent;
import com.example.saga.events.TestEntityCreatedEvent;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.saga.EndSaga;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.SagaLifecycle;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;


@Saga
public class TestManagementSaga   {
    @Autowired
    private transient CommandGateway commandGateway;

    @StartSaga
    @SagaEventHandler(associationProperty = "id")
    public void handle(TestEntityCreatedEvent testEntityCreatedEvent){

        String orderId = UUID.randomUUID().toString();
        System.out.println("Saga invoked");

        //associate Saga
        SagaLifecycle.associateWith("orderId", orderId);
        commandGateway.send(new CreateOrderCommand(orderId,"Sagadan order create", testEntityCreatedEvent.id))
                .exceptionally(throwable -> {
                   return  commandGateway.send(new CompensateTestEntityCommand(testEntityCreatedEvent.id,2)); })
        ;

        System.out.println("test id" + testEntityCreatedEvent.id);

    }

    //Saga ikinci adım
    @SagaEventHandler(associationProperty = "orderId")
    public void handle(OrderCreatedEvent orderCreatedEvent){


        System.out.println("Saga continued");
    //TODO başarı durumuna göre endSaga buradada çağıralabilir
        //Örnek OrderComplete diye bir event gelip endsaga yapılır veya ordercompensate eventi ile aşağıdaki gibi rollback adımları
        //tetiklenebilir

    }
    //Saga rollback örnek
    @SagaEventHandler(associationProperty = "orderId")
    public void on(OrderCompensatedEvent event) {

        System.out.println("order canceled");

        commandGateway.send(new CompensateTestEntityCommand(event.testId,2));

        endSaga();
    }

    @EndSaga
    private void endSaga() {
        System.out.println("ENDING SAGA");
    }
}
