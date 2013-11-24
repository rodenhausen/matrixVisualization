package viz.client;

import java.util.LinkedList;
import java.util.List;

import viz.client.presenter.Presenter;
import viz.client.view.ViewImpl;
import viz.shared.model.Taxon;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class MatrixVisualization implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		ViewImpl view = new ViewImpl();
		Presenter presenter = new Presenter(view);
		List<String> characterNames = new LinkedList<String>();
		characterNames.add("characterName");
		characterNames.add("cn2");
		List<Taxon> taxons = new LinkedList<Taxon>();
		Taxon taxon = new Taxon();
		taxon.setCharacterState("cn2", "value");
		taxon.setCharacterState("characterName", "characterState");
		taxons.add(taxon);
		presenter.setData(characterNames, taxons);
		
		RootLayoutPanel.get().add(view);
		//RootPanel.get().add(view);
		
		characterNames.add("cn3");
		taxon.setCharacterState("cn3", "v3");
		presenter.setData(characterNames, taxons);
		
	}
}
