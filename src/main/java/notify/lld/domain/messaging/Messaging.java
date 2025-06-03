package notify.lld.domain.messaging;


public interface Messaging<T> {
    
    void initialize();

    void pushQueue(T message);

    boolean isEmpty();
}
