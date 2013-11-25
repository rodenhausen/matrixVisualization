package viz.client.view;

import com.google.gwt.dom.client.NativeEvent;

public class UnusedCharactersClickHandler implements ClickHandler {

	private ViewImpl viewImpl;

	public UnusedCharactersClickHandler(ViewImpl viewImpl) {
		this.viewImpl = viewImpl;
	}
	
	public void onClick(com.google.gwt.cell.client.Cell.Context context, NativeEvent event) {
		viewImpl.orderCharactersForTaxon(context.getIndex());
	}

	public void onDoubleClick(com.google.gwt.cell.client.Cell.Context context, NativeEvent event) {
		
	}

	public void onContext(com.google.gwt.cell.client.Cell.Context context, NativeEvent event) {
		
	}

}
