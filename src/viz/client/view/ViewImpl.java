package viz.client.view;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import viz.shared.model.Taxon;

import com.google.gwt.cell.client.EditTextCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.ColumnSortEvent.ListHandler;
import com.google.gwt.user.cellview.client.Header;
import com.google.gwt.user.cellview.client.SimplePager.TextLocation;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.ProvidesKey;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SelectionChangeEvent.Handler;
import com.google.gwt.view.client.SelectionModel;
import com.google.gwt.view.client.SingleSelectionModel;


public class ViewImpl extends Composite implements IView, Handler {

	private static ViewUiBinder uiBinder = GWT
			.create(ViewUiBinder.class);
	
	@UiTemplate("View.ui.xml")
	interface ViewUiBinder extends UiBinder<Widget, ViewImpl> {
	}

	/**
	 * The main DataGrid.
	 */
	@UiField(provided = true)
	DataGrid<Taxon> dataGrid;

	/**
	 * The pager used to change the range of data.
	 */
	@UiField(provided = true)
	SimplePager pager;
	
	private ListDataProvider<Taxon> dataProvider;
	private ProvidesKey<Taxon> TaxonKeyProvider = new ProvidesKey<Taxon>() {
		@Override
		public Object getKey(Taxon item) {
			return item == null ? null : item.getId();
		}
	};
	
	private SimplePager createPager() {
	    SimplePager.Resources pagerResources = GWT.create(SimplePager.Resources.class);
	    SimplePager pager = new SimplePager(TextLocation.CENTER, pagerResources, false, 0, true);
		return pager;
	}
	private SingleSelectionModel<Taxon> selectionModel;

	private List<String> characterNames = new LinkedList<String>();

	private Presenter presenter;

	private HandlerRegistration sortHandlerRegistration;
	
	public ViewImpl() {
		dataProvider = new ListDataProvider<Taxon>();
		dataGrid = createDataGrid();
	    dataProvider.addDataDisplay(dataGrid);
		pager = createPager();
		pager.setDisplay(dataGrid);
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	private DataGrid<Taxon> createDataGrid() {
		DataGrid<Taxon> dataGrid = new DataGrid<Taxon>(TaxonKeyProvider);
		dataGrid.setAutoHeaderRefreshDisabled(true);
		dataGrid.setAutoFooterRefreshDisabled(true);
		buildDataGrid(dataGrid);
		return dataGrid;
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	/**
	 * Add the columns to the table.
	 * @param dataGrid2 
	 */
	private void buildDataGrid(DataGrid<Taxon> dataGrid) {
		int columnCount = dataGrid.getColumnCount();
		for(int i=0; i < columnCount; i++) {
			dataGrid.removeColumn(0);
		}
		if(sortHandlerRegistration != null)
			sortHandlerRegistration.removeHandler();
		ListHandler<Taxon> sortHandler = new ListHandler<Taxon>(dataProvider.getList());
	    sortHandlerRegistration = dataGrid.addColumnSortHandler(sortHandler);
	    selectionModel = new SingleSelectionModel<Taxon>(TaxonKeyProvider);
	    dataGrid.setSelectionModel(selectionModel);//, DefaultSelectionEventManager.<Taxon> createCheckboxManager());
		selectionModel.addSelectionChangeHandler(this);
	    
		for(final String characterName : characterNames) {
			Column<Taxon, String> column = new Column<Taxon, String>(
					new EditTextCell()) {
				@Override
				public String getValue(Taxon object) {
					return object.getCharacterState(characterName);
				}
			};
			column.setSortable(true);
			sortHandler.setComparator(column,
					new Comparator<Taxon>() {
						@Override
						public int compare(Taxon o1, Taxon o2) {
							return o1.getCharacterState(characterName)
									.compareTo(o2.getCharacterState(characterName));
						}
					});
			DnDTextHeader header = new DnDTextHeader(characterName);
			dataGrid.addColumn(column, header);
			column.setFieldUpdater(new FieldUpdater<Taxon, String>() {
						@Override
						public void update(int index, Taxon object,
								String value) {
							// Called when the user changes the value.
							object.setCharacterState(characterName, value);
						}
					});
			dataGrid.setColumnWidth(column, 20, Unit.PCT);
		}
	}
	
	@Override
	public void setCharacterNames(List<String> characterNames) {
		this.characterNames = characterNames;
		this.buildDataGrid(dataGrid);
	}
	
	@Override
	public void setTaxons(List<Taxon> taxons) {
		List<Taxon> taxonList = dataProvider.getList();
		taxonList.clear();
		taxonList.addAll(taxons);
	}

	@Override
	public void onSelectionChange(SelectionChangeEvent event) {
		
	}

	@Override
	public void updateTaxon(Taxon taxon) {
		List<Taxon> Taxons = dataProvider.getList();
		Iterator<Taxon> TaxonsIterator = Taxons.iterator();
		
		boolean found = false;
		while(TaxonsIterator.hasNext()) {
			Taxon listTaxon = TaxonsIterator.next();
			if(listTaxon.getId()==taxon.getId()) {
				TaxonsIterator.remove();
				found = true;
			}
		}
		if(found)
			Taxons.add(taxon);
	}

	@Override
	public void removeTaxon(Taxon taxon) {
		List<Taxon> Taxons = dataProvider.getList();
		Iterator<Taxon> TaxonsIterator = Taxons.iterator();
		while(TaxonsIterator.hasNext()) {
			Taxon listTaxon = TaxonsIterator.next();
			if(listTaxon.getId()==taxon.getId()) {
				TaxonsIterator.remove();
			}
		}
	}

	@Override
	public void resetSelection() {
		this.selectionModel.clear();
	}

	@Override
	public void addTaxon(Taxon taxon) {
		List<Taxon> taxons = dataProvider.getList();
		taxons.add(taxon);
	}

	@Override
	public Taxon getSelectedTaxon() {
		return selectionModel.getSelectedObject();
	}
}
