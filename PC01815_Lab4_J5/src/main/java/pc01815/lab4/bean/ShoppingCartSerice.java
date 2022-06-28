package pc01815.lab4.bean;

import java.util.Collection;

public interface ShoppingCartSerice {
     Item add(Integer item);
     void remove(Integer id);
     Item update(Integer id,int qty);
     void clear();
     Collection<Item> getItems();
     int getCount();
     double getAmount();
}
