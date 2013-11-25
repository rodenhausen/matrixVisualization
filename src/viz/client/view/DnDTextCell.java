package viz.client.view;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.google.gwt.cell.client.AbstractSafeHtmlCell;
import com.google.gwt.cell.client.Cell;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.cell.client.ValueUpdater;
import com.google.gwt.cell.client.Cell.Context;
import com.google.gwt.dom.client.BrowserEvents;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.text.shared.SafeHtmlRenderer;
import com.google.gwt.text.shared.SimpleSafeHtmlRenderer;

public class DnDTextCell extends TextCell {

	private Set<String> consumedEvents;
	
	public DnDTextCell() {
		super();
		consumedEvents = new HashSet<String>();
		consumedEvents.add(BrowserEvents.CLICK);
		consumedEvents.add(BrowserEvents.DBLCLICK);
		consumedEvents.add(BrowserEvents.CONTEXTMENU);
		consumedEvents.add(BrowserEvents.DRAG);
		consumedEvents.add(BrowserEvents.DRAGEND);
		consumedEvents.add(BrowserEvents.DRAGENTER);
		consumedEvents.add(BrowserEvents.DRAGLEAVE);
		consumedEvents.add(BrowserEvents.DRAGOVER);
		consumedEvents.add(BrowserEvents.DRAGSTART);
		consumedEvents.add(BrowserEvents.DROP);
		consumedEvents = Collections.unmodifiableSet(consumedEvents);
	}

	@Override
	public Set<String> getConsumedEvents() {
		return this.consumedEvents;
	}
	
	@Override
	public void	onBrowserEvent(Cell.Context context, 
			Element parent, String value, NativeEvent event, 
			ValueUpdater<String> valueUpdater) {
		System.out.println(event.getType());
	}
}
