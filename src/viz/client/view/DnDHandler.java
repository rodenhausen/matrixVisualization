package viz.client.view;

import com.google.gwt.cell.client.Cell;
import com.google.gwt.cell.client.Cell.Context;
import com.google.gwt.dom.client.NativeEvent;

public interface DnDHandler {

	
	public void onDragStart(Context context, NativeEvent event);
	
	public void onDrop(Context context, NativeEvent event);
}
