package viz.client.view;

import java.util.HashSet;
import java.util.Set;

import com.google.gwt.cell.client.Cell;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.cell.client.ValueUpdater;
import com.google.gwt.dom.client.BrowserEvents;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;

public class DnDTextCell extends TextCell {

	@Override
	public Set<String> getConsumedEvents() {
		Set<String> result = new HashSet<String>();
		result.add(BrowserEvents.CLICK);
		result.add(BrowserEvents.DBLCLICK);
		result.add(BrowserEvents.CONTEXTMENU);
		result.add(BrowserEvents.DRAG);
		result.add(BrowserEvents.DRAGEND);
		result.add(BrowserEvents.DRAGENTER);
		result.add(BrowserEvents.DRAGLEAVE);
		result.add(BrowserEvents.DRAGOVER);
		result.add(BrowserEvents.DRAGSTART);
		result.add(BrowserEvents.DROP);
		return result;
	}
	
	@Override
	public void	onBrowserEvent(Cell.Context context, 
			Element parent, String value, NativeEvent event, 
			ValueUpdater<String> valueUpdater) {
		System.out.println(event.getType());
	}
}
