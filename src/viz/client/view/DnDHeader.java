package viz.client.view;

import com.google.gwt.user.cellview.client.Header;

public class DnDHeader extends Header<String> {

	private String text;

	/**
	 * Construct a new TextHeader.
	 * @param characterName 
	 * 
	 * @param text
	 *            the header text as a String
	 */
	public DnDHeader(String text, DnDHeaderCell cell) {
		super(cell);
		this.text = text;
	}

	@Override
	public String getValue() {
		return text;
	}

}
