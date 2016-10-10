package com.packtpub.celebrities.util;

import java.util.List;

import org.apache.tapestry5.beaneditor.PropertyModel;
import org.apache.tapestry5.grid.GridDataSource;
import org.apache.tapestry5.grid.SortConstraint;

import com.packtpub.celebrities.data.IDataSource;
import com.packtpub.celebrities.model.Celebrity;

public class CelebritySource implements GridDataSource {

	private IDataSource dataSource;
	private List<Celebrity> selection;
	private int indexFrom;

	public CelebritySource(IDataSource ds) {
		this.dataSource = ds;
	}

	public int getAvailableRows() {
		return dataSource.getAllCelebrities().size();
	}

	public void prepare(int indexFrom, int indexTo,
			PropertyModel propertyModel, boolean ascending) {
		System.out.println("Preparing selection.");
		System.out.println("Index from " + indexFrom + " to " + indexTo);
		String propertyName = propertyModel == null ? null : propertyModel
				.getPropertyName();
		System.out.println("Property name is: " + propertyName);
		System.out.println("Sorting order ascending: " + ascending);
		selection = dataSource.getRange(indexFrom, indexTo);
		this.indexFrom = indexFrom;
	}

	public Object getRowValue(int i) {
		System.out.println("Getting value for row " + i);
		return selection.get(i - this.indexFrom);
	}

	public Class<Celebrity> getRowType() {
		return Celebrity.class;
	}

	public void prepare(int indexFrom, int indexTo,
			List<SortConstraint> sortConstraints) {
		System.out.println("Preparing selection.");
		System.out.println("Index from " + indexFrom + " to " + indexTo);
		//String propertyName = propertyModel == null ? null : propertyModel.getPropertyName();
		//System.out.println("Property name is: " + propertyName);
		//System.out.println("Sorting order ascending: " + ascending);
		selection = dataSource.getRange(indexFrom, indexTo);
		this.indexFrom = indexFrom;
		
	}
}
