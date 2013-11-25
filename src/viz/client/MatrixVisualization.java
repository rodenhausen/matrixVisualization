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
		characterNames.add("c1");
		characterNames.add("c2");
		characterNames.add("c3");
		characterNames.add("c4");
		characterNames.add("c5");
		characterNames.add("c6");
		/*characterNames.add("cn8");
		characterNames.add("cn9");
		characterNames.add("cn10");
		characterNames.add("cn11");
		characterNames.add("cn12");
		characterNames.add("cn13");
		characterNames.add("cn14");
		characterNames.add("cn15");
		characterNames.add("cn16");
		characterNames.add("cn17");
		characterNames.add("cn18");*/
		
		
		List<Taxon> taxons = new LinkedList<Taxon>();
		Taxon taxon = new Taxon();
		taxon.setId("1");
		taxon.setName("My Taxon");
		taxon.setCharacterState("c1", "characterStatecharacterStatecharacterState");
		taxon.setCharacterState("c2", "characterStatecharacterStatecharacterState");
		taxon.setCharacterState("c3", "characterStatecharacterStatecharacterState");
		taxon.setCharacterState("c4", "characterStatecharacterStatecharacterState");
		taxon.setCharacterState("c5", "characterStatecharacterStatecharacterState");
		taxon.setCharacterState("c6", "characterStatecharacterStatecharacterState");
		/*taxon.setCharacterState("cn8", "characterStatecharacterStatecharacterState");
		taxon.setCharacterState("cn9", "characterStatecharacterStatecharacterState");
		taxon.setCharacterState("cn10", "characterStatecharacterStatecharacterState");
		taxon.setCharacterState("cn11", "characterStatecharacterStatecharacterState");
		taxon.setCharacterState("cn12", "characterStatecharacterStatecharacterState");
		taxon.setCharacterState("cn13", "characterStatecharacterStatecharacterState");
		taxon.setCharacterState("cn14", "characterStatecharacterStatecharacterState");
		taxon.setCharacterState("cn15", "characterStatecharacterStatecharacterState");
		taxon.setCharacterState("cn16", "characterStatecharacterStatecharacterState");
		taxon.setCharacterState("cn17", "characterStatecharacterStatecharacterState");
		taxon.setCharacterState("cn18", "characterStatecharacterStatecharacterState");*/
		taxon.setCharacterState("characterName", "characterState");
		taxons.add(taxon);
		presenter.setData(characterNames, taxons);
		
		Taxon taxon2 = new Taxon();
		taxon2.setId("2");
		taxon2.setName("my 2nd");
		taxon2.setCharacterState("c3", "what");
		taxon2.setCharacterState("c5", "aa");
		taxons.add(taxon2);
		
		RootLayoutPanel.get().add(view);
		//RootPanel.get().add(view);
		
		characterNames.add("cn3");
		taxon.setCharacterState("cn3", "v3");
		presenter.setData(characterNames, taxons);
		
		
		
	}
}
