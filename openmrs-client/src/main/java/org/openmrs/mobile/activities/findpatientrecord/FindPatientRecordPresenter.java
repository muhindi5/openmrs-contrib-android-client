/*
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */

package org.openmrs.mobile.activities.findpatientrecord;

import android.os.Bundle;
import android.support.annotation.NonNull;

import org.openmrs.mobile.activities.BasePresenter;
import org.openmrs.mobile.data.DataService;
import org.openmrs.mobile.data.PagingInfo;
import org.openmrs.mobile.data.QueryOptions;
import org.openmrs.mobile.data.impl.PatientDataService;
import org.openmrs.mobile.models.Patient;
import org.openmrs.mobile.utilities.ApplicationConstants;

import java.util.List;

public class FindPatientRecordPresenter extends BasePresenter implements FindPatientRecordContract.Presenter {

	@NonNull
	private FindPatientRecordContract.View findPatientView;
	private int page = 0;
	private int limit = 10;
	private PatientDataService patientDataService;
	private boolean loading;

	public FindPatientRecordPresenter(@NonNull FindPatientRecordContract.View view, String lastQuery) {
		this.findPatientView = view;
		this.findPatientView.setPresenter(this);
		this.patientDataService = new PatientDataService();
	}

	public FindPatientRecordPresenter(@NonNull FindPatientRecordContract.View view) {
		this.findPatientView = view;
		this.findPatientView.setPresenter(this);
		this.patientDataService = new PatientDataService();
	}

	@Override
	public void subscribe() {
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {

	}

	public void findPatient(String query) {
		findPatientView.setProgressBarVisibility(true);
		findPatientView.setFetchedPatientsVisibility(false);
		PagingInfo pagingInfo = new PagingInfo(page, 100);
		DataService.GetCallback<List<Patient>> getMultipleCallback = new DataService.GetCallback<List<Patient>>() {
			@Override
			public void onCompleted(List<Patient> patients) {
				findPatientView.setProgressBarVisibility(false);
				if (patients.isEmpty()) {
					findPatientView.setNumberOfPatientsView(0);
					findPatientView.setNoPatientsVisibility(true);
					findPatientView.setFetchedPatientsVisibility(false);
				} else {
					findPatientView.setNoPatientsVisibility(false);
					findPatientView.setNumberOfPatientsView(patients.size());
					findPatientView.setFetchedPatientsVisibility(true);
					findPatientView.fetchPatients(patients);
				}
			}

			@Override
			public void onError(Throwable t) {
				findPatientView.setProgressBarVisibility(false);
			}
		};
		patientDataService.findByNameAndIdentifier(query, QueryOptions.LOAD_RELATED_OBJECTS, pagingInfo,
				getMultipleCallback);
	}

	public void getLastViewed() {
		findPatientView.setProgressBarVisibility(true);
		findPatientView.setFetchedPatientsVisibility(false);
		setLoading(true);
		PagingInfo pagingInfo = new PagingInfo(page, limit);
		patientDataService.getLastViewed(ApplicationConstants.EMPTY_STRING, QueryOptions.LOAD_RELATED_OBJECTS, pagingInfo,
				new DataService.GetCallback<List<Patient>>() {
					@Override
					public void onCompleted(List<Patient> patients) {
						findPatientView.setProgressBarVisibility(false);

						if (!patients.isEmpty()) {
							findPatientView.setNumberOfPatientsView(0);
							findPatientView.setFetchedPatientsVisibility(true);
							findPatientView.fetchPatients(patients);
						} else {
							findPatientView.setNumberOfPatientsView(patients.size());
							findPatientView.setFetchedPatientsVisibility(false);
						}
						setLoading(false);
					}

					@Override
					public void onError(Throwable t) {
						setLoading(false);
						findPatientView.setProgressBarVisibility(false);
					}
				});
	}

	@Override
	public boolean isLoading() {
		return loading;
	}

	@Override
	public void setLoading(boolean loading) {
		this.loading = loading;
	}

	@Override
	public void loadResults(boolean loadNextResults) {
		getLastViewed();
	}

	@Override
	public void refresh() {
	}

	@Override
	public int getPage() {
		return page;
	}

	@Override
	public void setPage(int page) {

	}
}
