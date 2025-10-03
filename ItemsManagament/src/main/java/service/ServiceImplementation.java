package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import model.Item;

public class ServiceImplementation implements Service {
	private DataSource ds;
	
	public ServiceImplementation(DataSource datasource) {
		this.ds = datasource;
	}

	@Override
	public boolean addItem(Item item) {
		try {
			Connection connection = ds.getConnection();
			String sql = "INSERT INTO Items (name, price, quantity, details) VALUES (?, ?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(sql);

			ps.setString(1, item.getName());
			ps.setInt(2, item.getPrice());
			ps.setInt(3, item.getQuantity());
			ps.setString(4, item.getDetail());

			int rowsInserted = ps.executeUpdate();

			// to check if item added successfully
			if (rowsInserted > 0) 
				return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public Item updateItem(Item item) {
		
	    try (Connection conn = ds.getConnection()) {

	    	String sql = "UPDATE items SET price = ?, quantity = ?, details = ?, name = ? WHERE id = ?";
	    	PreparedStatement ps = conn.prepareStatement(sql);
	    	
	    	System.out.println("SQL: UPDATE items SET price=" + item.getPrice() +
	                   ", quantity=" + item.getQuantity() +
	                   ", details='" + item.getDetail() + "'" +
	                   ", name='" + item.getName() + "'" +
	                   " WHERE id=" + item.getId());




	    	// Set in correct order
	    	ps.setInt(1, item.getPrice());      // price = ?
	    	ps.setInt(2, item.getQuantity());   // quantity = ?
	    	ps.setString(3, item.getDetail());  // detail = ?
	    	ps.setString(4, item.getName());    // name = ?
	    	ps.setLong(5, item.getId());        // id = ?


	        int rowsUpdated = ps.executeUpdate();
	    	System.out.println("Rows updated = " + rowsUpdated);
	        if (rowsUpdated > 0) {
	            System.out.println("Item updated successfully!");
	        }

	    } catch (SQLException s) {
	        s.printStackTrace();
	    }
	    return item;
	}

	@Override
	public boolean showCertainItem(DataSource ds) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Item> showAllItems() {
		this.ds = ds;
		List<Item> items = new ArrayList<Item>();
		
		try {
			Connection conn = ds.getConnection();
			String sql = "SELECT * FROM ITEMS ORDER BY ID";
			PreparedStatement ps = conn.prepareStatement(sql);
			 try (ResultSet rs = ps.executeQuery()) {
				 while(rs.next()) {
					 Long id = Long.parseLong(rs.getString(1));
					 Integer price = Integer.parseInt(rs.getString(2));
					 Integer quantity = Integer.parseInt(rs.getString(3));
					 String detail = rs.getString(4);
					 String name = rs.getString(5);
					 
					 
					 Item item = new Item();
					 item.setDetail(detail); item.setId(id); item.setName(name);item.setPrice(price);item.setQuantity(quantity);
					 
					 items.add(item);
					 
				 }
			 }
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return items;

	}
	
// no time :( for this function 👇👇👇👇👇	
//	@Override
//	public boolean showAllusers(DataSource ds) {
//		// TODO Auto-generated method stub
//		return false;
//	}

	@Override
	public boolean removeItem(long id) {
		
		try {
			Connection connection = ds.getConnection();
			String query = "DELETE FROM ITEMS where id = " + id;
			
			Statement statement = connection.createStatement();
			statement.executeQuery(query); 
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return false;
	}
	
	
	
	public Item getItemById(Long id) {
	    Item item = null;

	    try (Connection conn = ds.getConnection();
	         PreparedStatement ps = conn.prepareStatement("SELECT * FROM ITEMS WHERE ID = ?")) {
	        
	        ps.setLong(1, id);
	        
	        try (ResultSet rs = ps.executeQuery()) {
	            if (rs.next()) {
	                item = new Item();
	                item.setId(rs.getLong("id"));
	                item.setPrice(rs.getInt("price"));
	                item.setQuantity(rs.getInt("quantity"));
	                item.setDetail(rs.getString("details"));
	                item.setName(rs.getString("name"));
	            }
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return item;
	}

	
}

