package beans;

public class CategoryWorkerBean {
	private ItemBean[] items;
	
	public CategoryWorkerBean() {
	}
	
	public CategoryWorkerBean(String query) {
		// TODO: pass the query to the database, get the results
    
		// TODO: assign the results to items (array of ItemBeans)
		
	}

	public ItemBean[] getItems() {
		return items;
	}

	public void setItems(ItemBean[] items) {
		this.items = items;
	}
	
		
}
