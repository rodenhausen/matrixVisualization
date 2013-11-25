package viz.client.view;

import java.util.List;

import com.google.gwt.cell.client.CompositeCell;
import com.google.gwt.cell.client.HasCell;

public class DnDHeaderCell extends CompositeCell<String> {
	
	public DnDHeaderCell(List<HasCell<String, ?>> hasCells) {
		super(hasCells);
	}
	
}
