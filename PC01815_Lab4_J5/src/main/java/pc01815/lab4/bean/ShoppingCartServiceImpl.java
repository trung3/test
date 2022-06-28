package pc01815.lab4.bean;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
public class ShoppingCartServiceImpl implements ShoppingCartSerice {
    Map<Integer,Item> map = new HashMap<>();
    @Override
    public Item add(Integer id) {
    	Item item = map.get(id);
    	if(item == null) {
    		item = DB.items.get(id);
    		item.setQty(1);
    		map.put(id, item);
    	}else {
    		item.setQty(item.getQty()+1);
    	}
    	return item;
    }
    @Override
public void remove(Integer id) {
    	map.remove(id);
    }
    @Override
public Item update(Integer id,int qty) {
	Item item = map.get(id);
	item.setQty(qty);
	
	return item;
}
    @Override
public void clear() {
    	map.clear();
    	
    }
    @Override
    public Collection<Item> getItems() {
       
    return map.values();
    }
    @Override
    public int getCount() {
    
    return map.values().stream()
    		.mapToInt(item -> item.getQty())
    		.sum();
    }
    @Override
    public double getAmount() {
    	return map.values().stream()
        		.mapToDouble(item ->item.getPrice()*item.getQty())
        		.sum();
    }
}
