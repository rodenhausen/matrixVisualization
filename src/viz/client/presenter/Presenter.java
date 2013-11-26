package viz.client.presenter;

import java.util.List;

import viz.client.view.IView;
import viz.shared.model.Taxon;

public class Presenter implements IView.Presenter {

	private IView view;

	public Presenter(IView view) {
		this.view = view;
		view.setPresenter(this);
	}
	
	public void setData(List<String> characterNames, List<Taxon> taxons) {
		view.setCharacterNames(characterNames);
		view.setTaxons(taxons);
	}
	
	public void onSave() {
		
	}
}
