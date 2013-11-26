package viz.client.view;

import java.util.List;

import viz.shared.model.Taxon;


public interface IView {

	public interface Presenter {
		void onSave();
	}

	void setPresenter(Presenter presenter);
	void setTaxons(List<Taxon> taxons);
	void updateTaxon(Taxon taxon);
	void removeTaxon(Taxon taxon);
	void addTaxon(Taxon taxon);
	Taxon getSelectedTaxon();
	void resetSelection();
	void setCharacterNames(List<String> characterNames);

}
