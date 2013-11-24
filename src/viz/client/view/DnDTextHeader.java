package viz.client.view;

import com.google.gwt.cell.client.Cell;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.user.cellview.client.Header;

public class DnDTextHeader extends Header<String> {

	private String text;

	/**
	 * Construct a new TextHeader.
	 * 
	 * @param text
	 *            the header text as a String
	 */
	public DnDTextHeader(String text) {
		super(new DnDTextCell());
		this.text = text;
	}

	/**
	 * Return the header text.
	 */
	@Override
	public String getValue() {
		return text;
	}
	
	@Override
	public void onBrowserEvent(Cell.Context context, Element elem, NativeEvent event) {	
		System.out.println(event.getType());
	}

}
