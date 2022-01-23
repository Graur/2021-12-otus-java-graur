package homework;

import java.util.Comparator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class CustomerService {

    //todo: 3. надо реализовать методы этого класса
    //важно подобрать подходящую Map-у, посмотрите на редко используемые методы, они тут полезны
    private final NavigableMap<Customer, String> map;

    public CustomerService() {
        this.map = new TreeMap<>(Comparator.comparing(Customer::getScores));
    }

    public Map.Entry<Customer, String> getSmallest() {
        //Возможно, чтобы реализовать этот метод, потребуется посмотреть как Map.Entry сделан в jdk
        var entry = map.firstEntry();
        return Map.entry(new Customer(entry.getKey()), entry.getValue());
    }

    public Map.Entry<Customer, String> getNext(Customer customer) {
        var entry = map.higherEntry(customer);
        return entry != null
                ? Map.entry(new Customer(entry.getKey()), entry.getValue())
                : null;
    }

    public void add(Customer customer, String data) {
        this.map.put(customer, data);
    }
}
