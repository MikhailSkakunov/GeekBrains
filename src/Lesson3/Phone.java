package Lesson3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Phone implements PhoneBook {

    static private Map<String, Set<String>> phoneSearch;

    public Phone() {
        phoneSearch = new HashMap<>();
    }
    @Override
    public void add(String nameСustomer, String phoneCustomer) {
        Set<String> phones = getPhones(nameСustomer);
        phones.add(phoneCustomer);
    }

    private Set<String> getPhones(String nameСustomer) {
        Set<String> phones = phoneSearch.getOrDefault(nameСustomer, new HashSet<>());
        if (phones.isEmpty()) {
            phoneSearch.put(nameСustomer, phones);
        }
        return phones;
    }

    @Override
    public Set<String> getAllPhoneCustomer() {
        return phoneSearch.keySet();
    }

    @Override
    public Set<String> get(String nameСustomer) {
        return getPhones(nameСustomer);
    }
}
