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

package org.openmrs.mobile.activities.visit.visittasks;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.openmrs.mobile.R;
import org.openmrs.mobile.activities.visit.VisitContract;
import org.openmrs.mobile.activities.visit.VisitFragment;
import org.openmrs.mobile.models.Visit;
import org.openmrs.mobile.models.VisitPredefinedTask;
import org.openmrs.mobile.models.VisitTask;
import org.openmrs.mobile.models.VisitTaskStatus;
import org.openmrs.mobile.utilities.ApplicationConstants;
import org.openmrs.mobile.utilities.DateUtils;
import org.openmrs.mobile.utilities.FontsUtil;
import org.openmrs.mobile.utilities.ToastUtil;
import org.openmrs.mobile.utilities.ViewUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class VisitTasksFragment extends VisitFragment implements VisitContract.VisitTasksView {

	FloatingActionButton fab;
	private View mRootView;
	private RecyclerView openViewTasksRecyclerView;
	private LinearLayoutManager layoutManager;
	private LinearLayout addTaskLayout;
	private LinearLayout closedTasksLayout;

	private List<VisitPredefinedTask> predefinedTasks;
	private List<VisitTask> visitTasksLists;
	private Visit visit;
	private AutoCompleteTextView addtask;
	private TextView noVisitTasks;
	private Map<String, List<VisitTask>> groupedClosedTasks = new LinkedHashMap<>();

	public static VisitTasksFragment newInstance() {
		return new VisitTasksFragment();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setPresenter(mPresenter);
		setHasOptionsMenu(true);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		mRootView = inflater.inflate(R.layout.fragment_visit_tasks, container, false);
		resolveViews(mRootView);

		//Adding the Recycler view
		layoutManager = new LinearLayoutManager(this.getActivity());
		openViewTasksRecyclerView.setLayoutManager(layoutManager);

		addListeners();
		// Font config
		FontsUtil.setFont((ViewGroup)this.getActivity().findViewById(android.R.id.content));
		return mRootView;
	}

	private void resolveViews(View v) {
		openViewTasksRecyclerView = (RecyclerView)v.findViewById(R.id.openVisitTasksRecyclerView);
		fab = (FloatingActionButton)v.findViewById(R.id.visitTaskFab);
		addtask = (AutoCompleteTextView)v.findViewById(R.id.addVisitTasks);
		addTaskLayout = (LinearLayout)v.findViewById(R.id.addTaskLayout);
		closedTasksLayout = (LinearLayout)v.findViewById(R.id.closedTasksLayout);

		noVisitTasks = (TextView)v.findViewById(R.id.noVisitTasks);
	}

	@Override
	public void showToast(String message, ToastUtil.ToastType toastType) {

	}

	@Override
	public void setOpenVisitTasks(List<VisitTask> visitTaskList) {
		this.visitTasksLists = visitTaskList;
		if (visit != null) {
			if (visitTaskList.size() != 0) {
				VisitTasksRecyclerViewAdapter adapter =
						new VisitTasksRecyclerViewAdapter(this.getActivity(), visitTaskList, visit, this);
				openViewTasksRecyclerView.setAdapter(adapter);

				//visitTasksRecyclerViewAdapter.addOnScrollListener(recyclerViewOnScrollListener)
				openViewTasksRecyclerView.setVisibility(View.VISIBLE);
				noVisitTasks.setVisibility(View.GONE);
			} else {
				openViewTasksRecyclerView.setVisibility(View.GONE);
				noVisitTasks.setVisibility(View.VISIBLE);
			}
		}
		addTaskOnFocusListener();
	}

	@Override
	public void setClosedVisitTasks(List<VisitTask> visitTaskList) {
		groupedClosedTasks.clear();
		closedTasksLayout.removeAllViews();
		for (VisitTask task : visitTaskList) {
			String relativeDate = DateUtils.calculateRelativeDate(task.getClosedOn());
			if (groupedClosedTasks.containsKey(relativeDate)) {
				groupedClosedTasks.get(relativeDate).add(task);
			} else {
				List<VisitTask> tasks = new ArrayList<>();
				tasks.add(task);
				groupedClosedTasks.put(relativeDate, tasks);
			}
		}

		if (!groupedClosedTasks.isEmpty()) {
			for (Map.Entry<String, List<VisitTask>> set : groupedClosedTasks.entrySet()) {
				CardView cardView = new CardView(getContext());
				cardView.setCardBackgroundColor(Color.WHITE);
				cardView.setContentPadding(10, 10, 10, 50);

				LinearLayout.LayoutParams cardViewParams =
						new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
								LinearLayout.LayoutParams.WRAP_CONTENT);
				cardViewParams.setMargins(0, 20, 0, 20);
				cardView.setLayoutParams(cardViewParams);

				LinearLayout linearLayout = new LinearLayout(getContext());
				LinearLayout.LayoutParams params =
						new LinearLayout.LayoutParams(
								LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
				linearLayout.setLayoutParams(params);
				linearLayout.setOrientation(LinearLayout.VERTICAL);

				TextView closedTaskTitle = new TextView(getContext());
				closedTaskTitle.setTypeface(Typeface.DEFAULT_BOLD);
				closedTaskTitle.setText(getString(R.string.nav_closed_visit_tasks_period, set.getKey()));
				linearLayout.addView(closedTaskTitle);

				RecyclerView closedRecyclerView = new RecyclerView(getContext());
				VisitTasksRecyclerViewAdapter adapter =
						new VisitTasksRecyclerViewAdapter(this.getActivity(), set.getValue(), visit, this);
				closedRecyclerView.setAdapter(adapter);

				closedRecyclerView.setLayoutParams(
						new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
								LinearLayout.LayoutParams.MATCH_PARENT));

				LinearLayoutManager layoutManagerClosed = new LinearLayoutManager(this.getActivity());
				closedRecyclerView.setLayoutManager(layoutManagerClosed);
				linearLayout.addView(closedRecyclerView);

				cardView.addView(linearLayout);
				closedTasksLayout.addView(cardView);
			}
		}
	}

	public void addTaskOnFocusListener() {
		ArrayAdapter adapter =
				new ArrayAdapter<>(getContext(), android.R.layout.simple_dropdown_item_1line,
						removeUsedPredefinedTasks(predefinedTasks, visitTasksLists));
		addtask.setAdapter(adapter);

		addtask.setOnFocusChangeListener(new View.OnFocusChangeListener() {
			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if (addtask.getText().length() >= addtask.getThreshold()) {
					addtask.showDropDown();
				}
				if (Arrays.asList(removeUsedPredefinedTasks(predefinedTasks, visitTasksLists))
						.contains(addtask.getText().toString())) {
					addtask.dismissDropDown();
				}
			}
		});
	}

	public void addListeners() {
		addtask.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (ViewUtils.getInput(addtask) != null) {
					((VisitTasksPresenter)mPresenter).createVisitTasksObject(ViewUtils.getInput(addtask));
				}
			}
		});
	}

	@Override
	public void setPredefinedTasks(List<VisitPredefinedTask> predefinedTasks) {
		this.predefinedTasks = predefinedTasks;
	}

	@Override
	public void setSelectedVisitTask(VisitTask visitTask) {
		visitTask.setStatus(VisitTaskStatus.CLOSED);
		((VisitTasksPresenter)mPresenter).updateVisitTask(visitTask);
	}

	@Override
	public void setUnSelectedVisitTask(VisitTask visitTask) {
		visitTask.setStatus(VisitTaskStatus.OPEN);
		((VisitTasksPresenter)mPresenter).updateVisitTask(visitTask);
	}

	@Override
	public void refresh() {
		((VisitTasksPresenter)mPresenter).getVisit();
		((VisitTasksPresenter)mPresenter).getPredefinedTasks();
		((VisitTasksPresenter)mPresenter).getVisitTasks();
	}

	@Override
	public void setVisit(Visit visit) {
		this.visit = visit;
		if (!visit.getStopDatetime().equalsIgnoreCase(null)) {
			addTaskLayout.setVisibility(View.GONE);
		}
	}

	@Override
	public void clearTextField() {
		addtask.setText(ApplicationConstants.EMPTY_STRING);
	}

	public List<VisitPredefinedTask> removeUsedPredefinedTasks(List<VisitPredefinedTask> visitPredefinedTask,
			List<VisitTask> visitTask) {
		if (visitPredefinedTask.size() != 0) {
			String visitTasksName, predefinedTaskName;
			VisitTaskStatus visitTaskStatus;

			for (int q = 0; q < visitTask.size(); q++) {
				visitTasksName = visitTask.get(q).getName();
				visitTaskStatus = visitTask.get(q).getStatus();

				for (int i = 0; i < visitPredefinedTask.size(); i++) {
					predefinedTaskName = predefinedTasks.get(i).getName();

					if ((predefinedTaskName.equalsIgnoreCase(visitTasksName)) && (visitTaskStatus
							.equals(VisitTaskStatus.OPEN))) {
						visitPredefinedTask.remove(i);
					}
				}
			}

			return visitPredefinedTask;
		} else {
			return visitPredefinedTask;
		}
	}
}
