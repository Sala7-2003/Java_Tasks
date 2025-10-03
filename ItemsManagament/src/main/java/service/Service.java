package service;

import javax.sql.DataSource;

import model.Item;
import java.util.List;

public interface Service {
	
	public boolean addItem(Item item);
	public boolean showCertainItem(DataSource ds);
	public List<Item> showAllItems();
//	public boolean showAllusers(DataSource ds);
	public boolean removeItem(long id);
	public Item updateItem(Item item);
	public Item getItemById(Long id);

}
